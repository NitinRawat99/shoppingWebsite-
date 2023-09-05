package com.shopping.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entities.Products;
import com.shopping.entities.User;
import com.shopping.repos.ProductRepo;
import com.shopping.repos.Userrepo;

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductRepo prodRepo;
	
	@Autowired
	private Userrepo userRepo;

	
	@RequestMapping("/user/view_products")
	public String view_products(Model model, Principal principal)
	{
  List<Products> prod1 = prodRepo.findAll();		
  model.addAttribute("result",prod1);
  
  String username = principal.getName();
	System.out.println(username);
	
	User userByname = userRepo.getUserByUserName(username);
	
	System.out.println(userByname.toString());
	
	model.addAttribute("user", userByname);
	
		
		System.out.println("view me");
		return "view_products";
	}

}
