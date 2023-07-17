package com.example.ShaSinToDo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ShaSinToDo.Model.Todo;
import com.example.ShaSinToDo.Service.TodoInterface;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/users/{userId}/todos")
public class TodoController {
    private  TodoInterface todoService;

    @Autowired
    public TodoController(TodoInterface todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodosByUserId(@PathVariable("userId") String userId) {
        List<Todo> todos = todoService.getAllTodosByUserId(userId);
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoByIdAndUserId(@PathVariable Long id) {
       Optional <Todo> optionalTodo = todoService.getTodoById(id);
       System.out.println(optionalTodo);
        if (optionalTodo.isPresent()) {
            Todo toDo = optionalTodo.get();
            return new ResponseEntity<>(toDo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Todo> createTodoByUserId(@PathVariable("userId") String userId, @RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodoByUserId(userId, todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodoByIdAndUserId(@PathVariable("userId") String userId, @PathVariable("id") Long id, @RequestBody Todo todo) {
    	 Optional <Todo> optionalTodo = todoService.getTodoById(id);
         if (optionalTodo.isPresent())
         {
    	
    	Todo updatedTodo = todoService.updateTodoById(id, todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }
         else {
        	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoByIdAndUserId(@PathVariable("userId") String userId, @PathVariable("id") Long id) {
    	 Optional<Todo> optionalTodo = todoService.getTodoById(id);
         if (optionalTodo.isPresent()) {
    	todoService.deleteTodoById(id);
        return new ResponseEntity<>("Successfully deleted the todo with id:"+id,HttpStatus.NO_CONTENT);
    }else {
    	return new ResponseEntity<>("Todo not found with the id"+id,HttpStatus.NOT_FOUND);
    }
    }
}
