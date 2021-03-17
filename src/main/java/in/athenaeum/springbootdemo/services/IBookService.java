package in.athenaeum.springbootdemo.services;

import in.athenaeum.springbootdemo.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book getById(long id);
    void create(Book book);
    void update(long id, Book book);
    void delete(long id);
}
