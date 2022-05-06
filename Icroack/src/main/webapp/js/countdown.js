/**
 * COUNTDOWN POUR LE QUIZZ (15 secondes)
 */
 

var timeleft = 14;
var timer = setInterval(function(){
  if(timeleft <= 0){
    clearInterval(timer);
    document.getElementById("countdown").innerHTML = "Temps écoulé... Question suivante !";
    document.getElementById("rd0").value='timeout';
	document.getElementById("rd1").value='timeout';
	var timeleftnext = 1;
	var next = setInterval(function(){
  		if(timeleftnext <= 0){
    		clearInterval(next);
    		document.forms[0].submit();
  		} 
  		timeleftnext -= 1;
		}, 1000)
  } else {
    document.getElementById("countdown").innerHTML = timeleft + " secondes restantes.";
  }
  timeleft -= 1;
}, 1000)