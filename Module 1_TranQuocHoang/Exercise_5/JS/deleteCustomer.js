function deleteCustomer() {
    let flagDeleteID = true;
    let inputDeleteId = prompt("Enter the ID of Customer you wanna delete :");

    for (let i = 0; i < arrListCustomer.length; i++) {
        for (let j = 0; j < arrListCustomer[i].length; j++) {
            if (inputDeleteId === arrListCustomer[i][1]) {
                index = i;
                flagDeleteID = false;
            }
        }
    }
    if (flagDeleteID === false) {
        arrListCustomer.splice(index,1);
        alert("Done!");
    } else {
        alert("Wrong ID!! Please check again!");
    }
}