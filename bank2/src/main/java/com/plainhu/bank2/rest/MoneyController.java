package com.plainhu.bank2.rest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.plainhu.bank2.service.MoneyService;
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
@RequestMapping("bank2")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @GetMapping("tobank1")
    public String transfer() {
        return moneyService.transfer(100);
    }

    @GetMapping("charge")
    public String charge(int amount) {
        return moneyService.charge(amount);
    }

    @GetMapping("query")
    public String query() {
        return moneyService.query("李四");
    }
}
