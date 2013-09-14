package ma.farouk.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.farouk.business.ICustomer;
import ma.farouk.entity.Customer;

/**
 * Servlet implementation class CalculClientServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// utilisation de l'annotation @EJB puisque c'est dans l'EJB est dans le
	// même fichier .ear
	// si ce n'est pas le cas, on peut utiliser l'InitialContext. le code est en
	// bas.

	@EJB(mappedName = "CustomerBean")
	private ICustomer customerBean;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.getParameterNames();
			request.getParameter("a");
			String method = (String) request.getParameter("method");
			PrintWriter wr = response.getWriter();
			if (method.equals("get")) {
				int a = new Integer(request.getParameter("a")).intValue();
				Customer cust = customerBean.getCustomer(a);
				
				wr.println("nom : " + cust.getNom());
				wr.println("prenom : " + cust.getPrenom());
				wr.println("pays : " + cust.getPays());
			} else if (method.equals("add")) {
				String name = (String) request.getParameter("name");
				String firstname = (String) request.getParameter("firstname");
				String country = (String) request.getParameter("country");
				
				customerBean.addCustomer(firstname, name, country);
				wr.println("Ok");		
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
