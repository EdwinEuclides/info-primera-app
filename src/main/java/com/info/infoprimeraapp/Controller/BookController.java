package com.info.infoprimeraapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Book;
import com.info.infoprimeraapp.service.bookService.BookService;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get --> Obtener
    // http://localhost:8080/aplicacion/v1/despedida
    @GetMapping("/aplicacion/v1/despedida")
    public String goodByeWorld() {
        return "Adios mundo cruel";
    }

    @GetMapping("/aplicacion/v1/saludo")
    public String helloWorld(@RequestParam(required = true, name = "nombre") String nombre) {
        return "Hello " + nombre;
    }

    @GetMapping("/api/v1/book")
    public Book getBookByTitle(@RequestParam(required = true, name = "title") String title) {
        return this.bookService.getBookByName(title);
    }

    @GetMapping("/api/v1/books")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("/api/v1/book1")
    public Book createBook(@RequestBody Book book) {
        return this.bookService.createBook(book);
    }
}
