package br.com.yaw.querydsl.web;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.yaw.querydsl.boot.Application;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Testes (integrados) da controller REST de Mercadorias.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MercadoriaControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
	protected static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testHealth() throws Exception {
		this.mvc.perform(get("/health")
				.accept(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("UP")));
	}
	
	@Test
	public void testGetAll() throws Exception {
		this.mvc.perform(get("/")
				.accept(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andExpect(jsonPath("mercadorias", hasSize(greaterThanOrEqualTo(1))))
			.andExpect(jsonPath("mercadorias", hasSize(lessThan(11))));
	}
	
	@Test
	public void testGetByQuantidade_2() throws Exception {
		this.mvc.perform(get("/by-quantidade")
				.param("quantidade", "2")
				.accept(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk());
	}
	
	@Test
	public void testGetByDescricao() throws Exception {
		this.mvc.perform(get("/by-descricao")
				.param("descricao", "Coca-cola")
				.accept(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk());
	}
	
}
