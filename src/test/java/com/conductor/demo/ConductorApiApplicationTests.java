package com.conductor.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.conductor.demo.model.Registro;
import com.conductor.demo.service.RegistroService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ConductorApiApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private RegistroService registroService;
    
	@Test
	void contextLoads() {
	}

	 @Test
	    void postCreateRegistroIsOk() throws Exception {
	        
		 String request="12;123;PWWIN;-0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
	        
	        mockMvc.perform(post("/v1.0/entidade")
	                .contentType("text/html")
	        		.content(request))
	        		.andExpect(status().isCreated());
	                
	    }
	 
	 @Test
	    void getRegistrosIsOk() throws Exception {
	        

	        mockMvc.perform(get("/v1.0/entidade/12")
	                .contentType("application/json"))
	                .andExpect(status().isOk());

	    }
	
	 @Test
	    void putUpdateRegistroIsOk() throws Exception {
	        
		 Long logic=(long) 12;
		 Registro registro = registroService.getRegistro(logic);
		 registro.setModel("ModelUpdate");
	        mockMvc.perform(put("/v1.0/entidade/12")
	                .contentType("application/json")
	        		.content(objectMapper.writeValueAsString(registro)))
	        		.andExpect(status().isOk());	
	               
	    }
	 
	 @Test
	    void deleteRegistroIsOk() throws Exception {
	     
	        mockMvc.perform(delete("/v1.0/entidade/12"))
	        		.andExpect(status().isMethodNotAllowed());	
	               
	    }
	
}
