
function average_point() {
    let inputPhy = prompt('Please enter the Physics point');
    let inputChe = prompt('Please enter the Chemistry point');
    let inputBio = prompt('Please enter the Biology point');

    let Phy = parseInt(inputPhy);
    let Che = parseInt(inputChe);
    let Bio = parseInt(inputBio);

    let average = ((Phy+Che+Bio)/3).toFixed(2);
    /* Hậu tố .toFixed(2) giúp làm tròn số thực trong biểu thức
     về tối đa 2 chữ số thập phân sau dấu chấm */

    document.write('Enter the Physics : ');
    document.write(Phy);
    document.write('<br>');

    document.write('Enter the Chemistry : ');
    document.write(Che);
    document.write('<br>');

    document.write('Enter the Biology : ');
    document.write(Bio);
    document.write('<br>');
    document.write('<br>');

    document.write('Your average point is : ' + average);
}