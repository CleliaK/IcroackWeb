package controler;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import connection.DAOIcare;

@WebServlet("/controleraccountcreation-servlet")
public class ControlerAccountCreation extends HttpServlet {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");


        String login = request.getParameter("login"); // login
        String mdp = request.getParameter("mdp"); // mot de passe
        String re_mdp = request.getParameter("re_mdp"); // mot de passe verif


        if(!login.isEmpty() && !mdp.isEmpty() && !re_mdp.isEmpty()){ // SI les variables ne sont pas vide
            try {
                DAOIcare DAOicare = new DAOIcare("com.mysql.cj.jdbc.Driver", "icare","Icare","ctj*UTD5gfd.tgc-apw");

                /*------------------------ REQUETE PREPARER --------------------------*/

                // query pour vérifier si un pseudo est déja existant
                String strCheck = "SELECT login FROM player WHERE login = ?";
                // query pour insérer les nouvelle données à la BDD
                String strInsert = "INSERT INTO player(login,password) VALUES(? , ? );";

                // Preparer la requête
                PreparedStatement myQuery_select = DAOicare.getConn().prepareStatement(strCheck);
                myQuery_select.setString(1, login);
                ResultSet rsUsers = myQuery_select.executeQuery();

                // Preparer la requête
                PreparedStatement myQuery_insert = DAOicare.getConn().prepareStatement(strInsert);
                myQuery_insert.setString(1, login);
                myQuery_insert.setString(2, mdp);

                /*------------------------ REQUETE PREPARER --------------------------*/


                while (rsUsers.next()) { // recherche dans les users

                    if (rsUsers.getString("login").equals(login)) { //si on trouve un login déjà existant
                        request.setAttribute("login","trouver");
                        getServletContext().getRequestDispatcher("/AccountCreation.jsp").forward(request, response);
                        DAOicare.getConn().close();
                    }
                }
                if (mdp.equals(re_mdp)) { // si les deux password sont identiques, alors insertion à la BDD
                    try {
                        request.setAttribute("cree","ok");
                        myQuery_insert.executeUpdate(); // EXECUTE LA REQUETE PREPARER
                        getServletContext().getRequestDispatcher("/AccountCreation.jsp").forward(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    DAOicare.getConn().close(); // fermeture de la connexion

                } else {
                    request.setAttribute("mdp","non identique");
                    getServletContext().getRequestDispatcher("/AccountCreation.jsp").forward(request, response);

                    //   JOptionPane.showMessageDialog(null, "Création du compte validée, Bon jeu!");
                }

            } catch (SQLException | ServletException ex) {
                throw new RuntimeException(ex);
            }

        }else{ // ALORS Remplire les champs

            request.setAttribute("champs","vide");
            getServletContext().getRequestDispatcher("/AccountCreation.jsp").forward(request, response);
        }
    }

    public void destroy() {}
}