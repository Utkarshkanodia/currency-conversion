package com.omega.currrencyconversion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omega.currrencyconversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService service;

    // list all currency
    @GetMapping("/list-currencies")
    public List<String> getAllCurrency() {
        return service.listAllCurrency();
    }

    // latest from to
    @GetMapping("/convert/from/{from}/to/{to}")
    public Double convert(@PathVariable("from") String from, @PathVariable("to") String to,
            @RequestParam(value = "quantity", defaultValue = "1") Integer quantity) {
        return service.getLatestRate(from, to) * quantity;
    }

}
