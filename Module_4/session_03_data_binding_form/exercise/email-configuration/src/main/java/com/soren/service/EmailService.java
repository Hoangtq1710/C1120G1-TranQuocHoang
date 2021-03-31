package com.soren.service;

import com.soren.model.Email;

import java.util.List;

public interface EmailService {
    List<String> getListLanguage();

    List<Integer> getListPageSize();

    void save(Email email);

    Email getEmailSetting();

    void update(Email email);
}

