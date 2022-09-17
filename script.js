let ball = function(){
    this.x = 0;
    this.y = 0;
    this.speedy = random(-5, 5);
    this.speedx = random(-5, 5);


    this.update = function(){
        this.x += this.speedx;
        this.y += this.speedy;
        if (this.y > Math.abs(window.innerHeight/2)){
            this.speedy = -this.speedy;
        }
        if (this.x > Math.abs(window.innerWidth/2)){
            this.speedx = -this.speedx;
        }
    }

    this.draw = function(){
        fill(255, 0, 0);
        ellipse(this.x, this.y, 20, 20);
    }
}

function setup(){
    createCanvas(windowWidth, windowHeight);
    noStroke();
    background(0);
    ball1 = new ball();
    ball1.draw()
}