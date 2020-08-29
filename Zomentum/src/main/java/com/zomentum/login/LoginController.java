package com.zomentum.login;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zomentum.jdbc.TodoDataService;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String showLoginPage() {
		System.out.println("Login GET Request Accessed");
		return "SignIn";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String email, @RequestParam String password) throws SQLException, ClassNotFoundException {

		System.out.println("Login POST Request Accessed");
		System.out.println(email);
		System.out.println(password);
		if (!loginService.validateUser(email, password)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		TodoDataService dataService = new TodoDataService();
		String []result = dataService.retrieveTodo(email);
		model.put("firstname", result[0]);
		return "welcome";
	}
}
