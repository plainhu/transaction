package com.plainhu.bank1.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @date: 2021-02-06 15:00:29
 * @author: hkt
 * @desc:
 */
@FeignClient(name = "bank2", fallback = Bank2FeginFallback.class)
public interface Bank2Fegin {

    @GetMapping("bank2/charge")
    String charge(@RequestParam("amount") int amount);
}
