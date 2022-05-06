package controler;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Quizz;

/**
 * Servlet implementation class controlerQUIZZ
 */
@WebServlet("/controlerQUIZZ")
public class controlerQUIZZ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlerQUIZZ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Quizz quizz=(Quizz)session.getAttribute("questionsQuizz");
		String value=request.getParameter("reponse");
		quizz.setResult(quizz.getNumQuestion(), value);
		quizz.setPoints(quizz.getNumQuestion());
		quizz.setNumQuestion();
		getServletContext().getRequestDispatcher("/viewQuizz").forward(request, response);
	}
		
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
