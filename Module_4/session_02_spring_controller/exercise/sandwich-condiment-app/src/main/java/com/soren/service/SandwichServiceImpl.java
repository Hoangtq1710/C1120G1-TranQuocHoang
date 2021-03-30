package com.soren.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SandwichServiceImpl implements SandwichService{
    @Override
    public List<String> getListCondiment(String[] condiments) {
        return Arrays.asList(condiments);
    }
}
