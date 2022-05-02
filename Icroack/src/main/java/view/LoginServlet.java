package view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginIcroack")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
	

		out.println("<html><head><link href=\"styles/style.css\" rel=\"stylesheet\"></head><body class=\"accueil\">"
				+	"<div class=\"titre\"> <img class=\"imgTitle\" src=\"ressources/Title.png\""
				+   " alt=\"Titre du jeu\"></div>"
				+	"<form name=\"FormConnexion\" action=\"ControllerConnexion\" method=GET>");
					
		out.println("<form name=\"FormConnexion\" action=\"ControllerConnexion\" method=GET>"
				+ "<div class=\"formulaire\"> Pseudo : </div>"
				+ "<div class=\"formulaire\" id=\"txtLogin\">"
				+ "<input id=\"texte\" classe=\"\" type=\"text\" name=\"login\"></input></div>");
		out.println("<div class=\"formulaire\">Mot de passe : </div>"
				+ "<div class=\"formulaire\" id=\"txtPswd\">"
				+ "<input id=\"texte\" classe=\"\" type=\"password\" name=\"userPwd\"></input></div>");
		out.print("<div class=\"formulaire\" id=\"btConnexion\">"
				+ "<input type=\"submit\" id=\"buton\" classe=\"buton\" value =\"Connexion\" /></input></form></div>");   
		
		out.println("<form name=\"creerCompte\" action=\"AccountCreation.jsp\" methode=GET>");
		out.println("<div class=\"formulaire\" id=\"btCreer\" >"
				+ "<input id=\"buton\" classe=\"buton\" type=\"submit\" value =\"Creer un compte\" /></input></form></div>");
				
	    if (request.getAttribute("connection")=="vide") {
	        out.print("  <span class=\"refuse\"> Veuillez remplir les champs </span> ");
	    } else if (request.getAttribute("connection")=="false") {
	        out.print("  <span class=\"refuse\"> Pseudo ou mot de passe incorrecte</span> ");
	    }
		
		out.print("</body></html>");
		

					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
