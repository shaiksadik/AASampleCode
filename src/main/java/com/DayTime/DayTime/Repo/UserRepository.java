package com.DayTime.DayTime.Repo;

import com.DayTime.DayTime.Entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
