class Dice{
    constructor(){
         this.start = false;
         this.nbrLancer = 0;
         this.resultDice = 0;
    }



     /*-------------------- ACCESSEUR ------------------------*/

    getStart(){
        return this.start;
    }

    getNbrLancer(){
        return this.nbrLancer;
    }

    getResultDice(){
        return this.resultDice;
    }

      /*-------------------- ACCESSEUR ------------------------*/



       /*-------------------- METHODE ------------------------*/

    random(){
        this.resultDice = parseInt((Math.random() * 6 ) + 1);
    }

        /*-------------------- METHODE ------------------------*/
}