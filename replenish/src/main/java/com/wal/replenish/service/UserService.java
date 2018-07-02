package com.wal.replenish.service;

import java.util.List;

import com.wal.replenish.model.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(long id);
	public void saveOrUpdate(User user);
	public void deleteUser(long id);
}
