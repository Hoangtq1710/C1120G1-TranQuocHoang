console.log("CAR BUYING AVAILABLE");
var buyCar = function (money) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            if (money < 5000) {
                return reject("You are not enough money to buy a car!");
            }
            else {
                return resolve("It's smell like a new car in here!");
            }
        }, 3000);
    });
};
var myMoney = 5100;
buyCar(myMoney)
    .then(function (data) { return console.log(data); })["catch"](function (err) { return console.log(err); });
