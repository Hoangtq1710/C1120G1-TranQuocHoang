package com.soren.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository{
    static TreeMap<String, String> map = new TreeMap<>();
    static {

        map.put("star","ngoi sao");
        map.put("sky","bau troi");
        map.put("development","phat trien");
        map.put("keyboard","ban phim");
        map.put("control","dieu khien");
        map.put("water","nuoc");
        map.put("chemistry","hoa hoc");
        map.put("love","tinh yeu");
    }

    @Override
    public String translate(String input) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(input)) {
                return entry.getValue();
            }
        }
        return "";
    }

    @Override
    public List<String> getAllKey() {
        List<String> listKey = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            listKey.add(entry.getKey());
        }
        return listKey;
    }
}
