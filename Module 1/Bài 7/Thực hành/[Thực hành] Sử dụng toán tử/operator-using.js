
function rectangle_area() {
    let inputWidth = prompt('Enter the width');
    let inputHeight = prompt('Enter the height');

    let width = parseInt(inputWidth);
    let height = parseInt(inputHeight);

    let area = width * height;
    let c =width+height+"8";

    document.write('Enter width :');
    document.write('<br>');
    document.write(width);
    document.write('<br>');

    document.write('Enter height :');
    document.write('<br>');
    document.write(height);
    document.write('<br>');

    document.write(c);

    document.write('The area is ' + area);
}