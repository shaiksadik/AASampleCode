package com.DayTime.DayTime.controller;

import com.DayTime.DayTime.Dto.Response;
import com.DayTime.DayTime.Entity.User;
import com.DayTime.DayTime.Repo.UserRepository;
import com.DayTime.DayTime.Servive.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/createNewUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createUser(@RequestBody User user)
    {
        logger.info("Adding the user into DB");
        userService.saveUserDetails(user);
        return new Response("SUCCESS");

    }
}

