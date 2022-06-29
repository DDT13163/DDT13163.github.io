package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			request.getSession(true).invalidate();
			//make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			//collect data from a login form
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Account acc = new Account();
			acc.setName(email); acc.setPwd(password);
			HttpSession session = request.getSession(true);
			if (!password.matches(regex) || !email.matches(regexMail)) {
				session.setAttribute("error", "invalid syntax");
				response.sendRedirect("LoginAdmin.jsp");
			}
			//read information of account in web.xml
			String uid = getServletContext().getInitParameter("email");
			String pwd = getServletContext().getInitParameter("password");
			Boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
			//check account - use validate code in assignment 1 to valid user
			if (email != null && acc.getPwd().equals(pwd) && acc.getName().equalsIgnoreCase(uid)) {
				//set session
				session.setAttribute("email", email);
				//set cookie
				Cookie ecookie = new Cookie("email",email);
				ecookie.setMaxAge(3600);
				Cookie pcookie = new Cookie("password",password);
				pcookie.setMaxAge(3600);
				response.addCookie(ecookie);
				response.addCookie(pcookie);
				//login is valid, now redirect to index page of admin
				response.sendRedirect("HomeAdmin.jsp");
			}
			else {
				session.setAttribute("error", "wrong username or password");
				response.sendRedirect("LoginAdmin.jsp");
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("LoginAdmin.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
