package br.com.procode.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
	@Bean
	public OpenAPI openApi() {
		Contact contact = new Contact();
		contact.setEmail("apialunos@email.com");
		contact.setName("Api Alunos");
		contact.setUrl("www.apialunos.com.br");
		
		Info info = new Info() 
				.title("Api Alunos")
				.version("1.0")
				.contact(contact)
				.description("Api direcionada para gerenciar os alunos de uma instituição de ensino.");
	  
		return new OpenAPI()
			  .info(info);
			  
	}

}
