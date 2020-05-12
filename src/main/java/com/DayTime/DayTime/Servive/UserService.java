package com.DayTime.DayTime.Servive;

import com.DayTime.DayTime.Entity.User;
import com.DayTime.DayTime.Repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

public void saveUserDetails(User user){
    User dbUser = new User();

    dbUser.setFirstName(user.getFirstName());
    dbUser.setLastName(user.getLastName());
    dbUser.setEmail(user.getEmail());
    dbUser.setConfirmEmail(user.getConfirmEmail());
    dbUser.setPassword(user.getPassword());
    dbUser.setMobileNumber(user.getMobileNumber());
    dbUser.setAlternateMobileNumber(user.getAlternateMobileNumber());
    userRepository.save(dbUser);
}

public List<User> getUserDetails() {
List<User> user = (List<User>) userRepository.findAll();
logger.info("User Details: " + user.toString());
return user;
}
public void deleteUserData(Long userId){
    logger.info("Before Deleted User from the list");
    userRepository.deleteById(userId);
    logger.info("Successfully Deleted User from the list");
}
}
