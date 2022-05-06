package view;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class ViewAdmin
 */
@WebServlet("/ViewAdmin")
public class ViewAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("isAdmin")=="1") {
			PrintWriter out=response.getWriter();
	
		out.println("<html><head><link href=\"styles/style.css\" rel=\"stylesheet\"></head> <body class=\"accueil\">"
					+ "	<div class=\"titre\"> <img class=\"imgTitle\" id=\"imgSubTitle\" src=\"ressources/adminTitle.png\""
					+ " alt=\"Titre du jeu\"></div>"
					+ "<div><form name=\"formulaire\" action=\"ControleurAdmin\" methode=GET>");
		out.println("<div><h2>Page Admin Icroak's Adventure</h2></div>");
		out.println("<div class=\"formulaire\">Pseudo a supprimer: </div>"
					+ " <div class=\"formulaire\" id=\"txtLogin\">"
					+ "<input id=\"texte\" classe=\"\" type=\"texte\" name=\"pseudo\"></input></div>");
		out.println("<div class=\"formulaire\">Confirmer le pseudo : </div> "
					+ "<div class=\"formulaire\"id=\"txtLogin\">"
					+ "<input id=\"texte\" classe=\"\" type=\"texte\" name=\"pseudoconfirme\"></input></div>");
		out.println("<div class=\"formulaire\" id=\"btSuppression\">"
					+ "<input id=\"buton\" classe=\"buton\" type=\"submit\" value = \"Supprimer compte\" /></input></div>");
		out.println("</form></div>");
		
		out.println("<div><form name=\"formulaire\" action=\"AccueilIcroack\" methode=GET>");
		out.println("<div class=\"formulaire\" id=\"btReturn\">"
					+ "<input id=\"buton\" classe=\"buton\"  type=\"submit\" value = \"Retour Page D'accueil\" /></input></div>");
		
	    if (request.getAttribute("connection")=="vide") {
	        out.print("  <span class=\"refuse\"> Veuillez remplir les champs </span> ");
	    } else if (request.getAttribute("connection")=="false") {
	        out.print("  <span class=\"refuse\"> Compte non connus</span> ");
	    } else if (request.getAttribute("connection")=="nonequals") {
	        out.print("  <span class=\"refuse\"> Pseudos ne correspondent pas</span> ");
	    } else if (request.getAttribute("connection") == "true"){
	        out.print(" <span class=\"ok\"> Suppression de compte réussis</span>");
	    }
	    
		out.println("</form></div></body></html>");
	}
	
	else {
		getServletContext().getRequestDispatcher("/LoginIcroack").forward(request,response);
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
