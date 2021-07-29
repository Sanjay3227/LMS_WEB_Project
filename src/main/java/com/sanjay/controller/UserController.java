package com.sanjay.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sanjay.*;
import com.sanjay.admin.Admin;
//import com.sanjay.admin.AdminLoginService;
import com.sanjay.admin.AdminRepo;

import com.sanjay.user.User;
import com.sanjay.user.UserRepo;

@Controller
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AdminRepo adminRepo;

	Model model;
	Model model1;
	
	@GetMapping("/test")
	public String viewTestPage() {
		return "test";
	}

	@GetMapping("/user_login")
	public ModelAndView User() {
		ModelAndView mav = new ModelAndView("user_login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping("/process_user")
	public String processUser(User user) {

		userRepo.save(user);
		return "process_register";
	}


	
	@PostMapping("/user_page")
	public String loginSubmit(Login login) {
		for(User x : userRepo.findAll())
		{
			if(x.getUsername().equals(login.getUsername()) && x.getPassword().equals(login.getPassword()))
				return "user_page";
		}
		return "error_page";
	}	
	
	@RequestMapping("/admin_login")
	public String showAdminForm(Model model) {
		model.addAttribute("login1", new Login());
		return "admin_login";	
	}
	
	@PostMapping("/admin_page")
	public String adminlog(Login login1) {
		if(login1.getUsername().equals(login1.getUsername()) && login1.getPassword().equals(login1.getPassword()))
			return "admin_page";
		else
			return "error_page";
	}

	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "sys_logout";
	}

	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showOptions() {
		return "options";
	}

	@GetMapping("user_Singup")
	public String showUserSingup(Model model) {
		model.addAttribute("user", new User());
		return "user_Singup";
	}

//	@GetMapping("admin_login")
//	public String showAdminLogin(Model model) {
//		model.addAttribute("user", new User());
//		return "admin_login";
//	}

	@GetMapping("admin_Singup")
	public String showAdminSingup(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin_Singup";
	}

	
	@PostMapping("/process_admin")
	public String processAdmin(Admin admin) {
		adminRepo.save(admin);
		return "process_register";
		

	}
}
