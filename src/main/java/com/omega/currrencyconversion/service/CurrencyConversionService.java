package com.omega.currrencyconversion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omega.currencyglobalcore.dao.CurrencyDataDao;
import com.omega.currencyglobalcore.dao.CurrencyRateDao;
import com.omega.currencyglobalcore.utility.Helper;

@Service
public class CurrencyConversionService {

    @Autowired
    private CurrencyDataDao dataDao;

    @Autowired
    private CurrencyRateDao rateDao;

    public List<String> listAllCurrency() {
        return dataDao.findAll().stream().map(data -> data.getCode()).toList();
    }

    public Double getLatestRate(String from, String to) {
        return rateDao.findRate(from, to, Helper.getTodayDate());
    }

}
