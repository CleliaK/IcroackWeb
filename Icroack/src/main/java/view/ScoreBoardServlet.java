package view;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DAOIcare;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ScoreBoardServlet
 */
@WebServlet("/Scoreboard")
public class ScoreBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		//Accès BDD, on va chercher les noms des joueurs et leur score et on effecture un tri par score descendant (du plus haut au plus bas)
		try {
			DAOIcare dao=new DAOIcare("com.mysql.cj.jdbc.Driver", "icare","root","paw*gwe-VFG1mpf*qpe");
			String query ="select score_game,login from player where score_game is not null order by score_game desc LIMIT 7;";
			ResultSet scores=dao.getStatement().executeQuery(query);
			out.print("<html><head><link href=\"styles/style.css\" rel=\"stylesheet\"></head><body class=\"accueil\"><center><table  class=\"tableau\">"
			+	"<div class=\"titre\"><img class=\"imgLeaderBoard\" src=\"ressources/ScoreBoard.png\"\"\r\n\"\r\n"
			+ "					+ \"		  \" alt=\"Leader Board\"> </div>");
			
			out.print("<tr>"
					+ "<td class=\"titleTable\">Classement</td>"
					+ "<td class=\"titleTable\">Pseudo</td>"
					+ "<td class=\"titleTable\">Score</td>"
					+ "</tr>");
			int cpt=1;
			while(scores.next()) {
				out.print("<tr>"
					+ "<td >" + cpt + "</td>"
					+ "<td >" + scores.getString("login") + "</td>"
					+ "<td >" + scores.getString("score_game") + "</td>"
					+ "</tr>");
				cpt++;
			}
			out.print("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<form name = \"FormReturnHome\" action=\"ReturnHome\" method=GET>"
				+	"<input id=\"buton\" classe=\"\"  type =\"submit\" value=\"Accueil\" /></input>"
				+	"</form>");
		out.print("</center></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
