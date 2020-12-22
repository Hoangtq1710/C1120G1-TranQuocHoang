function deleteCustomer() {
    let flag_deleteID = true;
    let input_delete_id = prompt("Enter the ID of Customer you wanna delete :");

    for (let i = 0; i < arrListCustomer.length; i++) {
        for (let j = 0; j < arrListCustomer[i].length; j++) {
            if (input_delete_id === arrListCustomer[i][1]) {
                index = i;
                flag_deleteID = false;
            }
        }
    }
    if (flag_deleteID === false) {
        arrListCustomer.splice(index,1);
        alert("Done!");
    } else {
        alert("Wrong ID!! Please check again!");
    }
}