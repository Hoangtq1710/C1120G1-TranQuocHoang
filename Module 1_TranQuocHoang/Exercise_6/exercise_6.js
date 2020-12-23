let menu;
let arrListCustomer = [];
let index;
let pickNumber;

function addFirst() {
    alert("Please choose 1 to add Customer first!");
}
function displayMainMenu() {
    let flag_menu = true;
    do {
        menu = prompt("Menu" + "\n" +
            "\n" +
            "1. Add New Customer" + "\n" +
            "2. Display Information Customer" + "\n" +
            "3. Display Total pay of Customer" + "\n" +
            "4. Edit Information Customer" + "\n" +
            "5. Delete Customer" + "\n" +
            "x. Exit\n"
        );
    }
    while (!flag_menu);
    switch (menu) {
        case "1":
            addNewCustomer();
            displayMainMenu();
            break;
        case "2":
            if (arrListCustomer.length !== 0) {
                displayInforCustomer();
            } else {
                addFirst();
            }
            displayMainMenu();
            break;
        case "3":
            if (arrListCustomer.length !== 0) {
                displayTotalPay();
            } else {
                addFirst();
            }
            displayMainMenu();
            break;
        case "4":
            if (arrListCustomer.length !== 0) {
                editInforCustomer();
            } else {
                addFirst();
            }
            displayMainMenu();
            break;
        case "5":
            if (arrListCustomer.length !== 0) {
                deleteCustomer();
            } else {
                addFirst();
            }
            displayMainMenu();
            break;
        case "x":
            flag_menu = false;
            break;
        default :
            alert("Please select option in the menu!");
            displayMainMenu();
            break;

    }
}
displayMainMenu();
