package com.soren.service;

import com.soren.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    DictionaryRepository repository;

    @Override
    public String translate(String input) {
        return repository.translate(input);
    }

    @Override
    public List<String> getAllKey() {
        return repository.getAllKey();
    }
}
