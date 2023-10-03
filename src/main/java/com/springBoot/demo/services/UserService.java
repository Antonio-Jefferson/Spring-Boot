package com.springBoot.demo.services;

import com.springBoot.demo.entities.User;
import com.springBoot.demo.exceptions.BadRequestException;
import com.springBoot.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new BadRequestException("user not found"));

    }

    public User create(User user) {
        return userRepository.save(user);
    }
}
