
function rectangle_area() {
    let inputWidth = prompt('Enter the width');
    let inputHeight = prompt('Enter the height');

    let width = parseInt(inputWidth);
    let height = parseInt(inputHeight);

    let area = width * height;


    document.write('Enter width :');
    document.write('<br>');
    document.write(width);
    document.write('<br>');

    document.write('Enter height :');
    document.write('<br>');
    document.write(height);
    document.write('<br>');

    document.write('The area is ' + area);
}