package view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Quizz;


/**
 * Servlet implementation class controlerDeconnexion
 */
@WebServlet("/viewQuizz")		//Adresse de la page

public class viewQuizz extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewQuizz() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession();
    	Quizz quizz=(Quizz)session.getAttribute("questionsQuizz");
		if(quizz.getNumQuestion()<5) {
			out.println("<HTML>"
				+ "<HEAD>"
				+ "<meta charset='utf-8'>"
				+ "<link href=\"styles/style.css\" rel=\"stylesheet\" />"
				+ "<script type=\"text/javascript\" src='./js/countdown.js'></script>"
				+ "</HEAD>"
				+ "<body class=\"accueil\">");
			
			out.println("<H1>QUIZZ ICROACK</H1>"
				+   "<div id=\"containerQuizz\">"
				+   "<div class=\'question\' id=\'question\'>" + quizz.getSpecificQuestion(quizz.getNumQuestion(), 0) + "</div>");	
			
			out.println("<form method=GET action='controlerQUIZZ'>");
			out.println("<div class=\"radio\" id=\"radio\"><input type='radio' name='reponse' id='rd1' value='1' >Vrai"
				+ "<input type='radio' name='reponse' id='rd0' value='0' checked>Faux</div>");
			out.println("<div class=\"formulaire\"><button type='submit' id='buton' name='valider' ><p>Valider</p></button></div>");
			
			out.println("</form>"
				+ "<div id='countdown'>15 secondes restantes.</div>"
				+ "</div>"
				+ "</BODY>"
				+ "</HTML>");
		}else {
			out.println("<HTML>"
				+ "<HEAD>"
				+ "<meta charset='utf-8'>"
				+ "<link href=\"styles/style.css\" rel=\"stylesheet\" />"
				+ "</HEAD>"
				+ "<body class=\"accueil\">");
		
		out.println("<H1>QUIZZ ICROACK</H1>"
				+   "<div id=\"containerQuizz\">"
				+   "<p classe='resultatQuizz' id='resultatQuizz'>Vous avez " + quizz.getPoints() + " bonnes réponses. ");	
		if(quizz.finalResult()==true) {
			out.println("Vous avez gagné !</p>");
			session.setAttribute("resultatQuizz", "1");
		}else {
			out.println("Vous avez perdu...</p>");
			session.setAttribute("resultatQuizz", "0");
		}
        out.print("<form name = \"FormReturnHome\" action=\"ReturnHome\" method=GET>"
                +    "<input id=\"buton\" classe=\"return-home\"  type =\"submit\" value=\"Accueil\"  /></input>"
                +    "</form>"
                +    "</div>");
			out.println(""
					+ "</BODY>"
					+ "</HTML>");
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