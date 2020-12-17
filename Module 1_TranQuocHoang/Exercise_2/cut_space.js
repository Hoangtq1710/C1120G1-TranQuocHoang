
// let uncut_name = prompt("Nhap ten cua ban");
// document.write(cut_space(uncut_name));

function cut_space(uncutString) {
    let trimString = uncutString.trim();
    let a = [];
    let b = [];

    for (let i = 0; i < trimString.length; i++) {
        b[i] = trimString[i];
    }

    for (let i = 0; i < b.length; i++) {
        if ((b[i] === " ") && (b[i+1] === " ")) {
            b.splice((i),1);
            i--;
        }
        a[i] = b[i];
    }

    for (let i = 0; i < a.length; i++) {
        a[0] = a[0].toUpperCase();
        if (a[i] === " ") {
            a[i+1] = a[i+1].toUpperCase();
        }
    }

    return a.join("");

}
