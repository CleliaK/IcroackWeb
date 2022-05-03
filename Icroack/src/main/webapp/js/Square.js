class Square {
    constructor(id, x, y, size, ctx, type) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.size = size;
        this.ctx = ctx;
        this.type = type;
    }


    /*
        TYPE 1 : CASE DEPART
        TYPE 2 : CASE NORMAL
        TYPE 3 : CASE BONUS
        TYPE 4 : CASE MALUS
        TYPE 5 : CASE MINI JEUX
        TYPE 6 : CASE ARRIVER
    */

    /*------------------------------ ACCESSEUR ----------------------------------------*/


    getId() {
        return this.id;
    }


    getX() {
        return this.x;
    }

    setX(x) {
        this.x = this.x + x;
    }

    getY() {
        return this.y;
    }

    setY(y) {
        this.y = this.y + y;
    }

    getSize() {
        return this.size;
    }

    getType() {
        return this.type;
    }

    getCtx() {
        return this.ctx
    }
    /*------------------------------ ACCESSEUR ----------------------------------------*/


    /*------------------------------ METHODE ----------------------------------------*/

    // CREATION DES CASES
    draw_square(nom) {

        var image = new Image();
        image.src = "./ressources/" + nom + ".png";

        var ctx = this.getCtx();
        var posX = this.getX();
        var posY = this.getY();
        image.onload = function () {
            ctx.drawImage(image, posX, posY);
        }
    }
    // CREATION  DES CASES


    // SI LE JOUEUR TOMBE SUR UNE CASE

    walk_square() {

        if (this.getType() == 1) { // SI LA CASE EST DE TYPE DEPART
            console.log("FROGGY SUR CASE NORMAL");
            // CODE POUR DEPART
        } else if (this.getType() == 2) { // SI LA CASE EST DE TYPE NORMAL
            console.log("FROGGY SUR CASE NORMAL");
            // CODE POUR NORMAL
        } else if (this.getType() == 3) { // SI LA CASE EST DE TYPE BONUS
            console.log("FROGGY SUR CASE BONUS");
            // CODE POUR BONUS
        } else if (this.getType() == 4) { // SI LA CASE EST DE TYPE MALUS
            console.log("FROGGY SUR CASE MALUS");
            // CODE POUR MALUS
        } else if (this.getType() == 5) { // SI LA CASE EST DE TYPE MINI JEU
            console.log("FROGGY SUR CASE MINI JEU");
            // CODE POUR MINI JEU
        } else if (this.getType() == 6) { // SI LA CASE EST DE TYPE FIN
            console.log("FROGGY SUR CASE FIN");
            // CODE POUR FIN 
        }
    }

    // SI LE JOUEUR TOMBE SUR UNE CASE


}

