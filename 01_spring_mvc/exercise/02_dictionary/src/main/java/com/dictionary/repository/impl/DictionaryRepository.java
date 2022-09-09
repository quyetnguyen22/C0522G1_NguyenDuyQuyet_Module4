package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    Map<String, String> vocabularyMap = new HashMap<>();

    @Override
    public String showVocabulary(String vocabulary) {
        vocabularyMap.put("helicopter", "trực thăng");
        vocabularyMap.put("yummy", "ngon");
        return vocabularyMap.get(vocabulary);
    }
}

