package com.dio.demo.springdoc.service;

import com.dio.demo.springdoc.exception.DuplicateUserException;
import com.dio.demo.springdoc.exception.UserNotFoundException;
import com.dio.demo.springdoc.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {

    public User add(User user) throws DuplicateUserException;

    public boolean delete(String username);

    public List<User> list();

    public User get(String username) throws UserNotFoundException;
}
