package com.soren.service;

import java.util.List;

public interface DictionaryService {
    String translate (String input);

    List<String> getAllKey();

}
