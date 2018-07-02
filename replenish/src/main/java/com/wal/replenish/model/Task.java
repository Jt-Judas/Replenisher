package com.wal.replenish.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task implements Comparable<Task> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String name;
	@NotNull
	private String description;

	@NotNull
	private int progress;

	@NotNull
	private int manHours;

	@NotNull
	private PRIORITY priority;

	@NotNull
	@Column(name = "status")
	private String status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "task_id")
	private List<Comment> comments = new ArrayList<Comment>();

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id")
	public User user;

	public Task() {
	}

	public Task(long id) {
		this.id = id;
	}

	public Task(@NotNull String name, @NotNull String description, @NotNull int progress, @NotNull int manHours,
			@NotNull PRIORITY priority, @NotNull String status) {
		super();
		this.name = name;
		this.description = description;
		this.progress = progress;
		this.manHours = manHours;
		this.priority = priority;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getManHours() {
		return manHours;
	}

	public void setManHours(int manHours) {
		this.manHours = manHours;
	}

	public PRIORITY getPriority() {
		return priority;
	}

	public void setPriority(PRIORITY priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Task task) {

		int result = this.status.compareTo(task.status);
		
		if (result == 0) {
			return this.getRank().compareTo(task.getRank());
		}

		return result;
	}

	public Double getRank() {
		return Double.valueOf((this.priority.getValue()*1.0) / this.manHours);
	}

}