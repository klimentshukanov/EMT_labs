package com.example.emt_labs_201100.web;

import com.example.emt_labs_201100.model.Book;
import com.example.emt_labs_201100.model.dto.BookDto;
import com.example.emt_labs_201100.model.enums.Category;
import com.example.emt_labs_201100.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping({"/", "/books"})
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listAll()
    {
        return bookService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id)
    {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto BookDto) {
        return this.bookService.edit(id, BookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/rent/{id}")
    public ResponseEntity<Book> rentBook(@PathVariable Long id)
    {
        return this.bookService.rentBook(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/categories")
    public List<Category> listAllCategories()
    {
        return Arrays.stream(Category.values()).toList();
    }

}
