package com.wal.replenish.serviceImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wal.replenish.dao.TaskDao;
import com.wal.replenish.model.Task;
import com.wal.replenish.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;
	
	@Override
	public List<Task> getAllTasks() {
		return (List<Task>) taskDao.findAll();
	}

	@Override
	public Task getTaskById(long id) {
		return taskDao.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Task task) {
		taskDao.save(task);
	}

	@Override
	public void deleteTask(long id) {
		taskDao.deleteById(id);
	}

	@Override
	public List<Task> findAllByTaskStatus(String status) {
		return (List<Task>) taskDao.findAllByTaskStatus(status);
	}

	@Override
	public List<Task> getTaskByUserId(long id) {
		// TODO Auto-generated method stub
		return taskDao.getTaskByUserId(id);
	}

}
