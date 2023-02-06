import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is used to create cookies.
 * 
 */
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// no-argument constructor
	public CreateCookieServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get parameters from request object.
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();

		// check for null and empty values.
		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			out.print("Please enter both username " + "and password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
			requestDispatcher.include(request, response);
		} // Check for valid username and password.
		else if (userName.equals("Bill") && password.equals("Wilbur")) {

			// TODO
			// create cookie objects. for userName and password

			// TODO
			// add cookie in the response object.

			out.print("<h3>Cookies are created. Click on the " + "below button to get cookies.");
			out.print("<form action='GetCookieServlet' method='POST'>");
			out.print("<input type='submit' value='Get Cookie'>");
			out.print("</form>");

			out.close();
		} else {
			out.print("Wrong username or password. <br/><br/>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
			requestDispatcher.include(request, response);
		}
	}
}