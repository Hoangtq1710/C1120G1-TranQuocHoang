function displaySalaryEmp() {
    let flagIdEm = true;
    let inputEmId = prompt("Enter ID of Employee you wanna show Salary");
    for (let i = 0; i < arrListEmp.length; i++) {
        if (inputEmId == arrListEmp[i].getEmId()) {
            index = i;
            flagIdEm = false;
        }
    }
    if (flagIdEm === false) {
        display();
    } else {
        alert("Wrong ID");
    }
}
function display() {
    alert("Employee "+arrListEmp[index].getEmName()+" has salary is "+arrListEmp[index].getSalary());
}