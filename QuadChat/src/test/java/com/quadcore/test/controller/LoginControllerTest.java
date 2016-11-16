package com.quadcore.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import com.quadcore.chat.controller.LoginController;

public class LoginControllerTest {
	
	@Test
	public void testHomePage() throws Exception
	{
		LoginController controller = new LoginController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/login"))
				.andExpect(view().name("login.html"));
			
	}

}
