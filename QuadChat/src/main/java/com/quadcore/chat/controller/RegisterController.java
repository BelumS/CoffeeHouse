package com.quadcore.chat.controller;

import java.util.Date;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.quadcore.chat.model.User;
import com.quadcore.chat.service.UserService;

@Controller
public class RegisterController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm(@ModelAttribute("user") User user, Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String submitRegisterForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model)
	{
		
		/*String formattedDate = new SimpleDateFormat("dd/MM/yyyy, Ka").format(userDate);

		String info = String.format("User Submission: id= %d%nUsername = %s%nEmail = %s%nCreated: %s", 
				user.getUserId(), user.getUsername(), user.getEmail(), formattedDate);
		log.info(info);*/
	
		if(result.hasErrors())
		{
			return "register";
		}
		else if(userService.findByUsername(user.getUsername()))
		{
			model.addAttribute("message", "Username already exists. Try another username.");
			return "register";
		}
		else
		{
			userService.save(user);
			model.addAttribute("message", "Saved user details");
			return "results";
		}

	}
}
