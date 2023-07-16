package com.example.ShaSinToDo.ServiceImpl;

import com.example.ShaSinToDo.Model.User;
import com.example.ShaSinToDo.Service.UserService;
import com.example.ShaSinToDo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
