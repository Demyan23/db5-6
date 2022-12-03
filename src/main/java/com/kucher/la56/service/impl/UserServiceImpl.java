package com.kucher.la56.service.impl;

import com.kucher.la56.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kucher.la56.domain.User;
import com.kucher.la56.exception.UserNotFoundExeption;
import com.kucher.la56.service.UserService;
import com.kucher.la56.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer iduser) {
        return userRepository.findById(iduser)
                .orElseThrow(() -> new UserNotFoundExeption(iduser));
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public void update(Integer iduser, User uUser) {
        User user = userRepository.findById(iduser)
                .orElseThrow(() -> new UserNotFoundExeption(iduser));
        user.setName(uUser.getName());
        user.setSirname(uUser.getSirname());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer iduser) {
        User objectc = userRepository.findById(iduser)
                .orElseThrow(() -> new UserNotFoundExeption(iduser));
        if (!objectc.getName().isEmpty()) throw new UserNotFoundExeption(iduser);
        userRepository.delete(objectc);
    }

    @Override
    @Transactional
    public void dymanicProcedure() {
        userRepository.dymanicProcedure();
    }
}
