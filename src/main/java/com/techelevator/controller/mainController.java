package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
//@SessionAttributes({"tempClass", "parkDetails"})

public class mainController {


	//@Autowired
	//private ParkDAO parkdao; 
	
	
	@RequestMapping("/main")
	public String displayHomePage(ModelMap model) {
		
		//model.addAttribute("parks", allParks); 
		
		//if (model.get("tempClass") != null) {
		//	System.out.println("HOMEPAGE..." + model.get("tempClass").toString()); 
	//	}
		
		return "main"; 
	}
	
	@RequestMapping(path="/state", method=RequestMethod.GET)
	public String displayState() {
		return "state";
	}
}
	
	