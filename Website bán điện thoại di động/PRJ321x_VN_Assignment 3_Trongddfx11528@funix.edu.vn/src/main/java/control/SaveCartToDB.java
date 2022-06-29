package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Customer;
import model.ProductOrders;

import java.io.IOException;
import java.util.List;

import dao.ListProductDao;

/**
 * Servlet implementation class SaveCartToDB
 */
public class SaveCartToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCartToDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int phoneNumber = Integer.parseInt(request.getParameter("phone number"));
		Customer ctm = new Customer(name, address, phoneNumber);
		ListProductDao dao = new ListProductDao();
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("giohang");
		List<ProductOrders> list = cart.getItems();
		dao.saveData(list, ctm);
		session.setAttribute("DbList", list);
		session.setAttribute("DbCustomer", ctm);
		request.getRequestDispatcher("OrderSuccess.jsp").forward(request, response);
	}

}
