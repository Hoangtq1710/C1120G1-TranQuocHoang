let full_name = "Le Van A";
let id_number = "205124648";
let day_of_birth = "1992-04-21";
let email = "admin@admin.com";
let address = "K17 Nguyễn Tất Thành";
let province = "Đà Nẵng";
let vip = "Diamond";
let discount;
let adult = "2";
let child = "1";
let rent_days = "6";
let service = "Villa (500$/day)";
let room_type = "Normal";

let menu;
let edit;
let edit_fullname;
let edit_id;
let edit_dob;
let edit_email;
let edit_address;
let edit_province;
let edit_vip;
// let edit_discount;
let edit_adult;
let edit_child;
let edit_rentdays;
let edit_service;
let edit_roomtype;

let payout;
let sv;
let discount_by_day_amount;
let discount_by_vip;
let discount_by_province;

switch (service) {
    case "Villa (500$/day)": sv = 500;
        break;
    case "House (300$/day)": sv = 300;
        break;
    case "Room (100$/day)": sv = 100;
        break;
    default: alert("Failed");
        break;
}
if (rent_days <= 4) {
    discount_by_day_amount = 10;
} else if (rent_days <= 7) {
    discount_by_day_amount = 20;
} else {
    discount_by_day_amount = 30;
}

switch (province) {
    case "Đà Nẵng":
        discount_by_province = 20;
        break;
    case "Huế":
        discount_by_province = 10;
        break;
    case "Quảng Nam":
        discount_by_province = 5;
        break;
    default:
        discount_by_province = 0;
        break;
}


switch (vip) {
    case "Diamond": discount_by_vip = 15;
        break;
    case "Platinum": discount_by_vip = 10;
        break;
    case "Gold": discount_by_vip = 5;
        break;
    case "Silver": discount_by_vip = 2;
        break;
    case "Member": discount_by_vip = 0;
        break;
    default : alert("Failed");
        break;
}


function show_alert_infor() {
    alert("1. Show Information Customer :" + "\n" +
        "\n" +
        "1. Customer Name : " + full_name + "\n" +
        "2. Customer Identify : " + id_number + "\n" +
        "3. Day Of Birth : " + day_of_birth + "\n" +
        "4. Customer Email : " + email + "\n" +
        "5. Address : " + address + "\n" +
        "6. Province : " + province + "\n" +
        "7. VIP : " + vip + "\n" +
        "8. Discount: " + discount +" $"+ "\n" +
        "9. Adult amount : " + adult + "\n" +
        "10. Child amount : " + child + "\n" +
        "11. Rent days : " + rent_days + "\n" +
        "12. Service : " + service + "\n" +
        "13. Room type : " + room_type + "\n" +
        "\n"
    );
}

function edit_information_customer() {
    edit = prompt("2. Edit Information Customer :\n" +
        "\n" +
        "1. Customer Name : " + full_name + "\n" +
        "2. Customer Identify : " + id_number + "\n" +
        "3. Day Of Birth : " + day_of_birth + "\n" +
        "4. Customer Email : " + email + "\n" +
        "5. Address : " + address + "\n" +
        "6. Province : " + province + "\n" +
        "7. VIP : " + vip + "\n" +
        // "8. Discount: " + discount +" $"+ "\n" +
        "9. Adult amount : " + adult + "\n" +
        "10. Child amount : " + child + "\n" +
        "11. Rent days : " + rent_days + "\n" +
        "12. Service : " + service + "\n" +
        "13. Room type : " + room_type + "\n" +
        "\n"
    );
}

