package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String dictionary() {
        return "/dictionary";
    }

    @GetMapping("/result")
    public ModelAndView translate(@RequestParam String vocabulary) {
        if (dictionaryService.showVocabulary(vocabulary) == null) {
            return new ModelAndView("dictionary", "notfound", "not found");
        }
        return new ModelAndView("dictionary", "vietnam", dictionaryService.showVocabulary(vocabulary));
    }
}
