package com.site.librarymanagement.service;

import com.site.librarymanagement.model.Book;
import com.site.librarymanagement.repo.BookRepo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    // Constructor injection
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    // CREATE BOOK
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    // GET ALL BOOKS
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // GET BOOK BY ID
    public Book getBookById(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found with ID: " + id));
    }

    // UPDATE BOOK
    public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = getBookById(id);

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setCategory(updatedBook.getCategory());
        existingBook.setQuantity(updatedBook.getQuantity());
        existingBook.setAvailable(updatedBook.isAvailable());

        return bookRepo.save(existingBook);
    }

    // DELETE BOOK
    public void deleteBook(Long id) {

        if (!bookRepo.existsById(id)) {
            throw new RuntimeException("Book not found with ID: " + id);
        }

        bookRepo.deleteById(id);
    }
}
