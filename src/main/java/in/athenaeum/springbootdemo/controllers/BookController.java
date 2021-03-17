package in.athenaeum.springbootdemo.controllers;

import in.athenaeum.springbootdemo.models.Book;
import in.athenaeum.springbootdemo.services.IBookService;
import in.athenaeum.springbootdemo.viewmodels.BookCreateViewModel;
import in.athenaeum.springbootdemo.viewmodels.BookListViewModel;
import in.athenaeum.springbootdemo.viewmodels.BookUpdateViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookListViewModel>> getAll() {
        return new ResponseEntity<>(
                this.bookService.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<BookListViewModel> getById(@PathVariable long id) {
        return new ResponseEntity<>(
                this.bookService.getById(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookCreateViewModel book) {
        this.bookService.create(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody BookUpdateViewModel book, @PathVariable long id) {
        this.bookService.update(id, book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        this.bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
