class Hero {
    constructor(image, top, left, size) {
        this.image = image;
        this.top = top;
        this.left = left;
        this.size = size;
    }
    getHeroElement(){
        return '<img width="'+ this.size + '"' +
            ' height="'+ this.size + '"' +
            ' src="' + this.image +'"' +
            ' style="top: '+this.top+'px; left:'+this.left+'px; position:absolute;" />';
    }
    moveRight(){
        this.left += 30;
    }
    // moveLeft(){
    //     this.left -= 30;
    // }
    // moveUp(){
    //     this.top -= 30;
    // }
    moveDown(){
        this.top += 30;
    }
}
let repeater = new Hero('repeater-plant.jpg', 20, 20, 200);
let pean = new Hero('pean.png', 65, 220, 35);

function start(){
    if(pean.left < window.innerWidth - pean.size - 80) {
        pean.moveRight();
    } else if (pean.top < window.innerHeight - pean.size - 80) {
        pean.moveDown();
    }
    document.getElementById('repeater').innerHTML = repeater.getHeroElement();
    document.getElementById('pean').innerHTML = pean.getHeroElement();
    setTimeout(start, 500)
}

start();