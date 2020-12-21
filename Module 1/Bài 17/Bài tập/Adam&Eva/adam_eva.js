class Apple {
    constructor(weight) {
        this.weight = 10;
    }
    getWeight(){
        return this.weight;
    }
    setWeight(weight){
        this._weight = weight;
    }
}
class Human {
    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }
    setName(name){
        this.name = name;
    }
    getName(){
        return this.name;
    }
    setWeight(weight){
        this.weight = weight;
    }
    getWeight(){
        return document.write(this.name+"'s weight is "+this.weight+"<br>");
    }
    setGender(gender) {
        return this.gender = gender;
    }
    isMale(gender){
        if (gender === "male") {
            return true;
        }
        return false;
    }
    speak(str){
        document.write(this.name+" said : "+str+"<br>");
    }
    eatApple(apple){
        if (apple.getWeight() > 0){
            apple.weight--;
            this.weight ++;
        }
    }
    checkApple(apple){
        if (apple.getWeight() === 0){
            return document.write("You've eaten all this forbidden apple!!! The God of Death is coming to you<br>");
        }
        return document.write("This apple has weight is "+apple.getWeight()+"<br>");
    }
}

let adam = new Human("Adam", "male", 50);
let eva = new Human("Eva", "female", 40);

let apple = new Apple();

adam.speak("Hello. My name is "+adam.getName());
eva.speak("Hi. My name is "+eva.getName());

document.write("Adam picks an apple from the Garden of Eden<br>");

for (let i = apple.getWeight(); i > 0; i--) {
    adam.eatApple(apple);
    eva.eatApple(apple);
}
adam.getWeight();
eva.getWeight();

adam.checkApple(apple);