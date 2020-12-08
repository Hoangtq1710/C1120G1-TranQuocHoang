
function sum_count() {
    let inputa = prompt('Nhập số a :');
    let inputb = prompt('Nhập số b');

    let a = parseFloat(inputa);
    let b = parseFloat(inputb);

    let sum = a + b ;

    document.write('Enter a : ');
    document.write('<br>');
    document.write(a);
    document.write('<br>');

    document.write('Enter b : ');
    document.write('<br>');
    document.write(b);
    document.write('<br>');

    document.write('Tổng hai số a và b là : ');
    document.write(sum);
}