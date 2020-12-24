function addNewEmployee() {
    let emName;
    let emId;
    let emDob;
    let emPhone;
    let emEmail;
    let emLevel;
    let emPosition;
    let flag_level = true;
    let flag_position = true;

    // let arrInforEmp = [];


    emName = formatString(prompt("New Employee Name : \n"));
    // employee.setEmName(emName);
    // arrInforEmp.push(employee.getEmName());

    do {
        emId = prompt("New Employee ID : \n");
    } while (checking_id_format(emId) ===  false);
    // employee.setEmId(emId);
    // arrInforEmp.push(employee.getEmId());

    do {
        emDob = prompt("New Day Of Birth (YYYY-MM-DD) : \n");
    } while (checking_dob_format(emDob) === false);
    // employee.setEmDob(emDob);
    // arrInforEmp.push(employee.getEmDob());

    do {
        emPhone = prompt("New Employee Phone : \n");
    } while (checking_positive_number(emPhone) === false);
    // employee.setEmPhone(emPhone);
    // arrInforEmp.push(employee.getEmPhone());

    do {
        emEmail = prompt("New Employee Email : \n");
    } while (checking_email_format(emEmail) === false);
    // employee.setEmEmail(emEmail);
    // arrInforEmp.push(employee.getEmEmail());

    do {
        flag_level = true;
        let input = prompt("Select employee's academic level : \n\n" +
            "1. Intermediate\n" +
            "2. College\n" +
            "3. University\n" +
            "4. Postgraduate\n"
            );
        switch (input) {
            case '1':
                emLevel = "Intermediate";
                break;
            case '2':
                emLevel = "College";
                break;
            case '3':
                emLevel = "University";
                break;
            case '4':
                emLevel = "Postgraduate";
                break;
            default:
                alert("Failed!");
                flag_level = false;
        }
    } while (!flag_level);
    // employee.setEmLevel(emLevel);
    // arrInforEmp.push(employee.getEmLevel());

    do {
        flag_position = true;
        let input = prompt("Select Employee's Position : \n" +
            "1. Receptionist\n" +
            "2. Service staff\n" +
            "3. Specialist\n" +
            "4. Supervisor\n" +
            "5. Manager\n" +
            "6. Director\n");
        switch (input) {
            case '1':
                emPosition = "Receptionist";
                break;
            case '2':
                emPosition = "Service staff";
                break;
            case '3':
                emPosition = "Specialist";
                break;
            case '4':
                emPosition = "Supervisor";
                break;
            case '5':
                emPosition = "Manager";
                break;
            case '6':
                emPosition = "Director";
                break;
            default:
                alert("Failed!");
                flag_position = false;
        }
    } while (!flag_position);
    // employee.setEmPosition(emPosition);
    // arrInforEmp.push(employee.getEmPosition());

    let employee = new Employee(emName,emId,emDob,emPhone,emEmail,emLevel,emPosition);
    arrListEmp.push(employee);
    alert("You've added a new Employee successfully!\n");
    // arrListEmp[arrListEmp.length] = arrInforEmp;
}