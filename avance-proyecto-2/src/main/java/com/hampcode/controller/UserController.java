package com.hampcode.controller;

import com.hampcode.entity.User;
import com.hampcode.service.UserService;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Stubbing;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.getAll());
		return "users/list";
	}

	@GetMapping("/new")
	public String newUserForm(Model model) {
		model.addAttribute("user", new User());
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
	public String editUserForm(@PathVariable("id") long id, Model model) {
		User user = userService.getOneById(id);
		model.addAttribute("user", user);
		return "users/edit";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, User user) {
		userService.update(id, user);
		return "redirect:/users";
	}

}
