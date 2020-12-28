function displaySalaryEmp() {
    let flag_idEm = true;
    let input_emId = parseInt(prompt("Enter ID of Employee you wanna show Salary"));
    for (let i = 0; i < arrListEmp.length; i++) {
        if (input_emId === arrListEmp[i].getEmId()) {
            index = i;
            flag_idEm = false;
        } else {
            alert("Wrong ID!!!");
        }

        if (flag_idEm === false) {
            display();
        }
    }
}
function display() {
    alert("Employee "+arrListEmp[index].getEmName()+" has salary is "+arrListEmp[index].getSalary());
}