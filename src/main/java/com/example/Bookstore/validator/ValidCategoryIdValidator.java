package com.example.Bookstore.validator;

import com.example.Bookstore.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category>
{
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext) {
        return category!=null && category.getId() != null;
    }
}
