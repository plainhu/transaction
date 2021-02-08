package com.plainhu.bank2.fegin;

import org.springframework.stereotype.Service;

/**
 * @date: 2021-02-06 15:05:45
 * @author: hkt
 * @desc:
 */
@Service
public class Bank1FeginFallback implements Bank1Fegin {
    @Override
    public String charge(int amount) {
        return "充值bank1失败！";
    }
}
