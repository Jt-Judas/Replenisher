package com.wal.replenish.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wal.replenish.model.Task;

public interface TaskDao extends CrudRepository<Task, Long> {

	@Query("Select t from Task t where t.status= :status")
	public List<Task> findAllByTaskStatus(@Param("status") String status);
	
	@Query("Select t from Task t where t.user.id= :id")
	public List<Task> getTaskByUserId(@Param("id") long id);
	
//	@Query("Select t from Task t where t.user.user_id= :user_id")
//	public List<Task> getTaskByUserId(@Param("user_id") long user_id);

}
