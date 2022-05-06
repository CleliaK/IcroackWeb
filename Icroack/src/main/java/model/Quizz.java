package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DAOIcare;

public class Quizz {
	String[][] tabQuestions;
	String[][] tabAllQuestions;
	int points;
	int rng;
	int[] nb;
	int numQuestion;
	public Quizz() {
		points=0;
		numQuestion=0;
		tabQuestions=new String[5][3];
		tabAllQuestions=new String[65][2];
		try {
		DAOIcare dao=new DAOIcare("com.mysql.cj.jdbc.Driver", "icare","Icare","ctj*UTD5gfd.tgc-apw");	//connexion a la base de données
		String query ="select question,quizzAnswers from quizz";	//Requete à la base de données
		ResultSet sr1=dao.getStatement().executeQuery(query);
	
		int k=0;
		while(sr1.next()) {
			tabAllQuestions[k][0]=sr1.getString("question"); //Récupérations de la questions
			tabAllQuestions[k][1]=sr1.getString("quizzAnswers"); //Récupérations de la réponse
			k++;
		}
	
		//Vérification des doublons
		int[] nb=new int[5];
		for(int i=0;i<5;i++){
        rng=(int)(Math.random()*65);
        nb[i]=rng;
		}
		while(nb[1]==nb[0] || nb[1]==nb[2] || nb[1]==nb[3] || nb[1]==nb[4]){
			rng=(int)(Math.random()*65);
			nb[1]=rng;
		}
		while(nb[2]==nb[0] || nb[2]==nb[1] || nb[2]==nb[3] || nb[2]==nb[4]){
        	rng=(int)(Math.random()*65);
        	nb[2]=rng;
		}
		while(nb[3]==nb[0] || nb[3]==nb[1] || nb[3]==nb[2] || nb[3]==nb[4]){
			rng=(int)(Math.random()*65);
			nb[3]=rng;
		}
		while(nb[4]==nb[0] || nb[4]==nb[1] || nb[4]==nb[2] || nb[4]==nb[3]){
			rng=(int)(Math.random()*65);
			nb[4]=rng;
		}
		for(int j=0;j<5;j++) {
			tabQuestions[j][0]=tabAllQuestions[nb[j]][0];
			tabQuestions[j][1]=tabAllQuestions[nb[j]][1];
		}	
        //String[][] tab=(String[][])session.getAttribute("questionsQuizz");
		dao.closeConnection();		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getNumQuestion() {
		return this.numQuestion;
	}
	
	public void setNumQuestion() {
		this.numQuestion++;
	}
	
	public String[][] getTabQuestions() {
		return this.tabQuestions;
	}
	
	public String getSpecificQuestion(int r,int c){
		return this.tabQuestions[r][c];
	}
	
	public void setResult(int index, String result) {
		this.tabQuestions[index][2]=result;
	}
	
	public void setPoints(int index) {
		if(this.tabQuestions[index][1].equals(this.tabQuestions[index][2])) {
			this.points+=1;
		}
		
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public String getAnswer(int index) {
		return tabQuestions[index][1];
	}
	
	public boolean finalResult() {
		boolean isVictory=false;
		if(this.points>=3) {
			isVictory=true;
		}
		return isVictory;
	}
}