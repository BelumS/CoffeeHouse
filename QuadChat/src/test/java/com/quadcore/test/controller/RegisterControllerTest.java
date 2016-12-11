/*package com.quadcore.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import com.quadcore.chat.controller.RegisterController;

public class RegisterControllerTest {
	
	private RegisterController controller;
	
	@Test
	public void testRegistrationPage() throws Exception
	{
		controller = new RegisterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/register"))
				.andExpect(view().name("register"))
				.andDo(print());
	}
	
	@Test
	public void testRegistrationForm() throws Exception
	{
		controller = new RegisterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/register"))
		.andExpect(view().name("results"))
		.andDo(print()); 
	}
}
*/