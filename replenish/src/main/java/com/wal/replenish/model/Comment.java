package com.wal.replenish.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String description;

    @NotNull
    private String feedback;
    
    @ManyToOne(cascade=CascadeType.REFRESH)
  	@JoinColumn(name="task_id")
  	public Task task;

    public Comment() { }

    public Comment(long id) {
        this.id = id;
    }

    public Comment(String description, String feedback) {
        this.description = description;
        this.feedback = feedback;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
    
}
