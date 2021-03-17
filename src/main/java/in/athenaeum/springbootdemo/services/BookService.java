package in.athenaeum.springbootdemo.services;

import in.athenaeum.springbootdemo.exceptions.DomainValidationException;
import in.athenaeum.springbootdemo.exceptions.RecordNotFoundException;
import in.athenaeum.springbootdemo.models.Book;
import in.athenaeum.springbootdemo.repositories.BookRepository;
import in.athenaeum.springbootdemo.viewmodels.BookCreateViewModel;
import in.athenaeum.springbootdemo.viewmodels.BookListViewModel;
import in.athenaeum.springbootdemo.viewmodels.BookUpdateViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookListViewModel> getAll() {
        return this.bookRepository.findAll()
                .stream()
                .map(b -> new BookListViewModel(
                        b.getTitle(),
                        b.getAuthor(),
                        b.getPrice(),
                        b.getnPages()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public BookListViewModel getById(long id) {
       Book bookDb =  this.bookRepository.findById(id)
               .orElseThrow(() -> new RecordNotFoundException("Could not find " + id));

       return new BookListViewModel(
               bookDb.getTitle(),
               bookDb.getAuthor(),
               bookDb.getPrice(),
               bookDb.getnPages()
       );
    }

    @Override
    public void create(BookCreateViewModel viewModel) {
        if (viewModel.getTitle().trim().length() == 0) {
            throw new DomainValidationException("Title is not valid");
        }

        Book book = new Book();

        BeanUtils.copyProperties(viewModel, book);

        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public void update(long id, BookUpdateViewModel viewModel) {
        if (id != viewModel.getId()) {
            throw new DomainValidationException("Id does not match");
        }

        Book bookDb = this.bookRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Could not find " + id));

        BeanUtils.copyProperties(viewModel, bookDb);
        this.bookRepository.saveAndFlush(bookDb);
    }

    @Override
    public void delete(long id) {
        this.bookRepository.deleteById(id);
    }
}
