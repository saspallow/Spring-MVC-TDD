package com.sa.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sa.model.Product;
import com.sa.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-servlet-context.xml")
public class ProductSearchTest {

    @Autowired
    private WebApplicationContext wac;
    
    @InjectMocks
    private ProductSearch productSearch;
    
    @Mock
    private ProductService productService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productSearch).build();
    }
      
	
	@Test
	public void testGetProduct() throws Exception{
	 
		mockMvc.perform(get("/product/{id}", 1L))
			.andExpect(status().isOk())
			.andExpect(view().name("productPage"))
			.andExpect(model().attribute("productData",
                    allOf(
                    		hasProperty("id", is(1L)),
                    		hasProperty("name", is("Jack"))
                          )
                            
                            			)
                       );
	}
	
	@Test
	public void testGetProductNull() throws Exception{
		mockMvc.perform(get("/product/{id}", 0))
			.andExpect(status().isOk())
			.andExpect(view().name("productPage"))
			.andExpect(model().attribute("msg", "Data Not found")
                       );
	}
}
