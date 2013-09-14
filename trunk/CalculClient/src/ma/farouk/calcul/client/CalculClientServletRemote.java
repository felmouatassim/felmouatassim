package ma.farouk.calcul.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.farouk.client.CalculRemote;

/**
 * Servlet implementation class CalculClientServlet
 */
public class CalculClientServletRemote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//utilisation de l'annotation @EJB puisque c'est dans l'EJB est dans le même fichier .ear
	//si ce n'est pas le cas, on peut utiliser l'InitialContext. le code est en bas.
	
	@EJB(mappedName ="calculEJB")
	private CalculRemote calc;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculClientServletRemote() {
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
			
			// utilisation du Initial context pour réferencer l'EJB
//			InitialContext ic = ClientUtility.getInitialContext();
//			CalculRemote calc = (CalculRemote) ic.lookup("calculEJB#ma.atos.client.CalculRemote");
			
	        int somme = calc.product(a, b);
			PrintWriter wr = response.getWriter();
			wr.println(a+" * "+b+" = " + somme);
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
