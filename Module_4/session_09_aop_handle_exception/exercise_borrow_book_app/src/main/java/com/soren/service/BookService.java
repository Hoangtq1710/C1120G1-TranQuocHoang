package com.soren.service;

import com.soren.model.Book;
import com.soren.service.exception.QuantityEqualsZeroException;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Integer code);

    void decreasingBookQuantity(Book book) throws QuantityEqualsZeroException;

    void increasingBookQuantity(Book book);

    boolean checkingCodeBook(Integer code);
}
