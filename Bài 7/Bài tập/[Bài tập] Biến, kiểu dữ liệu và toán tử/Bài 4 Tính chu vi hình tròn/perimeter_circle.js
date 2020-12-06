
function perimeter_circle() {
    let inputR = prompt('Please enter the radius of the circle');

    let R = parseFloat(inputR);

    let P = (2*R*3.14).toFixed(2);

    document.write('Enter R : ');
    document.write(R);
    document.write(' m');
    document.write('<br>');
    document.write('The perimeter of circle is : ' + P );
    document.write(' m');

}