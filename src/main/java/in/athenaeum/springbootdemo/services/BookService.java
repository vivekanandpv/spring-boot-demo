package in.athenaeum.springbootdemo.services;

import in.athenaeum.springbootdemo.models.Book;
import in.athenaeum.springbootdemo.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book getById(long id) {
       return this.bookRepository.findById(id).get();
    }

    @Override
    public void create(Book book) {
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public void update(long id, Book book) {
        Book bookDb = this.getById(id);
        BeanUtils.copyProperties(book, bookDb);
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public void delete(long id) {
        this.bookRepository.deleteById(id);
    }
}
