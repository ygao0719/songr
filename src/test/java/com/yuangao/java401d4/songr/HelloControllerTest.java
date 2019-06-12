package com.yuangao.java401d4.songr;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

	@InjectMocks
	private HelloWorldController helloWorldController;
	private MockMvc mockMvc;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
	}

	@Test
	public void test_capitalize() throws Exception {
		this.mockMvc.perform(get("/capitalize/this is ok")).andExpect(status().isOk());
	}

	@Test
	public void test_reverse() throws Exception {
		this.mockMvc.perform(get("/reverse?sentence=this is ok")).andExpect(status().isOk());
	}

}
