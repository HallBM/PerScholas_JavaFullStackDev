console.log("Hello World");

function scopeTest() {
    var y = 44;

    console.log(x);
}

const x = 33;
scopeTest();


class Animal {
    constructor(){
        this.two = "NO";
    }
}

class Dog extends Animal {
    constructor() {
        super();
        this.one = "yes";
        this.noise = "bark";
    }

    makeNoise() {
      return this.noise;
    }
}

class Wolf extends Dog {
    constructor() {
        super();
        this.noise = "growl";
    }
}

var result = new Wolf();
console.log(result.makeNoise());
console.log(result);

const  [a, b]  =  [1,2,3,4];
console.log(b); 


function count(...food) {
    console.log(food.length);
}

count("Burgers", "Fries", null);

const letter = "a"
letter = "b"
console.log(letter);