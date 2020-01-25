package br.com.api;





import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


//@SpringBootTest(properties = "spring.profiles.active=test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ServerStatusControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void Teste_retornarClassificacaoOficios() throws Exception {
		
		mockMvc.perform(get("/ServerStatus").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
