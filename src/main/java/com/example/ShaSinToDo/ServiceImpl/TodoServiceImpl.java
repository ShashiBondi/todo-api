package com.example.ShaSinToDo.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShaSinToDo.Model.Todo;
import com.example.ShaSinToDo.Model.User;
import com.example.ShaSinToDo.Service.TodoInterface;
import com.example.ShaSinToDo.repository.Todorepository;
import com.example.ShaSinToDo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public  class TodoServiceImpl implements TodoInterface {
    private final Todorepository todoRepository;
    private final UserRepository userRepository;
    @Autowired
    public TodoServiceImpl(Todorepository todoRepository,UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Todo> getAllTodosByUserId(String userId) {
        return todoRepository.findByUserId(userId);
    }

    @Override
    public Optional<Todo> getTodoById(Long id)  {
        return todoRepository.findById(id);
    }

    @Override
    public Todo createTodoByUserId(String userId, Todo todo) {
//        User user =  
//        userRepository.findById(userId).get();
//                
//
//        todo.setUser(user);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodoById(Long id, Todo todo)  {
    	Todo existingTodo=todoRepository.findById(id).get();
    	 
        existingTodo.setContent(todo.getContent());
        existingTodo.setCompleted(todo.getCompleted());
        return todoRepository.save(existingTodo);
    
    	
    }

    @Override
    public void deleteTodoById(Long id) {
     
        todoRepository.deleteById(id);
    }
}