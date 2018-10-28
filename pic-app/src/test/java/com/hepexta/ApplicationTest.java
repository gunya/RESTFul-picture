package com.hepexta;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testIndexPage() throws Exception {
		MediaType contentType = new MediaType(MediaType.TEXT_HTML.getType(), MediaType.TEXT_HTML.getSubtype(), Charset.forName("utf8"));
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(content().string(CoreMatchers.containsString("Welcome")));
	}

	@Test
	public void testInvalidPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/INVALID"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void testErrorPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/error"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().string(CoreMatchers.containsString(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())));
	}

	@Test
	public void testErrorPost() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/error"))
				.andExpect(MockMvcResultMatchers.status().isInternalServerError())
				.andExpect(content().string(CoreMatchers.containsString("No message available")));
	}
}
