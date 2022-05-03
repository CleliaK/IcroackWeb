<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript">// initialisation des variables
    /* jshint expr: true */
    var sec = 0;
    var min = 0;
    var afficher;


    // affichage du compteur � 0
    document.getElementById('time').innerHTML = "0" + min + "0"+ sec;



    function chrono() {

            sec++;
        
        if (sec>59){
            sec=0;
            min++;
        
        }
        if (sec<10){
        	afficher = min +" " + "m" +" "+":"+ " " + "0"+ sec +" "+ "s";

        	
        } 
        
        else{
        	
        	afficher = min +" " + "m" +" "+":"+ " " + sec +" "+ "s";

        }
           
        
            
        document.getElementById("time").innerHTML = afficher;
        
        reglage = window.setTimeout("chrono();",1000);
    } 


    function debut()  //== Activation et d�sactivation des boutons
        {
                document.parametre.lance.disabled = "disabled";
                document.parametre.pause.disabled = "";
                document.parametre.zero = "";
        }
    function arret() 
        {	
                window.clearTimeout(reglage);
                document.parametre.lance.disabled = "";
                document.parametre.pause.disabled = "disabled";
                document.parametre.zero.disabled = "";
        }
    
    function raz() //====pour remettre à zéro
    { 
    		document.parametre.zero.disabled = "disabled";
            sec = 0;
            min = 0;
            afficher = min +" " + "m" +" "+":"+ " " + sec +" "+ "s";
            document.getElementById("time").innerHTML = afficher;
    }
        </script> 
    <title>Timer</title>
    <meta charset="UTF-8">
</head>
<body>
    <div id="time"></div>


	<form name="parametre" action="" method="">
        <input type="button" name="lance"  value="Demarrer" onclick="chrono();debut();">
        <input type="button" name="pause"  value="Stop" onclick="arret();" disabled="disabled">
        <input type="button" name="zero"  value="Effacer" onclick="arret();raz();">
    </form>
</body>
</html>