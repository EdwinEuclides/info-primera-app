package com.info.infoprimeraapp.service.bookService.impl;

import java.util.ArrayList;
import java.util.List;
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
        Book b1 = new Book("patito feo", "Autor de patito");
        Book b2 = new Book("Jugando futobol", "Maradona");
        Book b3 = new Book("Pasar el rio", "Nadadores");
        Book b4 = new Book("cocina Facil", "Cocinero");
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

}
