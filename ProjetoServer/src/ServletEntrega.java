

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ServletEntrega
 */
@WebServlet("/ServletEntrega")
public class ServletEntrega extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEntrega() {
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

			String endereco = request.getParameter("endereco");
			String descricao = request.getParameter("descricao");
			int id = Integer.parseInt(request.getParameter("entregador_id"));
		
			Entrega e = new Entrega(endereco, descricao, id);
			EntregaDAO eDao = new EntregaDAO();
			try {
				PrintWriter out = response.getWriter();
				if(eDao.inserirEntrega(e)){
					
					out.println("<html><body>Entrega cadastrada com sucesso!");
					out.println("</body></html>");
					out.close();
				}else{
					out.println("<html><body>Entrega nao cadastrada");
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
		
		
		//action pra parte web
		if(action.equals("listar")){
			EntregaDAO eDao = new EntregaDAO();
			List<Entrega> lista = new ArrayList();
			try {
				lista = eDao.getTodos();
//				PrintWriter out = response.getWriter();
//				for(int i = 0; i < lista.size(); i++){
//					out.println(lista.endereco);
//					
//				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/ListarEntregas.jsp");
            rd.forward(request, response);
		}
		
		//action pra parte android
		if(action.equals("listaEntregador")){
			String id = request.getParameter("id");
			EntregaDAO eDao = new EntregaDAO();
			int entregador_id = Integer.parseInt(id);
			System.out.println(entregador_id);
			try {
				List<Entrega> listaEntregas = eDao.getPorEntregador(entregador_id);
				JSONArray jsArray = new JSONArray();
				
				HashMap<String, String> hm = new HashMap<>();
				for(int i = 0; i < listaEntregas.size(); i++){
					hm.put("endereco", listaEntregas.get(i).getEndereco());
					hm.put("descricao", listaEntregas.get(i).getDescricao());
					hm.put("entregador_id", entregador_id + "");
					hm.put("status", listaEntregas.get(i).getStatus());
					hm.put("id", listaEntregas.get(i).getId() + "");
					jsArray.add(hm);
				}
				PrintWriter out = response.getWriter();
			     out.print(jsArray);
			     out.flush();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
