package com.springBoot.demo.services;

import com.springBoot.demo.entities.Order;
import com.springBoot.demo.entities.User;
import com.springBoot.demo.repositories.OrderRepository;
import com.springBoot.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return  obj.get();
    }

}
