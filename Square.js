class Square {
    constructor(id, x, y,ctx, type) {
        this.id = id;
        this.x = x;
        this.y = y;
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
   
    getY() {
        return this.y;
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
        image.src = "../../img/"+nom+".png";

        var ctx = this.getCtx();
        var posX = this.getX();
        var posY = this.getY();
        image.onload = function () {
            ctx.drawImage(image, posX, posY);
        }
    }
    // CREATION  DES CASES




}

