package com.example.ShaSinToDo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ShaSinToDo.Model.Todo;
import com.example.ShaSinToDo.Service.TodoInterface;
import com.example.ShaSinToDo.ServiceImpl.TodoServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/todos") // Use plural form for endpoint base URL
public class TodoController {

    @Autowired
    private TodoServiceImpl tdsImp;

    // Creating a new TodoItem
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo toDo) {
        Todo createdTodo = tdsImp.saveTodo(toDo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    // Fetching all the Todo Items
    @GetMapping
    public List<Todo> getAllTodos() {
        return tdsImp.findAllTodo();
    }

    // Fetching Todo Item by Id
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> optionalTodo = tdsImp.getTodoDetailsById(id);
        if (optionalTodo.isPresent()) {
            Todo toDo = optionalTodo.get();
            return new ResponseEntity<>(toDo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deleting the TodoItem by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable Long id) {
        Optional<Todo> optionalTodo = tdsImp.getTodoDetailsById(id);
        if (optionalTodo.isPresent()) {
            tdsImp.deleteTodo(id);
            return new ResponseEntity<>("Todo with ID " + id + " is deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No such Todo is present", HttpStatus.NOT_FOUND);
        }
    }

    // Updating the TodoItem by Id
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable Long id, @RequestBody Todo toDo) {
        Optional<Todo> optionalTodo = tdsImp.getTodoDetailsById(id);
        if (optionalTodo.isPresent()) {
            Todo existingTodo = optionalTodo.get();
            
            // Update content if provided in the request
            
                existingTodo.setContent(toDo.getContent());
            

            // Update completion status if provided in the request
            
                existingTodo.setCompleted(toDo.getCompleted());
            
            
            Todo updatedTodo = tdsImp.saveTodo(existingTodo);
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
