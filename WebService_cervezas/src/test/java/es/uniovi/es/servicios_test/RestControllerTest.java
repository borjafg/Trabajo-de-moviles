package es.uniovi.es.servicios_test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class RestControllerTest {

	private URL base;
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + "8080/");
		template = new TestRestTemplate();
	}

	@Test
	public void cervezaEncontada() throws Exception {
		String cervezaURI = base.toString() + "/cerveza_info";

		ResponseEntity<String> response = this.template.postForEntity(cervezaURI,
				new PeticionServicioWeb("cerveza_mala"), String.class);

		assertThat(response.getBody(),
				equalTo("{\"email\":\"jk@gmail.com\",\"name\":\"Jack\",\"nif\":\"980151\",\"poolingState\":1}"));

	}

	public class PeticionServicioWeb {
		private String nombre;

		public PeticionServicioWeb() {
		}

		public PeticionServicioWeb(String nombre) {
			this.nombre = nombre;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}

}