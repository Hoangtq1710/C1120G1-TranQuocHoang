let menu;
let flag = true;
let arrNameCustomer = [];
function addNameCustomer() {
    let number = parseInt(prompt("How many customers you wanna add?"));
    let nameCustomer;
    for (let i = 0; i < number; i++) {
        let flag_name = true;
        do {
            nameCustomer = prompt("Enter the name of Customer " + (i + 1));
            if (arrNameCustomer.indexOf(nameCustomer) !== -1) {
                alert("This customer is already on the list!!");
            } else {
                flag_name = false;
            }
        }
        while (flag_name);
        arrNameCustomer.push(nameCustomer);
    }
}
function displayNameCustomer() {
    arrNameCustomer = arrNameCustomer.sort();
    let display = "";
    if (arrNameCustomer.length !== 0) {
        display += "List of Customer : \n\n";
        for (let i = 0; i < arrNameCustomer.length; i++) {
            display += (i+1)+". "+arrNameCustomer[i]+"\n";
        }
        return alert(display);
    } else {
        addFirst();
    }
}
function deleteCustomer() {
    if (arrNameCustomer.length !== 0) {
        let deleteName = prompt("Enter the name of Customer you wanna delete : ");
        if (arrNameCustomer.indexOf(deleteName) === -1) {
            return alert("Sorry! Our list don't have any name like : "+deleteName);
        }
        for (let i = 0; i < arrNameCustomer.length; i++) {
            if (arrNameCustomer[i] === deleteName) {
                arrNameCustomer.splice(i, 1);
                i--;
            }
        }
        return displayNameCustomer();
    }else {
        addFirst();
    }
}
function addFirst() {
    return alert("Your list have no Customer!\nPlease select 1 to add a name of Customer !");
}
while (flag){
    menu = prompt("Menu\n\n"+
        "1. Add Name Customer\n" +
        "2. Display Name Customer\n" +
        "3. Delete Customer\n" +
        "x. Exit\n"
    );
    switch (menu) {
        case "1":
            addNameCustomer();
            break;
        case "2":
            displayNameCustomer();
            break;
        case "3":
            deleteCustomer();
            break;
        case "x":
            flag = false;
            break;
        default: alert("Failed");
            break;

    }
}
