package ma.atos.calcul.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.atos.client.CalculLocal;

/**
 * Servlet implementation class CalculClientServlet
 */
public class CalculClientServletLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Il faut que l'EJB Local et son client soient dans le même EAR file
	//un EJB local n'a pas de JNDI, il faut pas utiliser l'attribut "mappedName"
	@EJB
	private CalculLocal calc;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculClientServletLocal() {
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
			int a = new Integer(request.getParameter("a")).intValue();
			int b = new Integer(request.getParameter("b")).intValue();
	        int somme = calc.add(a, b);
			PrintWriter wr = response.getWriter();
			wr.println(a+" + "+b+" = " + somme);
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
