/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.afiliar.servlets;

import apd3.afiliar.controllers.ControllerFactory;
import apd3.afiliar.controllers.IController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsável por fazer a interação entre a view e a parte interna do
 * sistema (model). Delega as atividades para os controllers corretos.
 *
 * @author Victor Ribeiro
 */
@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/FrontControllerServlet"})
public class FrontControllerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //Pega a ação a ser executada pelo controller
            String action = request.getParameter("action");
            //Pega o parâmetro control enviado pela requisição HTTP
            String controller = request.getParameter("control");
            //Pega um objeto de alguma classe que implemente a interface Controller
            IController control = ControllerFactory.getControllerByFullClassName(controller);
            //Inicializa o controller
            control.init(request);
            //Executa a ação
            control.execute(action);
            //Define a página de resposta
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(control.getReturnPage());
            //Redireciona para a página de resposta
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
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
