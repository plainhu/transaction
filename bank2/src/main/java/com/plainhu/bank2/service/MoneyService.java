package com.plainhu.bank2.service;

/**
 * @date: 2021-02-06 14:56:49
 * @author: hkt
 * @desc:
 */
public interface MoneyService {
    String transfer(int i);

    String query(String name);

    String charge(int amount);
}
