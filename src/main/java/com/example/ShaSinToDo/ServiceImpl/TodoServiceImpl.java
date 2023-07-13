package com.example.ShaSinToDo.ServiceImpl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ShaSinToDo.Model.Todo;
import com.example.ShaSinToDo.Service.TodoInterface;
import com.example.ShaSinToDo.repository.Todorepository;

@Service
public class TodoServiceImpl implements TodoInterface {
@Autowired
private Todorepository todoRepo;
	@Override
	public Todo saveTodo(Todo toDo) {
		
		return todoRepo.save(toDo);
	}

	@Override
	public Todo updateTodo(Todo toDo) {
		
		return todoRepo.save(toDo);
	}

	@Override
	public List<Todo> findAllTodo() {
		
		return  (List<Todo>) todoRepo.findAll();
	}

	@Override
	public void deleteTodo(Long id) {
		todoRepo.deleteById(id);
		
	}

	public Optional<Todo> getTodoDetailsById(Long id) {
		
		return todoRepo.findById(id);
	}

	

	

	

}
