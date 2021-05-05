console.log("SUM OF FIRST 15 FIBONACCI");

function getSumOfFibonacci(number:number) {
    let sum:number = 0;
    let first:number = 0;
    let second:number = 1;
    let third:number;

    let count:number = 2;
    sum += first + second;

    while (count <= number){
        third = first + second;
        first = second;
        second = third;

        sum += third;
        count++;
    }
    console.log("Sum of "+number+" First Fibonacci is "+sum);
}

getSumOfFibonacci(15);
