package com.currency.controller;

import com.currency.service.IExchangeService;
import com.currency.service.impl.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyExchangeController {
    @Autowired
    IExchangeService exchangeService;
    @GetMapping("/form")
    public String showExchange() {
        return "/exchange";
    }
    @GetMapping("/exchange")
    public ModelAndView exchange(@RequestParam double amount) {
        return new ModelAndView ("/exchange","result", exchangeService.exchange(amount));
    }
}
