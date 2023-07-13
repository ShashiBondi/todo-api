package com.example.ShaSinToDo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="todos")
public class Todo {
	public Todo() {
		super();
	}

	public Todo(Long id, String content, Boolean completed) {
		super();
		Id = id;
		this.content = content;
		this.completed = completed;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String content;
	private Boolean completed = Boolean.FALSE;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	

	

}
