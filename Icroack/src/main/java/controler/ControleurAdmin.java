package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DAOIcare;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class ControleurAdmin
 */
@WebServlet("/ControleurAdmin")
public class ControleurAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControleurAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><head></head><body>");
		String pseudoCheck = (String)request.getParameter("pseudo");	
		String pseudoConfirm = (String)request.getParameter("pseudoconfirme");	
		
		if(pseudoCheck.equals("") || pseudoConfirm.equals(""))
		{
			request.setAttribute("connection", "vide");
			getServletContext().getRequestDispatcher("/ViewAdmin").forward(request,response);
		}
		else
		{
			if (pseudoCheck.equals(pseudoConfirm)) {
				DAOIcare dao = new DAOIcare("com.mysql.cj.jdbc.Driver", "icare","Icare","ctj*UTD5gfd.tgc-apw");
				boolean flag = false;
			
				
					try {
						Statement verifPseudo = dao.getConn().createStatement();
						String verifBDD = "SELECT login FROM player";
						ResultSet rsUsers =verifPseudo.executeQuery(verifBDD);
						while (rsUsers.next()) {
							if (rsUsers.getString("login").equals(pseudoCheck))
							{
								Statement deletePseudo = dao.getConn().createStatement();
								String sql = "DELETE FROM player WHERE login='" +pseudoConfirm + "';";
								deletePseudo.executeUpdate(sql);
								flag = true;
								request.setAttribute("connection", "true");
								getServletContext().getRequestDispatcher("/ViewAdmin").forward(request,response);
														
							}
						}
						if(flag==false) {
							request.setAttribute("connection", "false");
							getServletContext().getRequestDispatcher("/ViewAdmin").forward(request,response);
							
						}
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
			else {
				request.setAttribute("connection", "nonequals");
				getServletContext().getRequestDispatcher("/ViewAdmin").forward(request,response);
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
