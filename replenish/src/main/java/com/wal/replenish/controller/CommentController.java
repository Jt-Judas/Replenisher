package com.wal.replenish.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wal.replenish.model.Comment;
import com.wal.replenish.model.Task;
import com.wal.replenish.service.CommentService;
import com.wal.replenish.service.TaskService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/comments", method = RequestMethod.GET)
	public ModelAndView allComments() {
		ModelAndView model = new ModelAndView("comments");
		List<Comment> comments = commentService.getAllComments();
		model.addObject("comments", comments);
		return model;
	}
	
	@RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
	public ModelAndView taskComments(@PathVariable long id) {
		ModelAndView model = new ModelAndView("taskDetail");
		Task task = taskService.getTaskById(id);
		model.addObject("task",task);
		List<Comment> comments = commentService.getAllComments().stream().filter(c->c.task.getId() ==id).collect(Collectors.toList());
		model.addObject("comments", comments);
		return model;
	}
/*
	@RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
	public ModelAndView taskComments(@PathVariable long id) {
		ModelAndView model = new ModelAndView("comments");
		Task task = taskService.getTaskById(id);
		model.addObject("task",task);
		List<Comment> comments = commentService.getAllComments().stream().filter(c->c.task.getId() ==id).collect(Collectors.toList());
		model.addObject("comments", comments);
		return model;
	}*/

	@RequestMapping(value = "/addComment/{id}", method = RequestMethod.GET)
	public ModelAndView addComment(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		Task task = taskService.getTaskById(id);
		model.addObject("task",task);
		Comment comment = new Comment();
		comment.setTask(task);
		model.addObject("addNewComment", comment);
		model.setViewName("commentForm");
		return model;
	}

	@RequestMapping(value = "/updateComment/{id}", method = RequestMethod.GET)
	public ModelAndView editComment(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		Comment comment = commentService.getCommentById(id);
		model.addObject("addNewComment", comment);
		model.setViewName("commentForm");
		return model;
	}

	@RequestMapping(value = "/saveComment/{id}", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("addNewComment") Comment comment,@PathVariable long id) {
		Task task = taskService.getTaskById(id);
		comment.setTask(task);
		commentService.saveOrUpdate(comment);
		return new ModelAndView("redirect:/comment/comments/"+id);
	}

	@RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id) {
		commentService.deleteComment(id);
		return new ModelAndView("redirect:/comment/comments");
	}
	
}
