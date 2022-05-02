<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    PrintWriter write = response.getWriter();

    write.print("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>Page de création de compte</title>\n" +
            "    <link href=\"styles/style.css\" rel=\"stylesheet\">" +
            "\n" +
            "\n" +
            "\n" +
            "</head>\n" +
            "    <body class=\"accueil\">\n" +
                    	"<div class=\"titre\"> <img class=\"imgTitle\" id=\"imgSubTitle\" src=\"ressources/connectTitle.png\""
    				+   " alt=\"Titre du jeu\"></div> "+
            "        <form action=\"controleraccountcreation-servlet\" method=\"POST\">\n" +
            "            <div class=\"formulaire\"> Votre login:</div>" +
            "            <div class=\"formulaire\"><input id=\"texte\" classe=\"\"type=\"text\" name=\"login\"><div>" +
            "            <div class=\"formulaire\"> Mot de passe:</label></div>" +
            "            <div class=\"formulaire\"><input id=\"texte\" classe=\"\" type=\"password\" name=\"mdp\"></div>"+
            "            <div class=\"formulaire\">Saisissez à nouveau votre mot de passe:</label></div>" +
            "            <div class=\"formulaire\"><input id=\"texte\" classe=\"\" type=\"password\" name=\"re_mdp\"></div>" +
            "            <div class=\"formulaire\"><input id=\"buton\" classe=\"buton\" type=\"submit\" value=\"Création\"></div>" +
            "        	</form>" +
            "			<div class=\"formulaire\"><form action=\"LoginIcroack\" method=\"POST\"></div>"+
            "			<div class=\"formulaire\"><input id=\"buton\" classe=\"buton\" type=\"submit\" value = \"Retour Page D'accueil\" /></input></div>"+
            "			</form>" +
            "     \n" +
            "\n" +
            "\n" +
            "\n" +
            "\n");
    if (request.getAttribute("champs")=="vide") {
        write.print("  <span class=\"refuse\"> Veuillez remplir les champs </span> ");
    } else if (request.getAttribute("login") == "trouver") {
        write.print("  <span class=\"refuse\"> Ce pseudo existe déjà, merci d'en utiliser un autre </span> ");
    }else if (request.getAttribute("mdp") == "non identique"){
        write.print(" <span class=\"refuse\"> Les deux mots de passe ne sont pas les mêmes, merci de renseigner des mots de passe identiques </span>");
    }else if (request.getAttribute("cree") == "ok"){
        write.print(" <span class=\"ok\"> Création de compte réussie</span>");
    }
    write.println(
            "    </body>\n" +
            "</html>");

    %>

