function displaySalaryEmp() {
    let flag_idEm = true;
    let input_emId = prompt("Enter ID of Employee you wanna show Salary");
    for (let i = 0; i < arrListEmp.length; i++) {
        if (input_emId == arrListEmp[i].getEmId()) {
            index = i;
            flag_idEm = false;
        }
    }
    if (flag_idEm === false) {
        display();
    } else {
        alert("Wrong ID");
    }
}
function display() {
    alert("Employee "+arrListEmp[index].getEmName()+" has salary is "+arrListEmp[index].getSalary());
}