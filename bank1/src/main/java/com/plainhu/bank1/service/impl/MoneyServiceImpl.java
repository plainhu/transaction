package com.plainhu.bank1.service.impl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.plainhu.bank1.fegin.Bank2Fegin;
import com.plainhu.bank1.mapper.AccountMapper;
import com.plainhu.bank1.po.Account;
import com.plainhu.bank1.service.MoneyService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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
    Bank2Fegin bank2Fegin;

    @GlobalTransactional
    @Transactional
    @Override
    public String transfer(int amount) throws Exception {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class).eq(Account::getUsername, "张三"));
        account.setBalance(account.getBalance() - amount);
        account.updateById();
        String charge = bank2Fegin.charge(amount);
        byte[] bytes = charge.getBytes();
        bytes[100] = 1;
        return charge;
    }

    @Override
    public String query(String name) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class).eq(Account::getUsername, name));
        return account.toString();
    }

    @Override
    public String charge(int amount) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class).eq(Account::getUsername, "张三"));
        account.setBalance(account.getBalance() + amount);
        account.updateById();
        return account.toString();
    }
}
