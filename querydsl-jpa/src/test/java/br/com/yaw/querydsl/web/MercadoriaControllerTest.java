package br.com.yaw.querydsl.web;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
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
	public void testGetGroupByCategoria() throws Exception {
		this.mvc.perform(get("/group-by-categoria")
				.accept(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk());
	}
	
	@Test
	public void testIncreaseAll() throws Exception {
		this.mvc.perform(post("/increase")
				.accept(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk());
	}
	
}
