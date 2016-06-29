

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionFactory;
import net.sf.json.JSONObject;


/**
 * Servlet implementation class Controle
 */
@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controle() {
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
		HashMap<String, String> hm = new HashMap<String, String>();
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
//		PrintWriter out2 = response.getWriter();
//		out2.print("<HTML><HEAD><TITLE>Servlet</TITLE></HEAD><BODY>DEU CEERTOOOOOOOOOOOOOOOO........NOME: "
//		+ nome + "<br> IDADE: "+ idade +"</BODY></HTML>");
		String msg = "";
		
		if(!nome.isEmpty()){
//			int idade = 20;
			Nome n1 = new Nome(nome, idade);
			NomeDAO nomeDao = new NomeDAO();
			nomeDao.inserirNome(n1);
		}
		
//		if(!nome.isEmpty() && idade != 0){
//			msg = "nome: "+nome+" \n idade: "+idade;
//		}
//		else if(idade == 0){
//			msg = "NÃO OK!";
//		}
		hm.put("message", msg);
		//Cada chave do HashMap vira uma chave do JSON
		
		JSONObject json = JSONObject.fromObject(hm);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
