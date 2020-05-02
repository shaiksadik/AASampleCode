package com.DayTime.DayTime.Servive;

import com.DayTime.DayTime.Entity.User;
import com.DayTime.DayTime.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

public void saveUserDetails(User user){
    User dbUser = new User();

    dbUser.setFirstName(user.getFirstName());
    dbUser.setLastName(user.getLastName());
    dbUser.setEmail(user.getEmail());
    userRepository.save(dbUser);
}
}
