package by.shumilin.example.service;

import org.springframework.stereotype.Component;

@Component
public class NewsValidatorImpl implements NewsValidator {
    @Override
    public boolean validate(String text) {
        int length = text.length();
        return length > 1 && length <= 500;
    }
}
