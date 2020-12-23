function displayTotalPay() {
    let pickNumber;
    let displayName = [];
    for (let i = 0; i < arrListCustomer.length; i++) {
        displayName[i] = arrListCustomer[i][0];
    }
    let print = "";
    print += "Please enter the customer name : \n";
    for (let i = 0; i < arrListCustomer.length; i++) {
        print += i+". "+arrListCustomer[i][0]+" \n";
    }
    pickNumber = prompt(print);
    // switch (pickNumber) {
    //     case parseInt(pickNumber) :
    //        
    // }
}
function display() {

}