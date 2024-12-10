package com.payment.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    Logger logger= LoggerFactory.getLogger(PaymentController.class);


    @GetMapping("/test")
    public String getMethodName() {
        logger.info("payment service calling");

        return new String("payment service calling");
    }
}