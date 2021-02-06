package com.plainhu.bank1.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @date: 2021-02-06 15:00:29
 * @author: hkt
 * @desc:
 */
@FeignClient(name = "bank1", fallback = Bank2FeginFallback.class)
public interface Bank2Fegin {

    @PostMapping(value = "charge")
    String charge(String str);
}
