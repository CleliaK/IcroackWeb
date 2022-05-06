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
	<div id="miniGame">
		<div id="container">    
		
			<div id="containerGauche">
				<form name="formulaire" action="ReturnHome" method="GET">
		    		<div class=""><input id="butonReturn" class="returnHome"  type ="submit" value="Retour"></input></div>
		    	</form>
		    
		    	<div class="">
		    		<form name="btDice" action="RollDice">
		    			<input id="imgPlateau" class="" type="image" value="de" src="./ressources/buttonRoll.png"></input>
		    		</form></div>
		    	<div class=""><img id="imgPlateau" src="./ressources/LabelDiceRolled%5B1%5D.png" /></div>
		    </div>
		    <div id="containerCentre">
		   		<div id="toto"><canvas id="game" height = "562px" width=" 641px"></canvas></div>
		   	</div>
		
			<div id="containerDroite">
				<form name="formulaire" action="ReturnHome" method="GET">
		    		<div class=""></div>
		    	</form>
				<div class=""><img id="imgPlateau" src="./ressources/lastRoll.png" /></div>
				<div class=""><img id="imgPlateau" src="./ressources/LabelChrono%5B2%5D.png" /></div>
			</div>
			
		    <script src="./js/Frog.js"></script>
		    <script src="./js/Square.js"></script>
		    <script src="./js/Game.js"></script>
		 </div>   
	</div>
</body>
</html>