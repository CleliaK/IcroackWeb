class Game {
    
    constructor(){
        this.counter = 0; // compteur pour le deplacement
        this.game = document.getElementById('game'); // Je recupere le canva
        this.ctx = this.game.getContext('2d'); // getContext me permet de dessiner
        this.frog = new Frog(0, 0,this.getCtx()); // instance du joueur
        this.array_square = new Array(); // tableau des cases
        this.dice = new Dice(); // le dé
    }


    /*-------------------- ACCESSEUR ------------------------*/

    getCtx() {
        return this.ctx;
    }

    getFrog() {
        return this.frog;
    }
    getArraySquare(){
        return this.array_square;
    }
    
    getSquare(de){

       this.counter = this.counter + de; 
       var square = this.getArraySquare()[this.counter]; // JE RECUPERE UNE CASE
    
       switch(this.counter){
        case 2:
            console.log("case bonus");
            console.log("avance de 3 cases");
            square = this.getArraySquare()[this.counter + 3];
            this.counter = this.counter + 3;
            break;
        
        case 3:
            console.log("case malus");
            square = this.getArraySquare()[this.counter - 3];
            console.log("recule de 3 cases");
            this.counter = this.counter - 3;
            break;

        // case 5:
        //     console.log("déclenchement mini-jeu");    
        //   // lancement mini jeux        
        //     break;

        case 7:
            console.log("case malus");
            console.log("recule de 3 cases");
            square = this.getArraySquare()[this.counter - 3];
            this.counter = this.counter - 3;
            break;

        case 9:
            console.log("case bonus");
            console.log("avance de 3 cases");
            square = this.getArraySquare()[this.counter + 3];
            this.counter = this.counter + 3;
            break;

        case 11:
            console.log("case malus");
            console.log("recule de 3 cases");
            square = this.getArraySquare()[this.counter - 3];
            this.counter = this.counter - 3;
            break;

        // case 12:
           
        //     console.log("déclenchement mini-jeu"); 
        //     // lancement mini jeux 
        //     break;

        case 13:
            console.log("case bonus");
            console.log("avance de 3 cases");
            square = this.getArraySquare()[this.counter + 3];
            this.counter = this.counter + 3;
            break;

        case 15:
            console.log("case malus");
            console.log("recule de 3 cases");
            square = this.getArraySquare()[this.counter - 3];
            break;
            
        case 17:
            console.log("case bonus");
            console.log("avance de 3 cases");
            square = this.getArraySquare()[this.counter + 3];
            this.counter = this.counter + 3;
            break;
    
        // case 19:
        //     console.log("déclenchement mini-jeu"); 
        //     // lancement mini jeux 
        //     break;

        // case 21:
        //     console.log("déclenchement mini-jeu"); 
        //     // lancement mini jeux 
        //     break;

        case 23:
            console.log("case malus");
            console.log("recule de 3 cases");
            square = this.getArraySquare()[this.counter - 3];
            this.counter = this.counter - 3;
            break;

        case 24:
            console.log("case fini");
            console.log("partie terminé");
            break;
    }

        if(square.getType() == 5){
            alert("lancement du mini jeu");
        }
        return square;
    }


    // AJOUT ITEM DANS LE TABLEAU
    ajoutItemsArraySquare(item){
        this.getArraySquare().push(item);
    }
    // AJOUT ITEM DANS LE TABLEAU

    getDice(){
        return this.dice;
    }

    /*-------------------- ACCESSEUR ------------------------*/

    /*-------------------- METHODE ------------------------*/

    start() {
        this.draw_board(); // DESSINE LE PLATEAU
        this.frog.draw(); // DESSINE LA GRENOUILLE
    }

    draw_board() {
        let cpt = 0; // COMPTEUR DU WHILE

        while (cpt <= 25) { // A CHAQUE TOUR DE BOUCLE JE CREE UNE INSTANCE D'UNE CASE
        
            switch (cpt) {

                case 0:
                    var square_1 = new Square(1, 0, 0,  this.getCtx(), 1);
                    this.ajoutItemsArraySquare(square_1);
                    square_1.draw_square("depart");
                    break;
                case 1:
                    var square_2 = new Square(2, 80, 0,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_2);
                    square_2.draw_square("chemin");
                    break;
                case 2:
                    var square_3 = new Square(3, 160, 0,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_3);
                    square_3.draw_square("bonus");
                    break;
                case 3:
                    var square_4 = new Square(4, 240, 0,  this.getCtx(), 4);
                    this.ajoutItemsArraySquare(square_4);
                    square_4.draw_square("malus");
                    break;
                case 4:
                    var square_5 = new Square(5, 320, 0,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_5);
                    square_5.draw_square("chemin");
                    break;
                case 5:
                    var square_6 = new Square(6, 320, 80,  this.getCtx(), 5);
                    this.ajoutItemsArraySquare(square_6);
                    square_6.draw_square("mini-jeu");
                    break;
                case 6:
                    var square_7 = new Square(7, 320, 160,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_7);
                    square_7.draw_square("chemin");
                    break;
                case 7:
                    var square_8 = new Square(8, 320, 240,  this.getCtx(), 4);
                    this.ajoutItemsArraySquare(square_8);
                    square_8.draw_square("malus");
                    break;
                case 8:
                    var square_9 = new Square(9, 240, 240,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_9);
                    square_9.draw_square("chemin");
                    break;
                case 9:
                    var square_10 = new Square(10, 160, 240,  this.getCtx(), 3);
                    this.ajoutItemsArraySquare(square_10);
                    square_10.draw_square("bonus");
                    break;
                case 10:
                    var square_11 = new Square(11, 80, 240,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_11);
                    square_11.draw_square("chemin");
                    break;
                case 11:
                    var square_12 = new Square(12, 0, 240,  this.getCtx(), 4);
                    this.ajoutItemsArraySquare(square_12);
                    square_12.draw_square("malus");
                    break;
                case 12:
                    var square_13 = new Square(13, 0, 320,  this.getCtx(), 5);
                    this.ajoutItemsArraySquare(square_13);
                    square_13.draw_square("mini-jeu");
                    break;
                case 13:
                    var square_14 = new Square(14, 0, 400,  this.getCtx(), 3);
                    this.ajoutItemsArraySquare(square_14);
                    square_14.draw_square("bonus");
                    break;
                case 14:
                    var square_15 = new Square(15, 0, 480,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_15);
                    square_15.draw_square("chemin");
                    break;
                case 15:
                    var square_16 = new Square(16, 80, 480,  this.getCtx(), 4);
                    this.ajoutItemsArraySquare(square_16);
                    square_16.draw_square("malus");
                    break;
                case 16:
                    var square_17 = new Square(17, 160, 480,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_17);
                    square_17.draw_square("chemin");
                    break;
                case 17:
                    var square_18 = new Square(18, 240, 480,  this.getCtx(), 3);
                    this.ajoutItemsArraySquare(square_18);
                    square_18.draw_square("bonus");
                    break;
                case 18:
                    var square_19 = new Square(19, 320, 480,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_19);
                    square_19.draw_square("chemin");
                    break;
                case 19:
                    var square_20 = new Square(20, 400, 480,  this.getCtx(), 5);
                    this.ajoutItemsArraySquare(square_20);
                    square_20.draw_square("mini-jeu");
                    break;
                case 20:
                    var square_21 = new Square(21, 480, 480,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_21);
                    square_21.draw_square("chemin");
                    break;
                case 21:
                    var square_22 = new Square(22, 480, 400,  this.getCtx(), 5);
                    this.ajoutItemsArraySquare(square_22);
                    square_22.draw_square("mini-jeu");
                    break;
                case 22:
                    var square_23 = new Square(23, 480, 320,  this.getCtx(), 2);
                    this.ajoutItemsArraySquare(square_23);
                    square_23.draw_square("chemin");
                    break;
                case 23:
                    var square_24 = new Square(24, 480, 240,  this.getCtx(), 4);
                    this.ajoutItemsArraySquare(square_24);
                    square_24.draw_square("malus");
                    break;
                case 24:
                    var square_25 = new Square(25, 560, 240,  this.getCtx(), 6);
                    this.ajoutItemsArraySquare(square_25);
                    square_25.draw_square("fin");
                    break;
            }

            cpt++
        }
        
        // DECLENCHEMENT SI LE JOUEUR TOMBE SUR UNE CASE MINI-JEU

        // DECLENCHEMENT SI LE JOUEUR TOMBE SUR UNE CASE MINI-JEU
    }

};


function de() {
    
    var dice = game.getDice();
    dice.random();
    alert("dé :"+ dice.getResultDice());
    var square = game.getSquare(dice.getResultDice());

    // PARCOURIR TABLEAU DES CASES ET RECUPERE LA POSITION AFIN D'ASSIGNER A LA POSTION DE LA GRENOUILLE 
    // console.log(square.getX());
    // console.log(square.getY());
    
    game.getFrog().move(square.getX(), square.getY());
    // ACTUALISER POSITION GRENOUILLE   
}

/*-------------------- METHODE ------------------------*/



let game = new Game();
game.start();




