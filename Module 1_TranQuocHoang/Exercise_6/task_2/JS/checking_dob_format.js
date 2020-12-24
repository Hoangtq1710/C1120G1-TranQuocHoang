// let checkingDob = prompt("DOB YYYY-MM-DD");
// if (checking_dob_format(checkingDob)) {
//     alert("DUNG");
// } else {
//     alert("SAI");
// }
// 1992-04-21

function checking_dob_format(checkingDob) {
    let flag = true;
    if (checkingDob.length !== 10) {
        flag = false;
    } else {

        if (checkingDob[4] !== "-" || (checkingDob[7] !== "-")) {
            flag = false;
        }


        let year = parseInt(checkingDob.slice(0,4));
        let month = parseInt(checkingDob.slice(5,7));
        let day = parseInt(checkingDob.slice(8,10));

        if ((year * 0 !== 0) && (month * 0 !== 0) && (day * 0 !== 0)) {
            flag = false;
        }

        if (year <= 1900 || year > 2020 || month <= 0 || month > 12 || day <= 0 || day > 31) {
            flag = false;
        } else if ((month === 2) && (day > 29)) {
            flag = false;
        } else if (((month === 4) || (month === 6) || (month === 9) || (month === 11)) && (day > 30)) {
            flag = false;
        }
    }

    if (flag === true) {
        return true;
    }
    return false;
}