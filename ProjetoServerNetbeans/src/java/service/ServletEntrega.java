package service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acv28
 */
@WebServlet(urlPatterns = {"/ServletEntrega"})
public class ServletEntrega extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
		}
		
		if(action.equals("listar")){
			EntregaDAO eDao = new EntregaDAO();
			List<Entrega> lista = new ArrayList();
			try {
				lista = eDao.getTodos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/ListarEntregas.jsp");
            rd.forward(request, response);
		}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
