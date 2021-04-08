package com.soren.service;

import com.soren.model.Book;
import com.soren.repository.BookRepository;
import com.soren.service.exception.QuantityEqualsZeroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Integer code) {
        return repository.findById(code).orElse(null);
    }

    @Override
    public void decreasingBookQuantity(Book book) throws QuantityEqualsZeroException {
        if (book.getQuantity() > 0){
            book.setQuantity(book.getQuantity()-1);
            repository.save(book);
        } else {
            throw new QuantityEqualsZeroException();
        }
    }

    @Override
    public void increasingBookQuantity(Book book) {
        book.setQuantity(book.getQuantity() +1);
        repository.save(book);
    }

    @Override
    public boolean checkingCodeBook(Integer code) {
        for(Book book : this.findAll()){
            if (book.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
}
