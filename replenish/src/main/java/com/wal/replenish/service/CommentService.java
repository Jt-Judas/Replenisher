package com.wal.replenish.service;

import java.util.List;
import com.wal.replenish.model.Comment;

public interface CommentService {
	
	public List<Comment> getAllComments();

	public Comment getCommentById(long id);

	public void saveOrUpdate(Comment comment);

	public void deleteComment(long id);
}
