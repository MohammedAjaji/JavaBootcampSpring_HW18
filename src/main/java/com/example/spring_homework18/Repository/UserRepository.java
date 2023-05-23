package com.example.spring_homework18.Repository;

import com.example.spring_homework18.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findUserById(Integer id);

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User LoginUser(String username,String password);

    User findUserByEmail(String email);

    List<User> findAllByRole(String role);


    @Query("select a from User a where a.age>=?1")
    List<User> findUserByMinimumAge(Integer age);



}