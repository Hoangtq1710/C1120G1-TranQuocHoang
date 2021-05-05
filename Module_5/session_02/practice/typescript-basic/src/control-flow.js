console.log("\nODD OR EVEN");
for (var i_1 = 1; i_1 <= 9; i_1++) {
    if (i_1 % 2 == 0) {
        console.log(i_1 + " is odd number");
    }
    else {
        console.log(i_1 + " is even number");
    }
}
console.log("\nCOUNTING DAYS OF MONTH");
var month = 1;
while (month <= 12) {
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            console.log(month + " - " + " has 31 days");
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            console.log(month + " - " + " has 30 days");
            break;
        case 2:
            console.log(month + " - " + " has 28 or 29 days");
            break;
        default:
            console.log("Wrong!");
            break;
    }
    month++;
}
