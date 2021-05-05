console.log("CAR BUYING AVAILABLE");
let buyCar = function (money:number) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            if (money < 5000) {
                return reject("You are not enough money to buy a car!");
            } else {
                return resolve("It's smell like a new car in here!");
            }
        }, 2500);
    })
}
let myMoney = 5100;
buyCar(myMoney)
    .then(data => console.log(data))
    .catch(err => console.log(err));
