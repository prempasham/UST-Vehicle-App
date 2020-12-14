package com.ust.pms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.pms.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUserNameAndPassword(String userName,String password);

}
