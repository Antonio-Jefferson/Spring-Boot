package com.springBoot.demo.services;

import com.springBoot.demo.entities.User;
import com.springBoot.demo.exceptions.DatabaseException;
import com.springBoot.demo.exceptions.ResourceNotFoundException;
import com.springBoot.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
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
