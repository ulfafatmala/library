package com.school.library.service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ValidationService {
    @Autowired
    private Validator validator;

    public void validate(Object request){
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(request);
        if(constraintViolationSet.size() >0){
            throw new RuntimeException("Validation failed");
        }

    }
}
