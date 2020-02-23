package porter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicServlet
 */
@WebServlet(name = "BasicServlet", urlPatterns = {"/BasicServlet"})
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String user = request.getParameter("uname");
		String pword = request.getParameter("pword");
		
		if(user.equals("Tuckett") && pword .equals("java")) {
			out.println("<html><head><style>\r\nh1{\r\ntext-align: left;\r\n" + 
					"font-family: arial;\r\n}\r\nbody{\r\nbackground-color: #0B615E;\r\n" + 
					"font-family: verdana;\r\nfont-size: 14px;\r\ncolor: white;\r\n" + 
					"text-align: center;\r\n}\r\n</style><title>Logged In</title></head><body>");
			out.println("<h1>Welcome, " + user +"</h1>");
			out.println("<p>Your password, " + pword + ", was accepted and you have "
					+ "successfully logged in.</p></body></html>");
		}
		else {
			response.sendRedirect("kickedOut.jsp");
		}
	}
}
