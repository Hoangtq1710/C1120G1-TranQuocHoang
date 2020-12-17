//
// let checkId = prompt("Nhap ID : ");
// checking_id_format(checkId);

function checking_id_format(checkingId) {
    let flag = true;
    let int_number = ["0","1","2","3","4","5","6","7","8","9"];
    let count = 0;

    if (checkingId.length !== 9) {
        flag = false;
    } else {
        for (let i = 0; i < checkingId.length; i++) {

            for (let j = 0; j < int_number.length; j++) {
                if (checkingId[i] === int_number[j]) {
                    count++;
                }
            }
        }
        if (count !== 9) {
            flag = false;
        }
    }

    if (flag === true) {
        return true;
    }
    return false;
}