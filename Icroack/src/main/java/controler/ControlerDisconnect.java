package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


/* Servlet implementation class controlerDeconnexion
 */
@WebServlet("/controlerDeconnexion")        //Adresse de la page

public class ControlerDisconnect extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /* @see HttpServlet#HttpServlet()
     */
    public ControlerDisconnect() {
        super();
        // TODO Auto-generated constructor stub
    }
    /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        HttpSession session = request.getSession();        //comme session_start();
        session.invalidate();

        System.out.println("Deconnexion reussie");
        getServletContext().getRequestDispatcher("/LoginIcroack").forward(request, response );
        // construction d'un request dispatcher sur le chemin vers la page Login, qui doit exister dans la web application courante
    }

    /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}