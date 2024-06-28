package com.example.Bookstore.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, String> {

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext context) {
        if (userId == null) {
            return false;
        }
        // Logic xác thực User ID
        return userId.matches("[A-Za-z0-9]+"); // Ví dụ: chỉ chấp nhận chữ cái và số
    }
}

