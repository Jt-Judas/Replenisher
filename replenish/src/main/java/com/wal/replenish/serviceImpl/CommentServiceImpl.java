package com.wal.replenish.serviceImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wal.replenish.dao.CommentDao;
import com.wal.replenish.model.Comment;
import com.wal.replenish.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> getAllComments() {
		return (List<Comment>) commentDao.findAll();
	}

	@Override
	public Comment getCommentById(long id) {
		return commentDao.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Comment comment) {
		commentDao.save(comment);
	}

	@Override
	public void deleteComment(long id) {
		commentDao.deleteById(id);
	}

}
