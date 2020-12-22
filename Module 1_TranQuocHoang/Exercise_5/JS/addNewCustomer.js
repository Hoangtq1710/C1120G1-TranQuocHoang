function addNewCustomer() {
    let arrInforCustomer = [];
    full_name = formatString(prompt("New Customer Name : \n"));
    arrInforCustomer.push(full_name);

    do {
        id_number = prompt("New Customer ID (XXXXXXXXX) : \n");
    } while (checking_id_format(id_number) === false);
    arrInforCustomer.push(id_number);

    do {
        day_of_birth = prompt("New Day Of Birth (YYYY-MM-DD) : \n");
    } while (checking_dob_format(day_of_birth) === false);
    arrInforCustomer.push(day_of_birth);

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
        rent_days = prompt("How many days you wanna rent? \n");
    } while (checking_positive_number(rent_days) === false);
    arrInforCustomer.push(rent_days);

    service = formatString(prompt("Which service do you wanna hire?\n"));
    arrInforCustomer.push(service);

    room_type = formatString(prompt("Which room type do you wanna hire?\n"));
    arrInforCustomer.push(room_type);
    alert("You've added a new Customer successfully!\n");
    arrListCustomer[arrListCustomer.length] = arrInforCustomer;
}