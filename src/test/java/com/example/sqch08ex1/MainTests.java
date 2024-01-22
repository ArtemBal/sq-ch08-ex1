package com.example.sqch08ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MainTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Test that /home page can be successfully called.")
	void testPageRequestAndContent() throws Exception {
		mockMvc.perform(get("/home")).andExpect(status().isOk());
	}

	@Test
	@DisplayName("Test that request parameters are get successfully.")
	void testRequestParameters() throws Exception {
		mockMvc.perform(get("/home?color=green&name=Artem"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("username", "Artem"))
				.andExpect(model().attribute("color", "green"));
	}

	@Test
	@DisplayName("Test that path variables are added successfully")
	void testPathVariables() throws Exception {
		mockMvc.perform(get("/homePP/blue"))
				.andExpect(model().attribute("color", "blue"));
	}
}
