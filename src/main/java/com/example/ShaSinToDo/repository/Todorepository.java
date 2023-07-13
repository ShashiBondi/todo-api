package com.example.ShaSinToDo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.ShaSinToDo.Model.Todo;


public interface Todorepository extends JpaRepository<Todo,Long> {

	

	Optional<Todo> findById(Long id);

	



}
