package com.info.infoprimeraapp.service.bookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;

import com.domain.Book;

public interface BookService {

    Book getBookByName(String name);

    List<Book> getAllBooks();

    Book createBook(@RequestBody Book book);

    Optional<Book> updatBook(UUID id, Book bookUpdated);

    String deleteBook(UUID idBook);

}
