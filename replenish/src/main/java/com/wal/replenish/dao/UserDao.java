package com.wal.replenish.dao;

import org.springframework.data.repository.CrudRepository;
import com.wal.replenish.model.User;

public interface UserDao extends CrudRepository<User, Long> {

}
