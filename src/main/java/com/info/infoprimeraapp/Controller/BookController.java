package com.info.infoprimeraapp.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/api/v1/book_pv/{title}") // Esto no funciono
    public ResponseEntity<Book> getBookByTitle1(@PathVariable("title") String titulo) {
        Book book = this.bookService.getBookByName(titulo);
        if (book != null)
            return ResponseEntity.ok(book);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/v1/books")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("/api/v1/book1")
    public Book createBook(@RequestBody Book book) {
        return this.bookService.createBook(book);
    }

    @PutMapping("/api/v1/book/{idBook}")
    public String updateBook(@PathVariable(name = "idBook") UUID idBook, @RequestBody Book bookUpdated) {

        Optional<Book> book = this.bookService.updatBook(idBook, bookUpdated);
        if (book.isPresent())
            return book.get().toString();
        else
            return "No se encontró un libro con ese id.";
    }

    @DeleteMapping("/api/v1/book/{idBook}")
    public String deleteBook(@PathVariable(name = "idBook") UUID idBook) {
        System.out.println("Entró a DeleteMapping");
        return this.bookService.deleteBook(idBook);
    }

}
