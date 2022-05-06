class Frog {
    constructor(x, y, ctx) {
        this.x = x;
        this.y = y;
        this.ctx = ctx;
    }

    /*------------------------------ ACCESSEUR ----------------------------------------*/

    getX() {
        return this.x;
    }

    setX(x) {
        this.x = x;
    }

    getY() {
        return this.y;
    }

    setY(y) {
        this.y = y;
    }

    getCtx() {
        return this.ctx;
    }


    /*------------------------------ ACCESSEUR ----------------------------------------*/

    /*---------------------- DESSIN GRENOUILLE -----------------------*/

    draw() {

        let image = new Image();
        image.src = "../../img/froggy.gif";
        let ctx = this.getCtx();
        let posX = this.getX();
        let posY = this.getY();
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
        // console.log("Position X grenouille :" + this.getX());
        // console.log("Position Y grenouille :" + this.getY());
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




