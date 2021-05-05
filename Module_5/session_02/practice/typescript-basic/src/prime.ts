console.log("\nSUM OF FIRST 30 PRIME NUMBERS")
export function isPrime(number:number):boolean {
    if (number < 2) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}
let count:number = 0;
let i:number = 1;
let sum:number = 0;
while (count <= 30){
    if (isPrime(i)) {
        sum += i;
        count++;
    }
    i++;
}
console.log("Sum of first 30 Prime number is "+ sum);
