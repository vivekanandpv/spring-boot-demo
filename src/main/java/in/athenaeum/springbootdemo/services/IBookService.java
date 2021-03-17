package in.athenaeum.springbootdemo.services;

import in.athenaeum.springbootdemo.models.Book;
import in.athenaeum.springbootdemo.viewmodels.BookCreateViewModel;
import in.athenaeum.springbootdemo.viewmodels.BookListViewModel;
import in.athenaeum.springbootdemo.viewmodels.BookUpdateViewModel;

import java.util.List;

public interface IBookService {
    List<BookListViewModel> getAll();
    BookListViewModel getById(long id);
    void create(BookCreateViewModel book);
    void update(long id, BookUpdateViewModel book);
    void delete(long id);
}
