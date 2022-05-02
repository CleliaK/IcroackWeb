package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.DAOIcare;


/**
 * Servlet implementation class ControlerConnexion
 */
@WebServlet("/ControllerConnexion")
public class ControlerConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlerConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginCheck = (String)request.getParameter("login");	
		String userPwdCheck = (String)request.getParameter("userPwd");

		
		
		if(loginCheck.equals("") || userPwdCheck.equals(""))
		{
			request.setAttribute("connection", "vide");
			getServletContext().getRequestDispatcher("/LoginIcroack").forward(request, response);
			System.out.println("Veuillez completer tous les champs svp !");

		}
		else
		{
			
			try {
				//Ouvre la connexion
				DAOIcare dao = new DAOIcare("com.mysql.cj.jdbc.Driver", "icare","Icare","ctj*UTD5gfd.tgc-apw");
				boolean flag = false;
				
				//Statement stmt = dao.getConn().createStatement();
				System.out.println("loginCheck :" + loginCheck + ", password : " + userPwdCheck);
				String query ="select * from player where login='"+loginCheck+"'and password='"+userPwdCheck+"';";
				//Statement stmt=dao.getConn().createStatement();
				ResultSet rs1 = dao.getStatement().executeQuery(query);
				HttpSession session = request.getSession();
				 while(rs1.next()) 
				 {
						//Creation de la session utilisateur :
					
						session.setAttribute("playerName", rs1.getString("login"));
						session.setAttribute("idPlayer", rs1.getString("id_player"));
						session.setAttribute("isAdmin","0");
						if(rs1.getString("isAdmin").equals("1")) 
						{
							session.setAttribute("isAdmin","1");
						}
				 System.out.println("Connexion reussie");
				 flag = true;
				 getServletContext().getRequestDispatcher("/AccueilIcroack").forward(request, response);
				 }
				 
					if(flag==false) {
						request.setAttribute("connection", "false");
						getServletContext().getRequestDispatcher("/LoginIcroack").forward(request,response);
						
					}
			}
			catch (SQLException e) {
				
				System.out.println("Connexion echouee");
				getServletContext().getRequestDispatcher("/LoginIcroack").forward(request, response);
				e.printStackTrace();
			}
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
