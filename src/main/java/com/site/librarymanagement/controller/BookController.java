package com.site.librarymanagement.controller;

import com.site.librarymanagement.model.Book;
import com.site.librarymanagement.service.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE BOOK
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    // GET ALL BOOKS
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // GET BOOK BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // UPDATE BOOK
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @RequestBody Book book) {

        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> patchBook(
            @PathVariable Long id,
            @RequestBody Book book) {

        Book existingBook = bookService.getBookById(id);

        if (book.getTitle() != null) {
            existingBook.setTitle(book.getTitle());
        }

        if (book.getAuthor() != null) {
            existingBook.setAuthor(book.getAuthor());
        }

        if (book.getIsbn() != null) {
            existingBook.setIsbn(book.getIsbn());
        }

        if (book.getCategory() != null) {
            existingBook.setCategory(book.getCategory());
        }

        if (book.getQuantity() > 0) {
            existingBook.setQuantity(book.getQuantity());
        }

        existingBook.setAvailable(book.isAvailable());

        return ResponseEntity.ok(bookService.createBook(existingBook));
    }

    // DELETE BOOK
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

        return ResponseEntity.ok("Book deleted successfully");
    }
}
