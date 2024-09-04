package com.demo.product.management.application;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

//T에는 어떤 타입이든 올 수 있다는 것을 의미한다.
@Service
@Validated
public class ValidationService {
    public <T> void checkValid(@Valid T validationTarget){
        //do nothing
    }
}
