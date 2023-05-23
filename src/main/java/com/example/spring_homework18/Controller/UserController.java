package com.example.spring_homework18.Controller;

import com.example.spring_homework18.Model.User;
import com.example.spring_homework18.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        List<User> userList = userService.getAllUser();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, @PathVariable Integer id, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("User Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser( @PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User Deleted");
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity LoginUser(@PathVariable String username, @PathVariable String password){
        User user = userService.LoginUser(username,password);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        User user = userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity getAllByRole(@PathVariable String role){
        List<User> users = userService.findAllByRole(role);
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity getUserByMinimumAge(@PathVariable Integer age){
        List<User> users = userService.findUserByMinimumAge(age);
        return ResponseEntity.status(200).body(users);
    }
}
