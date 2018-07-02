package com.wal.replenish.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wal.replenish.model.Task;

public interface TaskService {
	public List<Task> getAllTasks();
	public Task getTaskById(long id);
    public List<Task> findAllByTaskStatus(String status);
	public void saveOrUpdate(Task task);
	public void deleteTask(long id);
	public List<Task> getTaskByUserId(long id);
}
