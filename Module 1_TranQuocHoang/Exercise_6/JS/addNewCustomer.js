function addNewCustomer() {
    let input_fullname;
    let input_id;
    let input_dob;
    let input_email;
    let input_address;
    let input_province;
    let input_vip;
    let input_discount;
    let input_adult;
    let input_child;
    let input_rentdays;
    let input_service;
    let input_roomtype;
    let payout;

    let arrInforCustomer = [];
    let customer = new Customer();

    input_fullname = formatString(prompt("New Customer Name : \n"));
    customer.setFullName(input_fullname);
    arrInforCustomer.push(customer.getFullName());

    do {
        input_id = prompt("New Customer ID (XXXXXXXXX) : \n");
    } while (checking_id_format(input_id) === false);
    customer.setIdNumber(input_id)
    arrInforCustomer.push(customer.getIdNumber());

    do {
        input_dob = prompt("New Day Of Birth (YYYY-MM-DD) : \n");
    } while (checking_dob_format(input_dob) === false);
    customer.setDob(input_dob);
    arrInforCustomer.push(customer.getDob());

    do {
        input_email = prompt("New Email : (abc@abc.abc) \n");
    } while (checking_email_format(input_email) === false);
    customer.setEmail(input_email);
    arrInforCustomer.push(customer.getEmail());

    input_address = formatString(prompt("New Customer Address : \n"));
    customer.setAddress(input_address);
    arrInforCustomer.push(customer.getAddress());

    input_province = formatString(prompt("New Customer Province : \n"));
    customer.setProvince(input_province);
    arrInforCustomer.push(customer.getProvince());

    input_vip = formatString(prompt("New Customer VIP : \n"));
    customer.setVip(input_vip);
    arrInforCustomer.push(customer.getVip());

    do {
        input_discount = prompt("New Customer Discount (5 -70): \n");
    } while ((checking_positive_number(input_discount) === false) || (parseInt(input_discount) < 5) || (parseInt(input_discount) > 70));
    customer.setDiscount(input_discount);
    arrInforCustomer.push(customer.getDiscount());

    do {
        input_adult = prompt("Including how many adults? \n");
    } while (checking_positive_number(input_adult) === false);
    customer.setAdult(input_adult);
    arrInforCustomer.push(customer.getAdult());

    do {
        input_child = prompt("Including how many child? \n");
    } while (checking_positive_number(input_child) === false);
    customer.setChild(input_child);
    arrInforCustomer.push(customer.getChild());

    do {
        input_rentdays = prompt("How many days you wanna rent? \n");
    } while (checking_positive_number(input_rentdays) === false);
    customer.setRentDays(input_rentdays);
    arrInforCustomer.push(customer.getRentDays());

    input_service = formatString(prompt("Which service do you wanna hire?\n"));
    customer.setService(input_service);
    arrInforCustomer.push(customer.getService());

    input_roomtype = formatString(prompt("Which room type do you wanna hire?\n"));
    customer.setRoomType(input_roomtype);
    arrInforCustomer.push(customer.getRoomType());

    arrInforCustomer.push(customer.payout());
    alert("You've added a new Customer successfully!\n");
    arrListCustomer[arrListCustomer.length] = arrInforCustomer;
}