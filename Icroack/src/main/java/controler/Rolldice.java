package controler;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
/**
 * Servlet implementation class rolldice
 */
@WebServlet("/Rolldice")
public class Rolldice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
    /**
     * Default constructor. 
     */
    public Rolldice() {
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	        response.getWriter().append("Served at: ").append(request.getContextPath());
	        this.getServletContext().getRequestDispatcher("/RolldiceView.jsp").forward(request, response);

	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	


