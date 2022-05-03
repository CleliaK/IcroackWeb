package view;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TicTacToeServlet
 */
@WebServlet("/tictactoe")
public class TicTacToeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicTacToeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        PrintWriter out=response.getWriter();
        out.print("<html>\r\n"
                + "  <head>\r\n"
                + "    <link href=\"styles/style.css\" rel=\"stylesheet\" />\r\n"
                + "  </head>\r\n"
                + "  <body class=\"accueil\">\r\n"
                + "    <section>\r\n"
                + "		<div class=\"titre\"> <img class=\"imgTitle\" id=\"imgSubTitle\" src=\"ressources/morpionTitle.png\""
        		+ " 	alt=\"Titre du jeu\"></div>"
                + "      <div class=\"game--container\">\r\n"
                + "        <div id=\"0\" data-cell-index=\"0\" class=\"cell\"></div>\r\n"
                + "        <div id=\"1\" data-cell-index=\"1\" class=\"cell\"></div>\r\n"
                + "        <div id=\"2\" data-cell-index=\"2\" class=\"cell\"></div>\r\n"
                + "        <div id=\"3\" data-cell-index=\"3\" class=\"cell\"></div>\r\n"
                + "        <div id=\"4\" data-cell-index=\"4\" class=\"cell\"></div>\r\n"
                + "        <div id=\"5\" data-cell-index=\"5\" class=\"cell\"></div>\r\n"
                + "        <div id=\"6\" data-cell-index=\"6\" class=\"cell\"></div>\r\n"
                + "        <div id=\"7\" data-cell-index=\"7\" class=\"cell\"></div>\r\n"
                + "        <div id=\"8\" data-cell-index=\"8\" class=\"cell\"></div>\r\n"
                + "      </div>\r\n"
                + "      <h2 class=\"game--status\"></h2>\r\n"
                + "      <button id=\"buton\" class=\"game--restart\">Restart Game</button>\r\n"
                + "    </section>\r\n"
                + "    <script src=\"./js/TTT.js\"></script>\r\n");
        out.print("<center><form name = \"FormReturnHome\" action=\"ReturnHome\" method=GET>"
                +    "<input id=\"buton\" classe=\"return-home\"  type =\"submit\" value=\"Accueil\"  /></input>"
                +    "</form>");
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