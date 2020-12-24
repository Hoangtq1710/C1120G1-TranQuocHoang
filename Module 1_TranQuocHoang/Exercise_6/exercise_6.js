let mainMenu;
let menuCus;
let menuEmp;
let arrListCustomer = [];
let arrListEmp = [];
let index;
let pickNumber;

let emp = new Employee("ABC",111222333,"2011-04-04",111444555,"a@a.a","College","Manager");
arrListEmp.push(emp);

function mainMenu6() {
    let flagMain = true;
    do {
        mainMenu = prompt("Main Menu\n\n"+
            "1. Menu Customer \n"+
            "2. Menu Employee \n"+
            "x. Exit \n"
        );
        switch (mainMenu) {
            case "1":
                displayMenuCustomer();
                break;
            case "2":
                menuEmployee();
                break;
            case "x":
                flagMain = false;
                break;
            default:
                break;
        }
    } while (flagMain)
}

function addFirst() {
    alert("Please choose 1 to add Customer first!");
}

function displayMenuCustomer() {
    let flag_menu = true;
    do {
        menuCus = prompt("Menu Customer" + "\n" +
            "\n" +
            "1. Add New Customer" + "\n" +
            "2. Display Information Customer" + "\n" +
            "3. Display Total pay of Customer" + "\n" +
            "4. Edit Information Customer" + "\n" +
            "5. Delete Customer" + "\n" +
            "x. Back\n"
        );
        switch (menuCus) {
            case "1":
                addNewCustomer();
                break;
            case "2":
                if (arrListCustomer.length !== 0) {
                    displayInforCustomer();
                } else {
                    addFirst();
                }
                break;
            case "3":
                if (arrListCustomer.length !== 0) {
                    displayTotalPay();
                } else {
                    addFirst();
                }
                break;
            case "4":
                if (arrListCustomer.length !== 0) {
                    editInforCustomer();
                } else {
                    addFirst();
                }
                break;
            case "5":
                if (arrListCustomer.length !== 0) {
                    deleteCustomer();
                } else {
                    addFirst();
                }
                break;
            case "x":
                flag_menu = false;
                break;
            default :
                alert("Please select option in the menu!");
                break;

        }
    }
    while (flag_menu);

}

mainMenu6();
