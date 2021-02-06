package com.plainhu.bank2.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.plainhu.bank2.service.MoneyService;
import org.springframework.stereotype.Service;

/**
 * @date: 2021-02-06 14:57:08
 * @author: hkt
 * @desc:
 */
@Service
public class MoneyServiceImpl implements MoneyService {

    @Override
    //SentinelResource注解用来标识资源是否被限流、降级
    @SentinelResource(value = "transfer")
    public String transfer(int i) {
        return null;
    }
}
