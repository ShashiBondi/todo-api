package com.example.ShaSinToDo.Service;

import org.springframework.stereotype.Service;

import com.example.ShaSinToDo.Model.User;
@Service
public interface UserService {
    User createUser(User user);
}

