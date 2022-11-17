package com.martweb.ticketful.api.services;

import com.martweb.ticketful.api.dtos.CreateUserRequest;
import com.martweb.ticketful.api.dtos.UpdateUserRequest;
import com.martweb.ticketful.api.entities.User;
import com.martweb.ticketful.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        var user = userRepository.findById(id);
        if(user.isEmpty()){
            System.out.println("User not found");
        }
        return user;
    }

    public User createNewUser(CreateUserRequest createUserRequest){
        var getUsername = userRepository.findByUsername(createUserRequest.getUsername());
        var getEmail = userRepository.findByEmail(createUserRequest.getEmail());
        if(getUsername.isPresent()){
            System.out.println("The username already exist");
        }
        if(getEmail.isPresent()){
            System.out.println("The email already exists");
        }
        //var emailValidation = validate

        User user = new User();
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setUsername(createUserRequest.getUsername());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        user.setVerified(createUserRequest.getVerified());
        userRepository.save(user);
        return user;

    }

    public Optional<User> updateUser(Long id,UpdateUserRequest updateUserRequest){
        var getUser = userRepository.findById(id);
        var getUsername = userRepository.findByUsername(updateUserRequest.getUsername());
        var getEmail = userRepository.findByEmail(updateUserRequest.getEmail());
        if(getUsername.isPresent()){
            System.out.println("The username already exists");
        }
        if(getEmail.isPresent()){
            System.out.println("The email already exists");
        }
        getUser.ifPresentOrElse(user -> {
            user.setFirstName(updateUserRequest.getFirstName());
            user.setLastName(updateUserRequest.getLastName());
            user.setUsername(updateUserRequest.getUsername());
            user.setEmail(updateUserRequest.getEmail());
            user.setPassword(updateUserRequest.getPassword());
            userRepository.save(user);
        },()->{
            System.out.println("User not found");
        });
        return getUser;
    }

    public HashMap<Object, Object> deleteUser(Long id){
        var validate = new HashMap<>();
        var user = userRepository.findById(id);
        user.ifPresentOrElse(u ->{
            userRepository.delete(u);
            validate.put("Message", "User has been deleted");
        },()->{
            System.out.println("User not found");
        });
        return validate;
    }

}
