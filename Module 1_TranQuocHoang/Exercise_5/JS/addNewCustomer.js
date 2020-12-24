function addNewCustomer() {
    let arrInforCustomer = [];
    fullName = formatString(prompt("New Customer Name : \n"));
    arrInforCustomer.push(fullName);

    do {
        idNumber = prompt("New Customer ID (XXXXXXXXX) : \n");
    } while (checking_id_format(idNumber) === false);
    arrInforCustomer.push(idNumber);

    do {
        dayOfBirth = prompt("New Day Of Birth (YYYY-MM-DD) : \n");
    } while (checking_dob_format(dayOfBirth) === false);
    arrInforCustomer.push(dayOfBirth);

    do {
        email = prompt("New Email : (abc@abc.abc) \n");
    } while (checking_email_format(email) === false);
    arrInforCustomer.push(email);

    address = formatString(prompt("New Customer Address : \n"));
    arrInforCustomer.push(address);

    province = formatString(prompt("New Customer Province : \n"));
    arrInforCustomer.push(province);

    vip = formatString(prompt("New Customer VIP : \n"));
    arrInforCustomer.push(vip);

    do {
        adult = prompt("Including how many adults? \n");
    } while (checking_positive_number(adult) === false);
    arrInforCustomer.push(adult);

    do {
        child = prompt("Including how many child? \n");
    } while (checking_positive_number(child) === false);
    arrInforCustomer.push(child);

    do {
        rentDays = prompt("How many days you wanna rent? \n");
    } while (checking_positive_number(rentDays) === false);
    arrInforCustomer.push(rentDays);

    service = formatString(prompt("Which service do you wanna hire?\n"));
    arrInforCustomer.push(service);

    roomType = formatString(prompt("Which room type do you wanna hire?\n"));
    arrInforCustomer.push(roomType);
    alert("You've added a new Customer successfully!\n");
    arrListCustomer[arrListCustomer.length] = arrInforCustomer;
}