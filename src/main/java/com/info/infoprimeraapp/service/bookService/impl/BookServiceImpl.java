package com.info.infoprimeraapp.service.bookService.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.domain.Book;
import com.info.infoprimeraapp.service.bookService.BookService;

@Service
public class BookServiceImpl implements BookService {

    List<Book> lstBooks;

    public BookServiceImpl() {
        cargaInicial();
    }

    @Override
    public Book getBookByName(String name) {

        for (Book book : lstBooks) {
            if (book.getTitle().equalsIgnoreCase(name))
                return book;
        }

        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return lstBooks;
    }

    private void cargaInicial() {
        lstBooks = new ArrayList<>();
        Book b1 = new Book(UUID.randomUUID(), "patito feo", "Autor de patito");
        Book b2 = new Book(UUID.randomUUID(), "Jugando futobol", "Maradona");
        Book b3 = new Book(UUID.randomUUID(), "Pasar el rio", "Nadadores");
        Book b4 = new Book(UUID.randomUUID(), "cocina Facil", "Cocinero");
        lstBooks.add(b1);
        lstBooks.add(b2);
        lstBooks.add(b3);
        lstBooks.add(b4);
    }

    @Override
    public Book createBook(Book book) {
        book.setId(UUID.randomUUID());
        book.setTitle("titulo nuevo");
        this.lstBooks.add(book);
        return book;
    }

    @Override
    public Optional<Book> updatBook(UUID id, Book bookUpdated) {

        Book bookToUpdate = findBook(id);
        if (bookToUpdate != null) {
            if (bookToUpdate.getTitle() != null)
                bookToUpdate.setTitle(bookUpdated.getTitle());

            if (bookToUpdate.getAuthor() != null)
                bookToUpdate.setAuthor(bookToUpdate.getAuthor());
            return Optional.of(bookToUpdate);
        }

        return Optional.empty();

    }

    @Override
    public String deleteBook(UUID idBook) {
        Book bookToDelete = findBook(idBook);
        if (bookToDelete != null) {
            if (lstBooks.remove(bookToDelete))
                return "Libro el eliminado";
            else
                return "No se pudo eliminar el Libro.";
        }

        return "No se encotro el libro.";
    }

    private Book findBook(UUID id) {

        for (Book book : lstBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
