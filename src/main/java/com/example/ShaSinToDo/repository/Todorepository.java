package com.example.ShaSinToDo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ShaSinToDo.Model.Todo;

import java.util.List;
import java.util.Optional;

@Repository
public interface Todorepository extends JpaRepository<Todo, Long> {
    
   Optional<Todo> findById(Long id);
    void deleteByIdAndUserId(Long id, String userId);
	
	List<Todo> findByUserId(String userId);
}
