var height = 10;
var width = 20;
var area = height * width;
console.log(area);

let firstName = 'Hoang';
let lastName = 'Tran Quoc';
let fullName = firstName+' '+lastName;
console.log(fullName);

function avg( a: number, b: number) {
  return Math.pow(a, b);
}
console.log(avg(10,5));

var type: number = 0;
for (let i = 0; i < 4; i++) {
  type += avg(i, i+2);
}
console.log(type);
