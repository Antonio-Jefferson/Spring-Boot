package com.springBoot.demo.services;

import com.springBoot.demo.entities.User;
import com.springBoot.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return  obj.get();
    }

}
