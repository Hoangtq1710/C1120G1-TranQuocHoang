
let email = prompt("Email:");
let op = checking_email_format(email);

function checking_email_format(checkingEmail) {
    let count_dot = 0;
    let count_at = 0;
    let flag = true;
    for (let i = 0; i < checkingEmail.length; i++) {
        if (checkingEmail[i] ==="@") {
            count_at++;
            let dot_after_at = 0;
            for (let j = i + 1; j < checkingEmail.length - 1; j++) {
                if (checkingEmail[j] === ".") {
                    dot_after_at++;
                }
            }
            if (dot_after_at !== 1) {
                flag = false;
            }
        }

        if (checkingEmail[i] === ".") {
            count_dot++;
            if (i === 0 || i === checkingEmail.length - 1) {
                flag = false;
            } else if (checkingEmail[i+1] === ".") {
                flag = false;
            }
        }
        if (checkingEmail[i] === " ") {
            flag = false;
        }
    }
    if (count_at !== 1) {
        flag = false;
    }
    if (count_dot < 1) {
        flag = false;
    }

    if (flag === true) {
        alert("Dung");
        return true;
    }
    alert("Sai");
    return false;
}
