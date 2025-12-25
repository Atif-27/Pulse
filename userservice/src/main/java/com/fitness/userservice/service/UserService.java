package com.fitness.userservice.service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;

    public UserResponse register(RegisterRequest request){
        if(repository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email Already Exists");
        }


        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        User savedUser=repository.save(user);
        UserResponse userResponse= new UserResponse();
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        return userResponse;
    }

    public UserResponse getUserProfile(String userId){
        User user = repository.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));
        UserResponse userResponse= new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        return userResponse;
    }
}
