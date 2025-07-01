package com.api.book.bootrestbook.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.Dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get single book
    public Book getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    // Add new book
    public Book addBook(Book b) {
        return bookRepository.save(b);
    }

    // Delete book
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    // Update book
    public Book updateBook(Book book, int id) {
        book.setId(id);
        return bookRepository.save(book);
    }
}
