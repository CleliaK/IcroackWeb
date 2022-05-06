<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lancer de dé</title>
</head>
<body>
<form name="parametre" action="" method="" >
<!-- bouton pour lancer la fonction et obtenir un lancer de dé  -->
<input type='button' name="dice" value='Dé' id='afficher' onclick='return maFonctionRandom();'/>
<!-- div dans laquelle on affiche l'image obtenue -->
<div id='dice'></div>
<div id='time'></div>
<input type="button" name="pause"  value="Stop" id="pause" onclick="arret();">
<input type="button" name="rep" value="rep" id="rep" onclick="reprendre();" hidden>
</form>

<script type='text/javascript'>
let nbrlancer = 0;
let start = false;
let resultDice=0;
var sec = 0;
var minu = 0;
var afficher;

function maFonctionRandom(){
	min=Math.ceil(1);// min du dé
	max=Math.floor(6);// max du dé
	resultDice=(Math.floor(Math.random() * (max - min + 1)) + min );
	nbrlancer+=1;
	document.getElementById("dice").innerHTML = "<img src='ressources/img/d"+ resultDice +".png'>"; //sélectionne l'image correspondant au chiffre du dé
	if (nbrlancer>0 && nbrlancer<2){
		start=true;
		chrono();
		return start;
	}
	
}

function arret() 
{	
        window.clearTimeout(reglage);
        document.parametre.dice.disabled = "disabled";
        document.parametre.pause.disabled = "";
        
        divInfo = document.getElementById('pause');
        divInfo2= document.getElementById('rep');
        
        if (divInfo.style.display == 'none')
        divInfo.style.display = 'block';
        else
        divInfo.style.display = 'none';
        if (divInfo2.style.display == 'block')
            divInfo2.style.display = 'none';
            else
            divInfo2.style.display = 'block';
        
}
function reprendre(){
	window.clearTimeout(reglage);
    document.parametre.dice.disabled = "";
    document.parametre.pause.disabled = "";
    chrono();
    divInfo2.style.display='none';
    divInfo.style.display='block'
    
   
    
        
}

function chrono() {

	
    sec++;

if (sec>59){
    sec=0;
    min++;

}
if (sec<10){
	afficher = minu +" " + "m" +" "+":"+ " " + "0"+ sec +" "+ "s";

	
} 

else{
	
	afficher = minu +" " + "m" +" "+":"+ " " + sec +" "+ "s";

}
   

    
document.getElementById("time").innerHTML = afficher;

reglage = window.setTimeout("chrono();",1000);
} 


</script>
</body>
</html>