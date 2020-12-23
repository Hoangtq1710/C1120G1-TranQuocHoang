function displayOne(i) {
    let print = "1. Customer Name : " + arrListCustomer[i][0] + "\n" +
                "2. Customer Identify : " + arrListCustomer[i][1] + "\n" +
                "3. Day Of Birth : " + arrListCustomer[i][2] + "\n" +
                "4. Customer Email : " + arrListCustomer[i][3] + "\n" +
                "5. Address : " + arrListCustomer[i][4] + "\n" +
                "6. Province : " + arrListCustomer[i][5] + "\n" +
                "7. VIP : " + arrListCustomer[i][6] + "\n" +
                "8. Discount: " + arrListCustomer[i][7] +" %"+ "\n" +
                "9. Adult amount : " + arrListCustomer[i][8] + "\n" +
                "10. Child amount : " + arrListCustomer[i][9] + "\n" +
                "11. Rent days : " + arrListCustomer[i][10] + "\n" +
                "12. Service : " + arrListCustomer[i][11] + "\n" +
                "13. Room type : " + arrListCustomer[i][12] + "\n"
                // "14. Payout : " + arrListCustomer[i][13] + " $\n";
    ;
    return print;
}
function displayInforCustomer() {
    for (let i = 0; i < arrListCustomer.length; i++) {
        alert(displayOne(i));
    }
}