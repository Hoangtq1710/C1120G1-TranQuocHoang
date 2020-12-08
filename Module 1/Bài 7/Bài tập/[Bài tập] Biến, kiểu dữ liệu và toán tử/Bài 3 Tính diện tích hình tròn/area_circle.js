
function area_circle() {

    let inputR = prompt('Please enter radius of the circle');
    let R = parseFloat(inputR);

    let S = (3.14 * R * R).toFixed(2);

    document.write('Enter R : ');
    document.write(R);
    document.write(' m');
    document.write('<br>');
    document.write('The area of circle is : ' + S );
    document.write(' m2');
}