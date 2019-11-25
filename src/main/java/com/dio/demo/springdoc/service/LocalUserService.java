package com.dio.demo.springdoc.service;

import com.dio.demo.springdoc.exception.DuplicateUserException;
import com.dio.demo.springdoc.exception.UserNotFoundException;
import com.dio.demo.springdoc.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class LocalUserService implements UserService {

    private Map<String, User> localUserStore;

    @Override
    public User add(User user) throws DuplicateUserException {
        if (localUserStore == null) {
            localUserStore = new HashMap<>();
        }
        if (localUserStore.containsKey(user.getUsername())) {
            throw new DuplicateUserException(user.getUsername());
        }
        localUserStore.put(user.getUsername(), user);
        return user;
    }

    @Override
    public boolean delete(String username) {
        if (localUserStore == null || !localUserStore.containsKey(username)) {
            return true;
        }
        localUserStore.remove(username);
        return true;
    }

    @Override
    public List<User> list() {
        if (localUserStore == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(localUserStore.values());
    }

    @Override
    public User get(String username) throws UserNotFoundException {
        if (localUserStore == null || !localUserStore.containsKey(username)) {
            throw new UserNotFoundException(username);
        }
        return localUserStore.get(username);
    }
}
