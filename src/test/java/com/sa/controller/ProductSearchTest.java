package com.sa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-servlet-context.xml")
public class ProductSearchTest {

    @Autowired
    private WebApplicationContext wac;
    
    @InjectMocks
    private ProductSearch productSearch;

    private MockMvc mockMvc;

    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productSearch).build();
    }
      
	
	@Test
	public void testGetPerson() throws Exception{
		mockMvc.perform(get("/product/{id}", 1))
			.andExpect(status().isOk())
			.andExpect(view().name("productPage"))
			.andExpect(model().attribute("productData", "Jack")
                       );
	}
}
