package com.shopping.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.entities.User;
import com.shopping.repos.Userrepo;
import com.shopping.service.SequenceGeneratorService;

@Controller
//@RequestMapping("/login")
public class UserController 
{
	
	@Autowired
	private Userrepo userRepo;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@RequestMapping("/user/dashboard")
	public String dashboard(Model model, Principal principal)
	{
		String username = principal.getName();
		System.out.println(username);
		
		User userByname = userRepo.getUserByUserName(username);
		
		System.out.println(userByname.toString());
		
		model.addAttribute("user", userByname);
		
		//get the user using username(Email)
		return "success";
		
	}
	
	
	
	
	
	@RequestMapping("/")
	public String home(Model model)
	{  
	return "index";	
	}
	@GetMapping("/signin")
	public String getUserLogin()
	{
	//	System.out.println("login successfull");
		return "login";
	}
	
	
	@RequestMapping(path="/register",method=RequestMethod.POST)
	public String registerUser(@RequestParam("flname") String flname,
			@RequestParam("mobnum") String mobnum,
			@RequestParam("email") String email,
			@RequestParam("Password") String password,
			@RequestParam("role") String role)
	{
		System.out.println(mobnum);
		
		User user = new User();
		user.setId(service.getSequenceNumber(user.SEQUENCE_NAME));
		user.setFlname(flname);
		user.setMobnum(mobnum);
		user.setEmail(email);
//		System.out.println(user.getPassword());
		user.setPassword(passwordEncoder.encode(password));
		user.setRole(role.toUpperCase());
//		System.out.println(user.getId());
//		System.out.println(user.getFlname());
		this.userRepo.save(user);
		return "register";
	}
	
	
	
	
	
	
	@GetMapping("/register")
	public String getRegister()
	{
		return "register";
	}
	
	

}
