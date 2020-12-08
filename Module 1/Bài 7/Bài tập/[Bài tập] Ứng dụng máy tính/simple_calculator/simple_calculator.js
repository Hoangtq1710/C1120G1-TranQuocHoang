function calculator(operator) {
    let a = parseFloat(document.getElementById("num_a").value);
    let b = parseFloat(document.getElementById("num_b").value);
    let result;
    let operatorName;
    switch (operator) {
        case "+":
            result = a + b;
            operatorName = "Addition";
            break;
        case "-":
            result = a - b;
            operatorName = "Subtraction";
            break;
        case "*":
            result = a * b;
            operatorName = "Multiplication";
            break;
        case "/":
            result = a / b;
            operatorName = "Division";
            break;
    }
    document.getElementById("result").innerText = "Result " + operatorName + ": " + result;
}