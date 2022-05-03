class Frog {
    constructor(x, y, size, ctx) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.ctx = ctx;
    }

    /*------------------------------ ACCESSEUR ----------------------------------------*/

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

    getCtx() {
        return this.ctx;
    }


    /*------------------------------ ACCESSEUR ----------------------------------------*/

    /*---------------------- DESSIN GRENOUILLE -----------------------*/

    draw() {

        var image = new Image();
        image.src = "./ressources/froggy.gif";
        var ctx = this.getCtx();
        var posX = this.getX();
        var posY = this.getY();
        image.onload = function () {
            ctx.drawImage(image, posX, posY);
        }

    }
    /*---------------------- DESSIN GRENOUILLE -----------------------*/



    /*---------------------- DEPLACEMENT -----------------------*/

    move(x, y) {

        this.setX(x); // MODIFIE LA POSTION X DE LA GRENOUILLE
        this.setY(y); // MODIFIE LA POSTION Y DE LA GRENOUILLE
        this.clearCanvas(); // APPEL A LA METHODE 
    }
    /*---------------------- DEPLACEMENT -----------------------*/

    /*---------------- RAFRAICHIR CANVAS ----------------*/
    clearCanvas() {
        this.ctx.clearRect(0, 0, 800, 800); // REFRESH LE CANVAS
        game.draw_board(); // REDESSINE LES CASES
        this.draw(); // REDESSINNE LA GRENOUILLE
    }
    /*---------------- RAFRAICHIR CANVAS ----------------*/

    /*---------------------- DEPLACEMENT -----------------------*/

}




