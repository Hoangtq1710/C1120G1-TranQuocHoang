// let from_cur = document.getElementById("from_cur");
// let to_cur = document.getElementById("to_cur");
// let from_cur;
// let from;
// let to;
// let to_cur;
// let result;
// let input_amount = document.getElementById("amount");
//
// function convert() {
//
//
//     let amount = parseFloat(input_amount.value);
//
//     const vnd = 1;
//     const usd = 23000;
//     const eur = 25000;
//
//
//     // switch ("from_currency") {
//     //     case 1: from_cur = vnd; break;
//     //     case 2: from_cur = usd; break;
//     //     case 3: from_cur = eur; break;
//     // }
//     //
//     // switch ("to_currency") {
//     //     case 4: to_cur = vnd; break;
//     //     case 5: to_cur = usd; break;
//     //     case 6: to_cur = eur; break;
//     // }
//
//     from_cur = document.getElementById("from_cur");
//     to_cur = document.getElementById("to_cur");
//
// //     switch (from_cur) {
// //         case 1: from_cur.value = vnd;
// //         case 2: from_cur.value = usd;
// //         case 3: from_cur.value = eur;
// //     }
// //     switch (to_cur) {
// //         case 1: to_cur.value = vnd;
// //         case 2: to_cur.value = usd;
// //         case 3: to_cur.value = eur;
// //     }
// //
// //
// //
// //
// //     result = amount * from_cur / to_cur ;
// //
// //     document.getElementById("result").innerText = result;
// //
// //     console.log(result);
// //     // document.write(result);
// //
// //
// // //         ví dụ 20 , USD sand VND => result = 20*23000/1;
// // //         ví dụ 75000 , VND sang EUR => result = 75000*1/25000;
// // //         ví dụ 15 , EUR sang USD => result = 15 * 25000/23000;
// }
let a = document.getElementById("amount").value
let b = document.getElementById("from_cur").value
let c = document.getElementById("to_cur").value
let l;

function convert() {
    if (b == "VND" && c == "USA") {
        l = a / 23000
    } else if (b=="USA" && c == "VND")
        l = a * 23000
}
document.getElementById("result").innerText=l;
