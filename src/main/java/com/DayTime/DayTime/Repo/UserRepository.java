package com.DayTime.DayTime.Repo;

import com.DayTime.DayTime.Entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
