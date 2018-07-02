package com.wal.replenish.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wal.replenish.model.Comment;
import com.wal.replenish.model.STATUS;
import com.wal.replenish.model.Task;
import com.wal.replenish.model.User;
import com.wal.replenish.service.CommentService;
import com.wal.replenish.service.TaskService;
import com.wal.replenish.service.UserService;


@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String allPendingTasks(Model model) {
		List<Task> pending = taskService.findAllByTaskStatus(STATUS.PENDING.toString());
		List<Task> assigned = taskService.findAllByTaskStatus(STATUS.ASSIGNED.toString());
		List<Task> inprogress = taskService.findAllByTaskStatus(STATUS.INPROGRESS.toString());
		model.addAttribute("pending", pending.size());
		model.addAttribute("assigned", assigned.size());
		model.addAttribute("inprogress", inprogress.size());
		return "home";
	}
	
}
