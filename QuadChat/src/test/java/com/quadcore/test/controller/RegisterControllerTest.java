package com.quadcore.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import com.quadcore.chat.controller.RegisterController;

public class RegisterControllerTest {
	
	@Test
	public void testHomePage() throws Exception
	{
		RegisterController controller = new RegisterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/register"))
				.andExpect(view().name("register"));
			
	}

}
