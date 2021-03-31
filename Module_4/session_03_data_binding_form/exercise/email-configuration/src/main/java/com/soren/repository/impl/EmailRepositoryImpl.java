package com.soren.repository.impl;

import com.soren.model.Email;
import com.soren.repository.EmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepositoryImpl implements EmailRepository {

    static List<String> listLanguage;
    static List<Integer> listPageSize;
    static List<Email> listEmail;

    static {
        listLanguage = new ArrayList<>();
        listPageSize = new ArrayList<>();
        listEmail = new ArrayList<>();

        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");

        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
    }

    @Override
    public List<String> getListLanguage() {
        return listLanguage;
    }

    @Override
    public List<Integer> getListPageSize() {
        return listPageSize;
    }

    @Override
    public void save(Email email) {
        listEmail.add(email);
    }

    @Override
    public Email getEmailSetting() {
        return listEmail.get(0);
    }

    @Override
    public void update(Email email) {

        listEmail.clear();
        listEmail.add(email);
    }
}
