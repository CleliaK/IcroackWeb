<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lancer de dé</title>
<script type='text/javascript'>
function maFonctionRandom(){
	min=Math.ceil(1);
	max=Math.floor(6);
	 document.getElementById("dice").innerHTML = "<img src='ressources/d"+(Math.floor(Math.random() * (max - min + 1)) + min )+".png'>"
}

</script>
</head>
<body>
<form>
<input type='button' value='Dé' id='afficher' onclick='return maFonctionRandom();'/>
<div id='dice'></div>
</form>
</body>
</html>