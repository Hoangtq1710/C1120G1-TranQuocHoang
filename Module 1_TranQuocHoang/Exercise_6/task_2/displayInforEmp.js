function displayOneEmp(i) {
    return "1. Employee Name : " + arrListEmp[i].getEmName() + "\n" +
            "2. Employee Identify : " + arrListEmp[i].getEmId() + "\n" +
            "3. Day Of Birth : " + arrListEmp[i].getEmDob() + "\n" +
            "4. Employee Phone : " + arrListEmp[i].getEmPhone() + "\n" +
            "5. Employee Email : " + arrListEmp[i].getEmEmail() + "\n" +
            "6. Level : " + arrListEmp[i].getEmLevel() + "\n" +
            "7. Position : " + arrListEmp[i].getEmPosition() + "\n" +
            "8. Salary: " + arrListEmp[i].getSalary() +" $"+ "\n"
        ;
}
function displayInforEmp() {
    for (let i = 0; i < arrListEmp.length; i++) {
        alert(displayOneEmp(i));
    }
}