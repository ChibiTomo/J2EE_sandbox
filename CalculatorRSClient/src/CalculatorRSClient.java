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

import com.jlg.tutorial.obj.Vector;
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

		System.out.println("Call 1:");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_PLAIN)
				.get(Response.class).toString());

		System.out.println("\nCall 2:");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_PLAIN)
				.get(String.class));

		System.out.println("\nCall 3:");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_XML)
				.get(String.class));

		System.out.println("\nCall 4:");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request().accept(MediaType.TEXT_HTML)
				.get(String.class));

		System.out.println("\nCall 5:");
		System.out.println(target.path("rest").path("calc").queryParam("a", 3)
				.queryParam("b", 2).request()
				.accept(MediaType.APPLICATION_JSON).get(String.class));

		System.out.println("\nCall 6:");
		Form form = new Form();
		form.param("type", "Person");
		System.out.println(target.path("rest").path("parser").path("42")
				.queryParam("name", "Yannis").request()
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.form(form), String.class));

		System.out.println("\nCall 7:");
		System.out.println(target.path("rest").path("calc").path("addVector")
				.queryParam("v1", new Vector(1, 2))
				.queryParam("v2", new Vector(3, 4)).request()
				.accept(MediaType.APPLICATION_JSON).get(Vector.class));

		System.out.println("\nCall 8:");
		Form vectorform = new Form();
		vectorform.param("v1", new Vector(1, 2).toString());
		vectorform.param("v2", new Vector(3, 4).toString());
		System.out.println(target.path("rest").path("calc")
				.path("scalarVector").request().accept(MediaType.TEXT_PLAIN)
				.post(Entity.form(vectorform), Integer.class));
	}
}
