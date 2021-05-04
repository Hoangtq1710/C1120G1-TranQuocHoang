var height = 10;
var width = 20;
var area = height * width;
console.log(area);
var firstName = 'Hoang';
var lastName = 'Tran Quoc';
var fullName = firstName + ' ' + lastName;
console.log(fullName);
function avg(a, b) {
    return Math.pow(a, b);
}
console.log(avg(10, 5));
var type = 0;
for (var i = 0; i < 4; i++) {
    type += avg(i, i + 2);
}
console.log(type);
