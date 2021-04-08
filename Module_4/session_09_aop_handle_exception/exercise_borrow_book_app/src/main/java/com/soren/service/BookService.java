package com.soren.service;

import com.soren.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Integer code);

    boolean decreasingBookQuantity(Book book);

    void increasingBookQuantity(Book book);

    boolean checkingCodeBook(Integer code);
}
