package com.dio.demo.springdoc.resource;

import com.dio.demo.springdoc.exception.DuplicateUserException;
import com.dio.demo.springdoc.exception.InvalidParameterException;
import com.dio.demo.springdoc.exception.UserNotFoundException;
import com.dio.demo.springdoc.model.User;
import com.dio.demo.springdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User addNewUser(@RequestBody User user) throws InvalidParameterException, DuplicateUserException {
        validate(user);
        return userService.add(user);
    }

    @GetMapping(path = "/{username}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("username") String username) throws UserNotFoundException {
        return userService.get(username);
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<User> listUsers() {
        return userService.list();
    }

    @DeleteMapping(path = "/{username}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("username") String username) {
        userService.delete(username);
    }

    private void validate(User user) throws InvalidParameterException {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.containsWhitespace(user.getUsername())) {
            throw new InvalidParameterException("username", user.getUsername());
        }
    }
}
