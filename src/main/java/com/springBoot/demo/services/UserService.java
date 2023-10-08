package com.springBoot.demo.services;

import com.springBoot.demo.entities.User;
import com.springBoot.demo.exceptions.BadRequestException;
import com.springBoot.demo.exceptions.ResourceNotFoundException;
import com.springBoot.demo.repositories.UserRepository;
import org.apache.juli.logging.Log;
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
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));

    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User obj){
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return  userRepository.save(entity);
    }

    public void updateData(User entity, User obj){
        entity.setEmail(obj.getEmail());
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }
}
