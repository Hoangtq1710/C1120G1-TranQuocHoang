function addEmpFirst() {
    alert("Please choose 1 to add Employee first!");
}
function menuEmployee() {
    let flag_menuEmp = true;
    do {
        menuEmp = prompt("Menu Employee" + "\n" +
            "\n" +
            "1. Add New Employee" + "\n" +
            "2. Display Information Employee" + "\n" +
            "3. Salary of Employees" + "\n" +
            "x. Back\n"
        );
    switch (menuEmp) {
        case "1":
            addNewEmployee();
            break;
        case "2":
            if (arrListEmp.length !== 0) {
                displayInforEmp();
            } else {
                addEmpFirst();
            }
            break;
        case "3":
            if (arrListEmp.length !== 0) {
                displaySalaryEmp();
            } else {
                addEmpFirst();
            }
            break;
        case "x":
            flag_menuEmp = false;
            break;
        default :
            alert("Please select option in the menu!");
            break;
        }
    }while (flag_menuEmp);

}