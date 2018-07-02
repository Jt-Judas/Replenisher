package com.wal.replenish.dao;

import org.springframework.data.repository.CrudRepository;
import com.wal.replenish.model.Comment;

public interface CommentDao extends CrudRepository<Comment, Long> {

}
