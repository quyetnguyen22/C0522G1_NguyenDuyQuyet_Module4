package com.register_form.service.impl;

import com.register_form.model.User;
import com.register_form.repository.IUserRepository;
import com.register_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public User registerUser(User user) {
       return userRepository.save(user);
    }

}
