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
import com.wal.replenish.model.PRIORITY;
import com.wal.replenish.model.STATUS;
import com.wal.replenish.model.Task;
import com.wal.replenish.model.User;
import com.wal.replenish.service.CommentService;
import com.wal.replenish.service.TaskService;
import com.wal.replenish.service.UserService;


@Controller
@RequestMapping(value = "/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public ModelAndView allTasks() {
		ModelAndView model = new ModelAndView("tasks");
		List<Comment> comments = commentService.getAllComments();
		model.addObject("comments", comments);
		List<Task> tasks = taskService.getAllTasks().stream().filter(task->(!task.getStatus().equals(STATUS.PENDING.toString()))).collect(Collectors.toList());
		Collections.sort(tasks);
		model.addObject("tasks", tasks);
		return model;
	}
	
	@RequestMapping(value = "/assignTask/{id}", method = RequestMethod.GET)
	public String allPendingTasks(@PathVariable long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		List<Task> tasks = taskService.findAllByTaskStatus(STATUS.PENDING.toString());
		Collections.sort(tasks);
		model.addAttribute("pendingTasks", tasks);
		return "taskStatus";
	}
	
	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	public String allPendingTasks(Model model) {
		List<Task> tasks = taskService.findAllByTaskStatus(STATUS.PENDING.toString());
		Collections.sort(tasks);
		model.addAttribute("pendingTasks", tasks);
		return "taskStatus";
	}
	
	@RequestMapping(value = "/assigned", method = RequestMethod.GET)
	public String assignedTasks(Model model) {
		List<Task> tasks = taskService.findAllByTaskStatus(STATUS.ASSIGNED.toString());
		Collections.sort(tasks);
		model.addAttribute("pendingTasks", tasks);
		return "taskStatus";
	}
	
	@RequestMapping(value = "/inprogress", method = RequestMethod.GET)
	public String inprogressTasks(Model model) {
		List<Task> tasks = taskService.findAllByTaskStatus(STATUS.INPROGRESS.toString());
		Collections.sort(tasks);
		model.addAttribute("pendingTasks", tasks);
		return "taskStatus";
	}

	@RequestMapping(value = "/assignUserToTask/{id}/{user_id}", method = RequestMethod.GET)
	public String assignTask(@ModelAttribute("user_id") long modelUser,@PathVariable long id,@PathVariable long user_id) {
		Task task = taskService.getTaskById(id);
		User user = userService.getUserById(user_id);
		task.setUser(user);
		task.setStatus(STATUS.ASSIGNED.toString());
		taskService.saveOrUpdate(task);
		return "redirect:/task/assignTask/"+user_id;
	}
	
	@RequestMapping(value = "/addTask", method = RequestMethod.GET)
	public ModelAndView addTask() {
		ModelAndView model = new ModelAndView();
		Task task = new Task();
		List<STATUS> statusList= Arrays.asList(STATUS.values());
		List<PRIORITY> priorities= Arrays.asList(PRIORITY.values());
		model.addObject("statusList", statusList);
		model.addObject("priorities", priorities);
		model.addObject("addNewTask", task);
		model.setViewName("taskForm");
		return model;
	}

	@RequestMapping(value = "/updateTask/{id}", method = RequestMethod.GET)
	public ModelAndView editTask(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		List<STATUS> statusList= Arrays.asList(STATUS.values());
		model.addObject("statusList", statusList);
		Task task = taskService.getTaskById(id);
		model.addObject("addNewTask", task);
		model.setViewName("taskForm");
		return model;
	}
	
	@RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("addNewTask") Task task) {
		taskService.saveOrUpdate(task);
		return new ModelAndView("redirect:/task/tasks");
	}

	@RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id) {
		taskService.deleteTask(id);
		return new ModelAndView("redirect:/task/tasks");
	}
	
}
