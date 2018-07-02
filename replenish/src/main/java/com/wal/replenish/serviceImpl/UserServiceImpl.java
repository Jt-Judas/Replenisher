package com.wal.replenish.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wal.replenish.dao.UserDao;
import com.wal.replenish.model.User;
import com.wal.replenish.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userDao.findById(id).get();
	}

	@Override
	public void saveOrUpdate(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteById(id);
	}

}
