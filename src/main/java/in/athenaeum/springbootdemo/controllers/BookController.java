package in.athenaeum.springbootdemo.controllers;

import in.athenaeum.springbootdemo.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<List<Book>>(new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        return new ResponseEntity<Book>(new Book(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book book) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Book book, @PathVariable long id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return ResponseEntity.ok().build();
    }
}
