package com.example.spring_homework18.Service;

import com.example.spring_homework18.ApiException.ApiException;
import com.example.spring_homework18.Model.User;
import com.example.spring_homework18.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){
        User oldUser = userRepository.findUserById(id);

        if (oldUser == null){
            throw new ApiException("Wrong ID");
        }

        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());

        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id){
        User oldUser = userRepository.findUserById(id);
        if (oldUser == null){
            throw new ApiException("Wrong ID");
        }
        userRepository.delete(oldUser);
    }

    public User LoginUser(String username, String password){
        User user = userRepository.LoginUser(username,password);
        if (user == null){
            throw new ApiException("Wrong username or password");
        }
        return user;
    }

    public User findUserByEmail (String email){
        User user = userRepository.findUserByEmail(email);

        if (user == null){
            throw new ApiException("Wrong Email");
        }

        return user;
    }

    public List<User> findAllByRole(String role){
        List<User> users = userRepository.findAllByRole(role);

        if (users.isEmpty()){
            throw new ApiException("Wrong role");
        }

        return users;
    }

    public List<User> findUserByMinimumAge(Integer age){
        List<User> users = userRepository.findUserByMinimumAge(age);

        if (users.isEmpty()){
            throw new ApiException("Wrong age");
        }

        return users;
    }
}