let flag = true;
let flag_checking_email = true;
let flag_checking_dob = true;
let flag_checking_id = true;
// Hiện menu, luôn hiện menu
while (flag) {
    menu = prompt("Menu" + "\n" +
        "\n" +
        "1. Show Information Customer" + "\n" +
        "2. Edit Information Customer" + "\n" +
        "3. Show the amount to be paid after discount" + "\n" +
        "x. Exit\n"
    )
// switch các option của menu
    switch (menu) {
        case "1": // hiện thông tin khách hàng
            show_alert_infor();
            break;
        case "2": // edit thông tin khách hàng. edit nhận giá trị nhập vào, từ 1 đến 12 sẽ cho chỉnh sửa, còn default thì alert failed
            edit_information_customer();
            switch (edit) {
                case "1": // edit full name
                    edit_fullname = prompt("New Fullname :\n\n" +
                        "\n" +
                        "1. Customer Name : " + full_name + "\n" +
                        "\n"
                    );
                    full_name = formatString(edit_fullname);
                    show_alert_infor();
                    break;

                case "2": //edit id
                    do {
                        edit_id = prompt("New ID : \n\n" +
                            "\n" +
                            "2. Customer Identify : " + id_number + "\n" +
                            "\n"
                        );
                        flag_checking_id = checking_id_format(edit_id);
                    } while (flag_checking_id === false);
                    id_number = edit_id;
                    show_alert_infor();
                    break;
                case "3": //edit dob
                    do {
                        edit_dob = prompt("New Day Of Birth (YYYY-MM-DD) : \n\n" +
                            "\n" +
                            "3. Day Of Birth : " + day_of_birth + "\n" +
                            "\n"
                        );
                        flag_checking_dob = checking_dob_format(edit_dob);
                    } while (flag_checking_dob === false)
                    day_of_birth = edit_dob;
                    show_alert_infor();
                    break;
                case "4": //edit email *****error*****
                    do {
                        edit_email = prompt("New Email : (abc@abc.abc) \n\n" +
                            "\n" +
                            "4. Customer Email : " + email + "\n" +
                            "\n"
                        );
                        flag_checking_email = checking_email_format(edit_email);
                    } while (flag_checking_email === false);
                    email = edit_email;
                    show_alert_infor();
                    break;
                case "5": //edit address
                    edit_address = prompt("New Address : \n\n" +
                        "\n" +
                        "5. Address : " + address + "\n" +
                        "\n"
                    );
                    address = formatString(edit_address);
                    show_alert_infor();
                    break;
                case "6": //edit province
                    edit_province = prompt("New Province : \n\n" +
                        "\n" +
                        "6. Province : " + province + "\n" +
                        "\n"
                    );
                    province = edit_province;
                    show_alert_infor();
                    break;
                case "7": //edit vip
                    edit_vip = prompt("New VIP : \n\n" +
                        "\n" +
                        "7. VIP : " + vip + "\n" +
                        "\n"
                    );
                    vip = edit_vip;
                    show_alert_infor();
                    break;
                // case "8": //edit discount
                //     edit_discount = prompt("New Discount : \n\n" +
                //         "\n" +
                //         "8. Discount: " + discount + " $" + "\n" +
                //         "\n"
                //     );
                //     discount = edit_discount;
                //     show_alert_infor();
                //     break;
                case "9": //edit adult
                    do {
                        edit_adult = prompt("New Adult : \n\n" +
                            "\n" +
                            "9. Adult amount : " + adult + "\n" +
                            "\n"
                        );
                    } while (checking_positive_number(edit_adult) === false);
                    adult = edit_adult;
                    show_alert_infor();
                    break;
                case "10": //edit child
                    do {
                        edit_child = prompt("New Child : \n\n" +
                            "\n" +
                            "10. Child amount : " + child + "\n" +
                            "\n"
                        );
                    } while (checking_positive_number(edit_child) === false);
                    child = edit_child;
                    show_alert_infor();
                    break;
                case "11": //edit rentdays
                    do {
                        edit_rentdays = prompt("New Rent Days : \n\n" +
                            "\n" +
                            "11. Rent days : " + rent_days + "\n" +
                            "\n"
                        );
                    } while (checking_positive_number(edit_rentdays) === false);
                    rent_days = edit_rentdays;
                    show_alert_infor();
                    break;
                case "12": //edit service
                    edit_service = prompt("New Service : \n\n" +
                        "\n" +
                        "12. Service : " + service + "\n" +
                        "\n"
                    );
                    service = edit_service;
                    show_alert_infor();
                    break;
                case "13": //edit room type
                    edit_roomtype = prompt("New Room type : \n\n" +
                        "\n" +
                        "13. Room type : " + room_type + "\n" +
                        "\n"
                    );
                    room_type = edit_roomtype;
                    show_alert_infor();
                    break;
                default:
                    alert("Failed");
                    break;
            }
            break;
        case "3": //Hiện giá tiền sau
            alert("Show the amount to be paid after discount : " + payout.toFixed(2) + " $");
            break;
        case "x":
            flag = false;
            break;
        default:
            alert("Please enter the option of the menu!!!");
            break;
    }
    discount = (discount_by_vip + discount_by_day_amount + discount_by_province); //tổng số tiền discount
    payout = rent_days * sv - discount;
}