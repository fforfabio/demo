package com.example.demo;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order(1)
	void test1() throws Exception {
	    this.mockMvc.perform(
	    		MockMvcRequestBuilders
	    			.get("/vehicle/all")
	    			.with(jwt().authorities(
	    					new SimpleGrantedAuthority("SCOPE_data.read"), 
	    					new SimpleGrantedAuthority("SCOPE_openid"))))
			.andDo(print())
	        .andExpect(status().isOk());

	}

}
