package com.cloud.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cloud.server.model.User;
import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {

//	User findUserByUsernamePassword(String firstname, String lastname);
	@Query("SELECT u FROM User u  WHERE u.userName=(:userName) AND u.password= (:password)")
	List<User> findUserByUsernamePassword(@Param("userName") String userName, @Param("password") String password);
}