function displayTotalPay() {
    let printDisplay = "";
    printDisplay += "Please choose the number of Customer (1 - " + arrListCustomer.length + ") : \n";
    for (let i = 0; i < arrListCustomer.length; i++) {
        printDisplay += (i+1) + ". " + arrListCustomer[i][0] + " \n";
    }
    do {
        pickNumber = parseInt(prompt(printDisplay));
    } while ((pickNumber < 1) || (pickNumber > arrListCustomer.length) || ((pickNumber*0) !== 0));

    let money = arrListCustomer[pickNumber-1][13];
    let nameCus = arrListCustomer[pickNumber-1][0];
    alert("Customer "+nameCus+" have to pay "+money+" $");
}