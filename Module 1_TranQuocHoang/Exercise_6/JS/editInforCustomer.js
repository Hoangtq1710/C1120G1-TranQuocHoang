function editInforCustomer() {
    let flag_id =  true;
    let input_id = prompt("Enter the ID of Customer you wanna edit Information :");

    for (let i = 0; i < arrListCustomer.length; i++) {
        for (let j = 0; j < arrListCustomer[i].length; j++) {
            if (input_id === arrListCustomer[i][1]) {
                index = i;
                flag_id = false;
            }
        }
        if (flag_id === false) {
            edit();
        }
    }
}
function edit() {
    let edit_fullname;
    let edit_id;
    let edit_dob;
    let edit_email;
    let edit_address;
    let edit_province;
    let edit_vip;
    let edit_discount;
    let edit_adult;
    let edit_child;
    let edit_rentdays;
    let edit_service;
    let edit_roomtype;

    let flag_edit = true;

    do {
        let edit = prompt("Which information do you wanna change?\n\n" + displayOne(index)+
                    "x. Back");
        switch (edit) {
            case "1": // edit full name
                edit_fullname = prompt("New Fullname :\n\n" +
                    "\n" +
                    "1. Customer Name : " + arrListCustomer[index][0] + "\n" +
                    "\n"
                );
                arrListCustomer[index][0] = formatString(edit_fullname);
                break;

            case "2": //edit id
                do {
                    edit_id = prompt("New ID : \n\n" +
                        "\n" +
                        "2. Customer Identify : " + arrListCustomer[index][1] + "\n" +
                        "\n"
                    );
                    flag_checking_id = checking_id_format(edit_id);
                } while (flag_checking_id === false);
                arrListCustomer[index][1] = edit_id;
                break;
            case "3": //edit dob
                do {
                    edit_dob = prompt("New Day Of Birth (YYYY-MM-DD) : \n\n" +
                        "\n" +
                        "3. Day Of Birth : " + arrListCustomer[index][2] + "\n" +
                        "\n"
                    );
                    flag_checking_dob = checking_dob_format(edit_dob);
                } while (flag_checking_dob === false)
                arrListCustomer[index][2] = edit_dob;
                break;
            case "4": //edit email *****error*****
                do {
                    edit_email = prompt("New Email : (abc@abc.abc) \n\n" +
                        "\n" +
                        "4. Customer Email : " + arrListCustomer[index][3] + "\n" +
                        "\n"
                    );
                    flag_checking_email = checking_email_format(edit_email);
                } while (flag_checking_email === false);
                arrListCustomer[index][3] = edit_email;
                break;
            case "5": //edit address
                edit_address = prompt("New Address : \n\n" +
                    "\n" +
                    "5. Address : " + arrListCustomer[index][4] + "\n" +
                    "\n"
                );
                arrListCustomer[index][4] = formatString(edit_address);
                break;
            case "6": //edit province
                edit_province = prompt("New Province : \n\n" +
                    "\n" +
                    "6. Province : " + arrListCustomer[index][5] + "\n" +
                    "\n"
                );
                arrListCustomer[index][5] = edit_province;
                break;
            case "7": //edit vip
                edit_vip = prompt("New VIP : \n\n" +
                    "\n" +
                    "7. VIP : " + arrListCustomer[index][6] + "\n" +
                    "\n"
                );
                arrListCustomer[index][6] = formatString(edit_vip);
                break;
            case "8": //edit discount
                do {
                    edit_discount = parseInt(prompt("New Discount (5-70%) : \n\n"+
                        "\n" +
                        "8. Discount : " + arrListCustomer[index][7] + " %\n" +
                    "\n")
                    );
                } while (checking_positive_number(edit_discount) || (edit_discount < 5) || (edit_discount > 70));
                arrListCustomer[index][7] = edit_discount;
                break;
            case "9": //edit adult
                do {
                    edit_adult = prompt("New Adult : \n\n" +
                        "\n" +
                        "9. Adult amount : " + arrListCustomer[index][8] + "\n" +
                        "\n"
                    );
                } while (checking_positive_number(edit_adult) === false);
                arrListCustomer[index][8] = edit_adult;
                break;
            case "10": //edit child
                do {
                    edit_child = prompt("New Child : \n\n" +
                        "\n" +
                        "10. Child amount : " + arrListCustomer[index][9] + "\n" +
                        "\n"
                    );
                } while (checking_positive_number(edit_child) === false);
                arrListCustomer[index][9] = edit_child;
                break;
            case "11": //edit rentdays
                do {
                    edit_rentdays = prompt("New Rent Days : \n\n" +
                        "\n" +
                        "11. Rent days : " + arrListCustomer[index][10] + "\n" +
                        "\n"
                    );
                } while (checking_positive_number(edit_rentdays) === false);
                arrListCustomer[index][10] = edit_rentdays;
                break;
            case "12": //edit service
                edit_service = prompt("New Service : \n\n" +
                    "\n" +
                    "12. Service : " + arrListCustomer[index][11] + "\n" +
                    "\n"
                );
                arrListCustomer[index][11] = formatString(edit_service);
                break;
            case "13": //edit room type
                edit_roomtype = prompt("New Room type : \n\n" +
                    "\n" +
                    "13. Room type : " + arrListCustomer[index][12] + "\n" +
                    "\n"
                );
                arrListCustomer[index][12] = edit_roomtype;
                break;
            case "x" :
                flag_edit = false;
                break;
            default:
                alert("Failed");
                break;

        }
    } while (flag_edit);
}