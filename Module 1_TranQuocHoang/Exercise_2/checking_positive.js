
// let num = prompt("Nhap number");
// if (checking_positive_number(num)) {
//     alert("Dung");
// } else {
//     alert("Sai");
// }

function checking_positive_number(positiveNumber) {
    let int_number = ["0","1","2","3","4","5","6","7","8","9"];
    let count = 0;
    for (let i = 0; i < positiveNumber.length; i++) {
        for (let j = 0; j < int_number.length; j++) {
            if (positiveNumber[i] === int_number[j]) {
                count++;
            }
        }
    }
    if (count !== positiveNumber.length) {
        return false;
    }
    let number = parseInt(positiveNumber);
    if (number > 0) {
        return true;
    }
    return false;
}