package com.hampcode.controller;

import com.hampcode.entity.User;
import com.hampcode.service.impl.CountryService;
import com.hampcode.service.impl.DepartmentService;
import com.hampcode.service.impl.ProvinceService;
import com.hampcode.service.impl.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import com.google.gson.Gson;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CountryService countryService;

	@GetMapping
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAll());
		return "users/list";

	}

	@GetMapping("/new")
	public String newUserForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("countries", countryService.getAllCountry());
		return "users/new";
	}

	@PostMapping("/save")
	public String saveNewUser(@Valid User user, BindingResult result, Model model, SessionStatus status) {

		try {
			if (result.hasErrors()) {
				return "users/new";
			}
			userService.create(user);
			status.setComplete();
		} catch (Exception e) {

		}
		return "redirect:/users";
	}

	@GetMapping("/edit/{id}")
	public String editUserForm(@PathVariable long id, Model model) {
		User user = userService.getOneById(id);
		model.addAttribute("user", user);
		model.addAttribute("countries", countryService.getAllCountry());
		model.addAttribute("departments", departmentService.getAllDeparmentByCountry(user.getCountry().getId()));
		model.addAttribute("provinces", provinceService.getAllProvinceByDeparment(user.getDepartment().getId()));
		return "users/edit";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable long id, @ModelAttribute("user") User user) {
		userService.update(id, user);
		return "redirect:/users";
	}

	@ResponseBody
	@RequestMapping(value = "loadDeparmentByCountry/{id}", method = RequestMethod.GET)
	public String loadStatesByCountry(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(departmentService.getAllDeparmentByCountry(id));
	}

	@ResponseBody
	@RequestMapping(value = "loadProvinceByDeparment/{id}", method = RequestMethod.GET)
	public String loadCitiesByState(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(provinceService.getAllProvinceByDeparment(id));
	}

}
