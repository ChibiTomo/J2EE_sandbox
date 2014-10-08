import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		ResourceBundle rb = ResourceBundle.getBundle("LocalStrings",request.getLocale());

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String msg = rb.getString("helloworld.msg");

		out.println("<html><body>msg(\u20AC)=" + msg + "</body></html>");
	}
}



