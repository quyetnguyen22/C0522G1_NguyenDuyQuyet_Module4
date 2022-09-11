package com.email.service.impl;

import com.email.common.ValidateEmail;
import com.email.service.ICheckEmailService;
import org.springframework.stereotype.Service;

@Service
public class CheckEmailService implements ICheckEmailService {
    public String checkEmail(String email) {
        boolean isValid = ValidateEmail.validate(email);
        if (email.equals("")) {
            return "You have not input email!";
        } else if (!isValid) {
            return "Email is invalid!";
        }
        return email + " ok";
    }
}
