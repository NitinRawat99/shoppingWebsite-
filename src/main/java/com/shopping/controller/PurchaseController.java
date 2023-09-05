package com.shopping.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shopping.entities.Purchase;
import com.shopping.repos.ProductRepo;
import com.shopping.repos.Userrepo;
import java.security.Principal;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PurchaseController 
{
	@Autowired
	private ProductRepo prodRepo;
	
	@Autowired
	private Userrepo userRepo;
	
	
	@RequestMapping("/user/purchase")
	public String productPurchase(@RequestBody Map<String, Object> requestData, Model model, Principal principal) {
	    System.out.println("purchase done");

	    String username = principal.getName();

	    if (requestData.containsKey("totalCost")) {
	        Object totalCostObj = requestData.get("totalCost");

	        if (totalCostObj instanceof Double) {
	            Double totalCost = (Double) totalCostObj;

	            // Now you have the totalCost value sent from the client
	            System.out.println("Total Cost: " + totalCost);

	            // Perform any necessary operations related to the purchase
	            // ...

	            return "purchase"; // Return the appropriate view name
	        }
	    }

	    // Handle the case where totalCost is not present or not in the expected format
	    return "purchase"; // You may want to return an error view or handle this differently
	}


}
