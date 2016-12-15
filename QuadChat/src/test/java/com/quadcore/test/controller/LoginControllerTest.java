/*package com.quadcore.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import com.quadcore.chat.controller.LoginController;

*//**
 * Testing the Spring MVC - Login Controller
 * <p>
 * @author Quadcore
 * @since 11/21/16
 * @version 2.0
 * @category Test
 * @see LoginController
 *
 *//*
public class LoginControllerTest {
	
	private LoginController controller;
	
	@Test
	public void testLoginPage() throws Exception
	{
		controller = new LoginController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/login"))
				.andExpect(view().name("login"))
				.andExpect(status().isFound())
				.andDo(print());
	}
	
	@Test
	public void testLoginForm() throws Exception
	{
		controller = new LoginController();
		MockMvc mockMvc = standaloneSetup(controller).build();

		mockMvc.perform(post("/login"))
			.andExpect(view().name("login"))
			.andExpect(redirectedUrl("/"))
			.andExpect(status().isFound())
			.andDo(print());
	}
}*/