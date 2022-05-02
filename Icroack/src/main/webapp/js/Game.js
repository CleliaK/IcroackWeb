class Game {

    SQUARE_SIZE;
    ctx;
    game;
    frog;

    constructor() {
        this.SQUARE_SIZE = 100; // TAILLE CASE
        this.game = document.getElementById('game'); // Je recupere le canva
        this.ctx = this.game.getContext('2d'); // getContext me permet de dessiner
        this.frog = new Frog(0, 0, this.getSquareSize(), this.getCtx());
    }


    /*-------------------- ACCESSEUR ------------------------*/

    getSquareSize() {
        return this.SQUARE_SIZE;
    }

    getCtx() {
        return this.ctx;
    }

    getFrog() {
        return this.frog;
    }

    /*-------------------- ACCESSEUR ------------------------*/

    /*-------------------- METHODE ------------------------*/

    start() {
        this.draw_board(); // DESSINE LE PLATEAU
        this.frog.draw();
    }

    draw_board() {
        var cpt = 0; // COMPTEUR DU WHILE

        while (cpt < 25) { // A CHAQUE TOUR DE BOUCLE JE CREE UNE INSTANCE D'UNE CASE

            switch (cpt) {
                case 0:
                    var square_1 = new Square(1, 0, 0, this.getSquareSize(), this.getCtx(), 1);
                    square_1.draw_square("depart");
                    break;
                case 1:
                    var square_2 = new Square(2, 100, 0, this.getSquareSize(), this.getCtx(), 2);
                    square_2.draw_square("chemin");
                    break;
                case 2:
                    var square_3 = new Square(3, 200, 0, this.getSquareSize(), this.getCtx(), 2);
                    square_3.draw_square("bonus");
                    break;
                case 3:
                    var square_4 = new Square(4, 300, 0, this.getSquareSize(), this.getCtx(), 4);
                    square_4.draw_square("malus");
                    break;
                case 4:
                    var square_5 = new Square(5, 400, 0, this.getSquareSize(), this.getCtx(), 2);
                    square_5.draw_square("chemin");
                    break;
                case 5:
                    var square_6 = new Square(6, 400, 100, this.getSquareSize(), this.getCtx(), 5);
                    square_6.draw_square("mini-jeu");
                    break;
                case 6:
                    var square_7 = new Square(7, 400, 200, this.getSquareSize(), this.getCtx(), 2);
                    square_7.draw_square("chemin");
                    break;
                case 7:
                    var square_8 = new Square(8, 400, 300, this.getSquareSize(), this.getCtx(), 4);
                    square_8.draw_square("malus");
                    break;
                case 8:
                    var square_9 = new Square(9, 300, 300, this.getSquareSize(), this.getCtx(), 2);
                    square_9.draw_square("chemin");
                    break;
                case 9:
                    var square_10 = new Square(10, 200, 300, this.getSquareSize(), this.getCtx(), 3);
                    square_10.draw_square("bonus");
                    break;
                case 10:
                    var square_11 = new Square(11, 100, 300, this.getSquareSize(), this.getCtx(), 2);
                    square_11.draw_square("chemin");
                    break;
                case 11:
                    var square_12 = new Square(12, 0, 300, this.getSquareSize(), this.getCtx(), 4);
                    square_12.draw_square("malus");
                    break;
                case 12:
                    var square_13 = new Square(13, 0, 400, this.getSquareSize(), this.getCtx(), 5);
                    square_13.draw_square("mini-jeu");
                    break;
                case 13:
                    var square_14 = new Square(14, 0, 500, this.getSquareSize(), this.getCtx(), 3);
                    square_14.draw_square("bonus");
                    break;
                case 14:
                    var square_15 = new Square(15, 0, 600, this.getSquareSize(), this.getCtx(), 2);
                    square_15.draw_square("chemin");
                    break;
                case 15:
                    var square_16 = new Square(16, 100, 600, this.getSquareSize(), this.getCtx(), 4);
                    square_16.draw_square("malus");
                    break;
                case 16:
                    var square_17 = new Square(17, 200, 600, this.getSquareSize(), this.getCtx(), 2);
                    square_17.draw_square("chemin");
                    break;
                case 17:
                    var square_18 = new Square(18, 300, 600, this.getSquareSize(), this.getCtx(), 3);
                    square_18.draw_square("bonus");
                    break;
                case 18:
                    var square_19 = new Square(19, 400, 600, this.getSquareSize(), this.getCtx(), 2);
                    square_19.draw_square("chemin");
                    break;
                case 19:
                    var square_20 = new Square(20, 500, 600, this.getSquareSize(), this.getCtx(), 5);
                    square_20.draw_square("mini-jeu");
                    break;
                case 20:
                    var square_21 = new Square(21, 600, 600, this.getSquareSize(), this.getCtx(), 2);
                    square_21.draw_square("chemin");
                    break;
                case 21:
                    var square_22 = new Square(22, 600, 500, this.getSquareSize(), this.getCtx(), 5);
                    square_22.draw_square("mini-jeu");
                    break;
                case 22:
                    var square_23 = new Square(23, 600, 400, this.getSquareSize(), this.getCtx(), 2);
                    square_23.draw_square("chemin");
                    break;
                case 23:
                    var square_24 = new Square(24, 600, 300, this.getSquareSize(), this.getCtx(), 4);
                    square_24.draw_square("malus");
                    break;
                case 24:
                    var square_25 = new Square(25, 700, 300, this.getSquareSize(), this.getCtx(), 6);
                    square_25.draw_square("fin");
                    break;
            }

            cpt++
        }
    }



};


function de() {
    alert("lancement du dé");
    // OBJET Dé QUI RETOURNE SA VALEUR

    // APPEL A UNE CASE VIA (ID = VALEUR)

    game.getFrog().move(100, 0);

    // ACTUALISER POSITION GRENOUILLE   
}
/*-------------------- METHODE ------------------------*/


let game = new Game();
game.start();




