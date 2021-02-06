package com.plainhu.bank1.fegin;

import org.springframework.stereotype.Service;

/**
 * @date: 2021-02-06 15:05:45
 * @author: hkt
 * @desc:
 */
@Service
public class Bank2FeginFallback implements Bank2Fegin {
    @Override
    public String charge(String str) {
        return null;
    }
}
