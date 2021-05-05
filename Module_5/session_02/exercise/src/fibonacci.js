console.log("SUM OF FIRST 15 FIBONACCI");
function getSumOfFibonacci(number) {
    var sum = 0;
    var first = 0;
    var second = 1;
    var third;
    var count = 2;
    sum += first + second;
    while (count <= number) {
        third = first + second;
        first = second;
        second = third;
        sum += third;
        count++;
    }
    console.log("Sum of " + number + " First Fibonacci is " + sum);
}
getSumOfFibonacci(15);
