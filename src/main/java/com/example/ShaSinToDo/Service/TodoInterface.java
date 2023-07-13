package com.example.ShaSinToDo.Service;

import java.util.List;
import java.util.Optional;


import com.example.ShaSinToDo.Model.Todo;

public interface TodoInterface {
public Todo saveTodo(Todo todo);

public Todo updateTodo(Todo todo);

public List<Todo> findAllTodo();

public void deleteTodo(Long id);

public Optional<Todo> getTodoDetailsById(Long id);
}
