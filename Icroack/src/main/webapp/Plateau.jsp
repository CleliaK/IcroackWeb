<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plateau</title>
    <link href="styles/style.css" rel="stylesheet">
    

</head>
<body class="board">
     <form name="formulaire" action="ReturnHome" method="GET">
     <div class=""><input id="butonReturn" class="returnHome"  type ="submit" value="Retour"></input></div></form>
    <div id="canvas"><canvas id="game" height = "700px" width=" 800px"></canvas></div>
    
   
    <div class="formulaire"><input type='button' value='Dé' id='buton' onclick='return maFonctionRandom();'/></div>

     
    <script src="./js/Frog.js"></script>
    <script src="./js/Square.js"></script>
    <script src="./js/Game.js"></script>
</body>
</html>