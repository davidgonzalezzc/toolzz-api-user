package puj.api.userapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.api.userapi.entity.User;
import puj.api.userapi.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<User>();
        users.addAll(userRepository.findAll());
        return users;
    }
    
}
