package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/AccueilIcroack")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		out.println("<html><head><link href=\"styles/style.css\" rel=\"stylesheet\"></head><body body class=\"accueil\">"
				+	"<div class=\"titre\"> <img class=\"imgTitle\" id=\"imgTitleMorpion\" src=\"ressources/Title.png\""
				+   " alt=\"Morpion\"></div>"
				+ 	"<h2>Bienvenue, " + session.getAttribute("playerName") + "</h2>"
				//Nouvelle Partie
				+	"<form name = \"FormNewGame\" action=\"Plateau.jsp\" method=GET>"
				+	"<div class=\"formulaire\"><input id=\"buton\" classe=\"buton\"  type =\"submit\" value=\"Nouvelle partie\"/></input></div>"
				+	"</form>"

				//Tableau des Scores
				+	"<form name = \"FormScores\" action=\"Scoreboard\" method=GET>"
				+	"<div class=\"formulaire\"><input id=\"buton\" classe=\"buton\"  type =\"submit\" value=\"Tableau des scores\"></input></div>"
				+	"</form>"
				
				//Morpion (TicTacToe)
				+	"<form name = \"FormTTT\" action=\"tictactoe\" method=GET>"
				+	"<div class=\"formulaire\"><input id=\"buton\" classe=\"buton\"  type =\"submit\" value=\"Morpion\"></input></div>"
				+	"</form>");
		if(session.getAttribute("isAdmin").equals("1")) {
			out.print("<form name = \"FormAdminButton\" action=\"ViewAdmin\" method=GET>"
					+	"<div class=\"formulaire\"><input id=\"buton\" classe=\"buton\"  type =\"submit\" value=\"Admin\"></input></div>"
					+	"</form>");
		}
		//Déconnexion
		out.print(				
				"<form name = \"FormDisconnect\" action=\"controlerDeconnexion\" method=GET>"
				+	"<div class=\"formulaire\"><input id=\"buton\" classe=\"buton\" type =\"submit\" value=\"Deconnexion\"></input></div>"
				+	"</form>"
				);
		
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
