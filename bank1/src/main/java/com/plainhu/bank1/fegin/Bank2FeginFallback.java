package com.plainhu.bank1.fegin;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @date: 2021-02-06 15:05:45
 * @author: hkt
 * @desc:
 */
@Component
public class Bank2FeginFallback implements Bank2Fegin {
    @Override
    public String charge(int amount) {
        return "充值bank2失败！";
    }
}
