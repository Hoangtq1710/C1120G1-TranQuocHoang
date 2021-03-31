package com.soren.service.impl;

import com.soren.model.Email;
import com.soren.repository.EmailRepository;
import com.soren.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository repository;

    @Override
    public List<String> getListLanguage() {
        return repository.getListLanguage();
    }

    @Override
    public List<Integer> getListPageSize() {
        return repository.getListPageSize();
    }

    @Override
    public void save(Email email) {
        repository.save(email);
    }

    @Override
    public Email getEmailSetting() {
        return repository.getEmailSetting();
    }

    @Override
    public void update(Email email) {
        repository.update(email);
    }
}
