package com.DayTime.DayTime.controller;

import com.DayTime.DayTime.Dto.Response;
import com.DayTime.DayTime.Entity.User;
import com.DayTime.DayTime.Repo.UserRepository;
import com.DayTime.DayTime.Servive.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewUserController {

    private static final Logger logger = LoggerFactory.getLogger(NewUserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/createNewUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createNewUser(@RequestBody User user)
    {
        logger.info("Adding the user into DB");
        userService.saveUserDetails(user);
        return new Response("SUCCESS",user);

    }

    @GetMapping(path="/getUserData", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUserData() {

        List<User> user = userService.getUserDetails();
        return new Response("Success",user);
    }

    @DeleteMapping(path="/deleteUserData/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUser(@PathVariable Long userId) {
        userService.deleteUserData(userId);
        return new Response("DELETED",userId);
    }
    @GetMapping(path="/index")
    public String home() {
        return "index";
    }
}

