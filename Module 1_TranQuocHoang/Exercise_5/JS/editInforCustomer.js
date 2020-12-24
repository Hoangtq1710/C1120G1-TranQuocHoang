function editInforCustomer() {
    let flagId =  true;
    let inputId = prompt("Enter the ID of Customer you wanna edit Information :");

    for (let i = 0; i < arrListCustomer.length; i++) {
        for (let j = 0; j < arrListCustomer[i].length; j++) {
            if (inputId === arrListCustomer[i][1]) {
                index = i;
                flagId = false;
            }
        }
        if (flagId === false) {
            edit();
        }
    }
}
function edit() {
    let editFullname;
    let editId;
    let editDob;
    let editEmail;
    let editAddress;
    let editProvince;
    let editVip;
    let editAdult;
    let editChild;
    let editRentdays;
    let editService;
    let editRoomtype;

    let flagEdit = true;

    do {
        let edit = prompt("Which information do you wanna change?\n\n" + displayOne(index)+
                    "x. Back");
        switch (edit) {
            case "1": // edit full name
                editFullname = prompt("New Fullname :\n\n" +
                    "\n" +
                    "1. Customer Name : " + arrListCustomer[index][0] + "\n" +
                    "\n"
                );
                arrListCustomer[index][0] = formatString(editFullname);
                break;

            case "2": //edit id
                do {
                    editId = prompt("New ID : \n\n" +
                        "\n" +
                        "2. Customer Identify : " + arrListCustomer[index][1] + "\n" +
                        "\n"
                    );
                    flag_checking_id = checking_id_format(editId);
                } while (flag_checking_id === false);
                arrListCustomer[index][1] = editId;
                break;
            case "3": //edit dob
                do {
                    editDob = prompt("New Day Of Birth (YYYY-MM-DD) : \n\n" +
                        "\n" +
                        "3. Day Of Birth : " + arrListCustomer[index][2] + "\n" +
                        "\n"
                    );
                    flag_checking_dob = checking_dob_format(editDob);
                } while (flag_checking_dob === false)
                arrListCustomer[index][2] = editDob;
                break;
            case "4": //edit email *****error*****
                do {
                    editEmail = prompt("New Email : (abc@abc.abc) \n\n" +
                        "\n" +
                        "4. Customer Email : " + arrListCustomer[index][3] + "\n" +
                        "\n"
                    );
                    flag_checking_email = checking_email_format(editEmail);
                } while (flag_checking_email === false);
                arrListCustomer[index][3] = editEmail;
                break;
            case "5": //edit address
                editAddress = prompt("New Address : \n\n" +
                    "\n" +
                    "5. Address : " + arrListCustomer[index][4] + "\n" +
                    "\n"
                );
                arrListCustomer[index][4] = formatString(editAddress);
                break;
            case "6": //edit province
                editProvince = prompt("New Province : \n\n" +
                    "\n" +
                    "6. Province : " + arrListCustomer[index][5] + "\n" +
                    "\n"
                );
                arrListCustomer[index][5] = editProvince;
                break;
            case "7": //edit vip
                editVip = prompt("New VIP : \n\n" +
                    "\n" +
                    "7. VIP : " + arrListCustomer[index][6] + "\n" +
                    "\n"
                );
                arrListCustomer[index][6] = formatString(editVip);
                break;
            case "8": //edit adult
                do {
                    editAdult = prompt("New Adult : \n\n" +
                        "\n" +
                        "9. Adult amount : " + arrListCustomer[index][7] + "\n" +
                        "\n"
                    );
                } while (checking_positive_number(editAdult) === false);
                arrListCustomer[index][7] = editAdult;
                break;
            case "9": //edit child
                do {
                    editChild = prompt("New Child : \n\n" +
                        "\n" +
                        "10. Child amount : " + arrListCustomer[index][8] + "\n" +
                        "\n"
                    );
                } while (checking_positive_number(editChild) === false);
                arrListCustomer[index][8] = editChild;
                break;
            case "10": //edit rentdays
                do {
                    editRentdays = prompt("New Rent Days : \n\n" +
                        "\n" +
                        "11. Rent days : " + arrListCustomer[index][9] + "\n" +
                        "\n"
                    );
                } while (checking_positive_number(editRentdays) === false);
                arrListCustomer[index][9] = editRentdays;
                break;
            case "12": //edit service
                editService = prompt("New Service : \n\n" +
                    "\n" +
                    "12. Service : " + arrListCustomer[index][10] + "\n" +
                    "\n"
                );
                arrListCustomer[index][10] = formatString(editService);
                break;
            case "13": //edit room type
                editRoomtype = prompt("New Room type : \n\n" +
                    "\n" +
                    "13. Room type : " + arrListCustomer[index][11] + "\n" +
                    "\n"
                );
                arrListCustomer[index][11] = editRoomtype;
                break;
            case "x" :
                flagEdit = false;
                break;
            default:
                alert("Failed");
                break;

        }
    } while (flagEdit);
}