function convert() {
    let amount = document.getElementById(amount);

    let vnd = 1;
    let usd = 23000;
    let eur = 25000;

    let from_cur ;
    let to_cur ;

    switch (document.getElementById(from_cur)) {
        case 1: from_cur = vnd; break;
        case 2: from_cur = usd; break;
        case 3: from_cur = eur; break;
    }

    switch (document.getElementById(to_cur)) {
        case 1: to_cur = vnd; break;
        case 2: to_cur = usd; break;
        case 3: to_cur = eur; break;
    }

     let result = amount * from_cur / to_cur ;

    document.write(result);


//         ví dụ 20 , USD sand VND => result = 20*23000/1;
//         ví dụ 75000 , VND sang EUR => result = 75000*1/25000;
//         ví dụ 15 , EUR sang USD => result = 15 * 25000/23000;
}