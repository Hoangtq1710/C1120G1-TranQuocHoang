package com.soren.repository;

import com.soren.model.Email;

import java.util.List;

public interface EmailRepository {
    List<String> getListLanguage();

    List<Integer> getListPageSize();

    void save(Email email);

    Email getEmailSetting();

    void update(Email email);
}
