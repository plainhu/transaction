package com.plainhu.bank2.service.impl;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.plainhu.bank2.fegin.Bank1Fegin;
import com.plainhu.bank2.mapper.AccountMapper;
import com.plainhu.bank2.po.Account;
import com.plainhu.bank2.service.MoneyService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @date: 2021-02-06 14:57:08
 * @author: hkt
 * @desc:
 */
@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    Bank1Fegin bank1Fegin;

    @Override
    @GlobalTransactional
    @Transactional
    public String transfer(int amount) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class).eq(Account::getUsername, "李四"));
        account.setBalance(account.getBalance() - amount);
        account.updateById();
        return bank1Fegin.charge(amount);
    }

    @Override
    public String query(String name) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class).eq(Account::getUsername, name));
        return account.toString();
    }

    @Transactional
    @Override
    public String charge(int amount) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class).eq(Account::getUsername, "李四"));
        account.setBalance(account.getBalance() + amount);
        account.updateById();
        return account.toString();
    }
}
