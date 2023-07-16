package com.example.ShaSinToDo.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ShaSinToDo.Model.Todo;
@Service
public interface TodoInterface {
    List<Todo> getAllTodosByUserId(String userId);
   
    Todo createTodoByUserId(String userId, Todo todo);
    Todo updateTodoById(Long id, Todo todo);
    String deleteTodoById(Long id);
    Optional<Todo> getTodoById(Long id);
}
