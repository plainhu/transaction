package com.plainhu.bank1.rest;

import com.plainhu.bank1.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2021-02-06 14:37:47
 * @author: hkt
 * @desc:
 */
@RestController
@RequestMapping("bank1")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @GetMapping("tobank2")
    public String transfer() {
        return moneyService.transfer(100);
    }
}
