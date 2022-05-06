package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modele.Dice;
/**
 * Servlet implementation class RollDice
 */
@WebServlet("/RollDice")
public class RollDice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public RollDice() {
    	super();
   	}
    
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	/*	//début de partie
		if (Dice.start==false) {
	   		 Dice.resultDice=Dice.random();
	   	     Dice.nbrlancer+=1;
	   	     Dice.start=true;
	   	  
	   	     posSquare+=Dice.resultDice;
	   	     this.getServletContext().getRequestDispatcher("/TestNewTimer.jsp").forward(request, response);

	   	}
	   	//pendant la partie
	   	else{
	   		Dice.resultDice=Dice.random();
	   		Dice.nbrlancer+=1;
	   		posSquare+=Dice.resultDice;
	   		
	   	}*/
    		
    	System.out.println("Ici");
	   	this.getServletContext().getRequestDispatcher("/RollDiceView.jsp").forward(request, response); 
	        
	        
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	}

	
	
	


