import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.jlg.tutorial.entity.Vector;
import com.owlike.genson.ext.jaxrs.GensonJsonConverter;

public class CalculatorRSClient {

	public static void main(String[] args) {
		URI baseURI =
				UriBuilder.fromUri("http://localhost:8080/CalculatorRS")
						.build();
		ClientConfig config = new ClientConfig();
		config.register(GensonJsonConverter.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(baseURI);

		System.out.println("Appel 1: affiche l'objet Response");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_PLAIN)
				.get(Response.class).toString());

		System.out.println("\nAppel 2: "
				+ "affiche le contenu de la réponse sous forme de String."
				+ "\nMIME-TYPE accepté: text/plain");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_PLAIN)
				.get(String.class));

		System.out.println("\nAppel 3: "
				+ "affiche le contenu de la réponse sous forme de String."
				+ "\nMIME-TYPE accepté: text/xml");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_XML)
				.get(String.class));

		System.out.println("\nAppel 4: "
				+ "affiche le contenu de la réponse sous forme de String."
				+ "\nMIME-TYPE accepté: text/html");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_HTML)
				.get(String.class));

		System.out.println("\nAppel 5: "
				+ "affiche le contenu de la réponse sous forme de String."
				+ "\nMIME-TYPE accepté: text/plain");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request()
				.accept(MediaType.APPLICATION_JSON).get(String.class));

		System.out.println("\nAppel 6: "
				+ "Test sur le ParserRS (QueryParam, PathParam, FormParam)");
		Form form = new Form();
		form.param("type", "Person");
		System.out.println(target.path("rest").path("parser").path("42")
				.queryParam("name", "Yannis").request()
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.form(form), String.class));

		System.out.println("\nAppel 7: "
				+ "Passer des objets complexes, retourner un objet complexe.");
		System.out.println(target.path("rest").path("calc").path("addVector")
				.queryParam("v1", new Vector(1, 2))
				.queryParam("v2", new Vector(3, 4)).request()
				.accept(MediaType.APPLICATION_JSON).get(Vector.class));

		System.out.println("\nAppel 8: "
				+ "Test en POST avec retour d'un nombre entier");
		Form vectorform = new Form();
		vectorform.param("v1", new Vector(1, 2).toString());
		vectorform.param("v2", new Vector(3, 4).toString());
		System.out.println(target.path("rest").path("calc")
				.path("scalarVector").request().accept(MediaType.TEXT_PLAIN)
				.post(Entity.form(vectorform), Integer.class));
	}
}
