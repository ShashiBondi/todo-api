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
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String content;
	private Boolean completed = Boolean.FALSE;
	@ManyToOne
//	@JoinColumn(name="user_id",nullable=false)
	private User user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Todo(Long id, String content, Boolean completed, User user) {
		super();
		Id = id;
		this.content = content;
		this.completed = completed;
		this.user = user;
	}
	public Todo() {
		super();
	}



	

}
