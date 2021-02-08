package com.plainhu.bank1.rest;

import com.plainhu.bank1.service.MoneyService;
import io.seata.spring.annotation.GlobalTransactional;
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
    public String transfer() throws Exception {
        return moneyService.transfer(100);
    }

    @GetMapping("charge")
    public String charge(int amount) {
        return moneyService.charge(amount);
    }

    @GetMapping("query")
    public String query() {
        return moneyService.query("张三");
    }
}
