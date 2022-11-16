/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Characters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRINCIPAL
 */
public class LoadPlayer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            int Name = Integer.parseInt(request.getParameter("Name"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/players", "root", "Admin$1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from players where Name=" + Name);
            resultSet.next();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet players</title>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\" integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js\" integrity=\"sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz\" crossorigin=\"anonymous\"></script>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\" style=\"margin-top:5%\">");

            out.println("<div class='card' style='width: 45rem;'>");
            out.println("    <div class='card-header'>");
            out.println("        Update Player");
            out.println("    </div>");
            out.println("    <div class='card-body'>");
            out.println("        <form action='updatePlayerList' method='post'>");
            out.println("            <div class='row'>");
            out.println("                <div class='col'>");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                    </div>");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getString("Name") + "' name='txtName' type='text' class='form-control' id='txtName' placeholder='nombre' required>");
            out.println("                        <label for='txtName'>Name</label>");
            out.println("                    </div>        ");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getString("Race") + "' name='txtRace' type='text' class='form-control' id='txtRace' placeholder='Race' required>");
            out.println("                        <label for='txtRace'>Race</label>");
            out.println("                    </div> ");
            out.println("                </div>");
            out.println("                <div class='col'>");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getInt("Age") + "' name='txtAge' type='number' class='form-control' id='txtAge' placeholder='99999' required>");
            out.println("                        <label for='txtAge'>Age</label>");
            out.println("                    </div>  ");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getString("Lore") + "' name='txtLore' type='text' class='form-control' id='txtLore' placeholder='Lore' required>");
            out.println("                        <label for='txtLore'>Lore</label>");
            out.println("                    </div>  ");
            out.println("                    <div class='form-floating'>");
            out.println("                    </div>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("            <hr>");
            out.println("            <button type='submit' class='btn btn-primary' style='float: right'>update</button>");
            out.println("           <a class=\"btn btn-danger\" style='float: left' href='deletePlayer?Name=" + resultSet.getString("Name") + "'>Eliminar</a>");
            out.println("        </form>");
            out.println("   <a class=\"btn\" style='float: left' href=\"index.html\">Go back</a>");
            out.println("    </div>");
            out.println("</div>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
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
