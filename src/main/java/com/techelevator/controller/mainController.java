package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.State;
import com.techelevator.model.Townhall;
import com.techelevator.model.TownhallDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;


@Controller
@SessionAttributes("selectedState")

public class mainController {
	
	@Autowired
	private TownhallDAO townhallDAO;

	@RequestMapping("/")
	public String displayHomePage(ModelMap model) {
		return "main"; 
	}
	
	@RequestMapping("/main")
	public String displayMainPage(ModelMap model) {
		return "main";
	}

	@RequestMapping(path="/stateInput", method=RequestMethod.GET)
	public String displayState(@RequestParam String state, ModelMap model) {
		model.addAttribute("selectedState", state);
		return "/state"; // <---- the jsp, not the js
	}
	
	
	@RequestMapping(path="/state", method=RequestMethod.GET)
	public String displayStatePage(@RequestParam String locationName, ModelMap map) {
		List<Townhall> townhalls = townhallDAO.getAllTownhalls(locationName);
		map.addAttribute("townhalls", townhalls);
		return "/state";
	}
	
	@RequestMapping("/district")
	public String displayDistrictPage(ModelMap map) {
		return "/district";
	}
	
	@RequestMapping(path="/districtInput", method=RequestMethod.GET)
	public String displayDistrictInput (@RequestParam String district) {
		return "/district";
	}
	
	
	
	@RequestMapping(path="/terms", method=RequestMethod.GET)
	public String displayTerms() {
		return "terms";
	}
	
	@RequestMapping(path="/copyright", method=RequestMethod.GET)
	public String displayCopyright() {
		return "copyright";
	}
	
	@RequestMapping(path="/cookies", method=RequestMethod.GET)
	public String displayCookies() {
		return "cookies";
	}
}
	
	