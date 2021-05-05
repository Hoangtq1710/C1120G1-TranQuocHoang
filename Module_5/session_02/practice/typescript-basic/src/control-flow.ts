console.log("\nODD OR EVEN")
for (let i = 1; i <= 9; i++) {
    if (i % 2 == 0) {
        console.log(i + " is odd number");
    } else {
        console.log(i + " is even number");
    }
}

console.log("\nCOUNTING DAYS OF MONTH");
let month:number = 1;
while (month <= 12) {
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            console.log(month+" - "+" has 31 days");
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            console.log(month+" - "+" has 30 days");
            break;
        case 2:
            console.log(month+" - "+" has 28 or 29 days");
            break;
        default:
            console.log("Wrong!");
            break;
    }
    month++;
}

console.log("\nRECTANGLE AREA")
let width:number = 15;
let height:number = 39;
let area: number = width*height;
console.log(`Rectangle area is : ${area}`);

