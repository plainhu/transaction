package com.plainhu.bank2.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @date: 2021-02-06 15:00:29
 * @author: hkt
 * @desc:
 */
@FeignClient(name = "bank1", fallback = Bank1FeginFallback.class)
public interface Bank1Fegin {

    @GetMapping(value = "bank1/charge")
    String charge(@RequestParam("amount") int amount);
}
