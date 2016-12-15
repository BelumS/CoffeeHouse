package com.quadcore.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import com.quadcore.chat.controller.IndexController;

/**
 * Testing the Spring MVC - Index Controller
 * <p>
 * @author Quadcore
 * @since 11/21/16
 * @version 2.0
 * @category Test
 * @see IndexController
 *
 */
public class IndexControllerTest {
	
	@Test
	public void testHomePage() throws Exception
	{
		IndexController controller = new IndexController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/"))
				.andExpect(view().name("index"))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
