package com.wal.replenish.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wal.replenish.model.Task;
import com.wal.replenish.model.User;
import com.wal.replenish.service.TaskService;
import com.wal.replenish.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView allUsers() {
		ModelAndView model = new ModelAndView("users");
		
		List<Task> tasks = taskService.getAllTasks();
		model.addObject("tasks", tasks);
		
		List<User> users = userService.getAllUsers();
		model.addObject("users", users);
		return model;
	}
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detailInfo(@PathVariable long id) {
		ModelAndView model = new ModelAndView("userDetail");
		
			
		User user = userService.getUserById(id);
		model.addObject("user", user);
		
		List<Task> tasks = taskService.getTaskByUserId(id);
		
		model.addObject("tasks", tasks);
	
		return model;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listOfUsers() {
		ModelAndView model = new ModelAndView("users_list");
		
		List<User> users = userService.getAllUsers();
		model.addObject("users", users);
		return model;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("addNewUser", user);
		model.setViewName("userForm");
		return model;
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		User user = userService.getUserById(id);
		model.addObject("addNewUser", user);
		model.setViewName("userForm");
		return model;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("addNewUser") User user) {
		userService.saveOrUpdate(user);
		return new ModelAndView("redirect:/user/users");
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect:/user/users");
	}

}
