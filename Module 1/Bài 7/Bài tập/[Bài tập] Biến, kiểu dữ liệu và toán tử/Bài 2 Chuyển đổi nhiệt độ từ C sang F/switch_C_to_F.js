
function switch_C_to_F() {
    let inputC = prompt('Please enter the number of C degree');
    let C = parseFloat(inputC);

    let F = ((9*C+32*5)/5).toFixed(2);
//        F = (9C+32*5)/5

    document.write('Enter C degree : ');
    document.write(C);
    document.write(' °C');
    document.write('<br>');
    document.write('F degree is ' + F);
    document.write(' °F');
}