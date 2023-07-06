package com.info.infoprimeraapp.service.bookService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.domain.Book;

public interface BookService {

    Book getBookByName(String name);

    List<Book> getAllBooks();

    Book createBook(@RequestBody Book book);
}
