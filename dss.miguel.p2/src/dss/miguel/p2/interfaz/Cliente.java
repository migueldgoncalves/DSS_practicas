package dss.miguel.p2.interfaz;

import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class Cliente {
	
	public static final int PORT = 9090;
	public static final String PATH = "dss.miguel.p2";
	
	public static void main(String[] args) {
		
		ClientConfig config = new DefaultClientConfig();
		Client cliente = Client.create(config);
		WebResource servicio = cliente.resource(getBaseURI());
		
		//GET de todos los usuarios
		System.out.println("Contenido inicial de la base de datos");
		System.out.println(servicio.path("rest").path("usuarios").
				accept(MediaType.TEXT_XML).get(String.class));
		
		//GET de un usuario
		System.out.println("Usuario 1");
		System.out.println(servicio.path("rest").path("usuarios/1").
				accept(MediaType.TEXT_XML).get(String.class));
		
		//GET del numero de usuarios
		System.out.println("Numero de usuarios");
		System.out.println(servicio.path("rest").path("usuarios/cont").
				accept(MediaType.TEXT_PLAIN).get(String.class));
		
		//POST
		Form form = new Form();
		form.add("name", "Gabriel");
		form.add("email", "gabriel@email.com");
		System.out.println("Creacion de usuario");
		servicio.path("rest").path("usuarios").
				type(MediaType.APPLICATION_FORM_URLENCODED).
				post(ClientResponse.class, form);
		System.out.println(servicio.path("rest").path("usuarios").
				accept(MediaType.TEXT_XML).get(String.class));
		
		//PUT
		form = new Form();
		form.add("id", "3");
		form.add("name", "Miguel");
		form.add("email", "miguel@email.com");
		System.out.println("Actualizacion de usuario");
		servicio.path("rest").path("usuarios").
				type(MediaType.APPLICATION_FORM_URLENCODED).
				put(ClientResponse.class, form);
		System.out.println(servicio.path("rest").path("usuarios").
				accept(MediaType.TEXT_XML).get(String.class));
		
		//DELETE
		form = new Form();
		form.add("id", "3");
		System.out.println("Remocion de usuario");
		servicio.path("rest").path("usuarios").
				type(MediaType.APPLICATION_FORM_URLENCODED).
				delete(ClientResponse.class, form);
		System.out.println(servicio.path("rest").path("usuarios").
				accept(MediaType.TEXT_XML).get(String.class));
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:"+ PORT + "/" + PATH).build();
	}
}