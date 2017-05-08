package clientrs;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Lanceur {
	public static void main(String[] args) {

		// créer un client par défaut
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// récupérer adresse du webservice
		URI uri = UriBuilder.fromUri("http://localhost:8085/TPWSRest").build();
		// et associer cette adresse au client
		WebResource service = client.resource(uri);
		// créer l'adresse d'une méthode du webservice
		// WebResource path = service.path("banque").path("test");
		WebResource path = service.path("banque").path("infos");
		//envoi d'une requète get à la méthode du webservice
		String res = path.get(String.class);
		System.out.println(res);
	}
}
