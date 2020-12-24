function displaySalaryEmp() {
    let flag_idEm = true;
    let input_emId = prompt("Enter ID of Employee you wanna show Salary");
    for (let i = 0; i < arrListEmp.length; i++) {
        for (let j = 0; j < arrListEmp[i].length; j++) {
            if (input_emId === arrListEmp[i].getEmId()) {
                index = i;
                flag_idEm = false;
            }
        }
        if (flag_idEm === false) {
            alert("Employee "+arrListEmp[index].getEmName()+" has salary is "+arrListEmp[index].getSalary());
        }
    }
}