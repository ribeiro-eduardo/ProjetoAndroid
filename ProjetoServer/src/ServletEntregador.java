

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEntregador
 */
@WebServlet("/ServletEntregador")
public class ServletEntregador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEntregador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equals("cadastrar")){
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			Entregador e = new Entregador(login, senha);
			EntregadorDAO eDao = new EntregadorDAO();
			try {
				if(eDao.inserirEntregador(e)){
					PrintWriter out = response.getWriter();
					out.println("<html><body>Entregador "+login+ " cadastrado com sucesso!");
					out.println("</body></html>");
					out.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			 request.setAttribute("entregador", e);
//			 RequestDispatcher rd = new getServletContext().getRequestDispatcher("/index.jsp");
//		        RequestDispatcher rd = request.getRequestDispatcher("resultadoimc.jsp");
//		        rd.forward(request, response);
		}
		
	}

}
