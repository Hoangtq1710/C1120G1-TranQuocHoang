package session_13.practice.binary_search_no_recursive;

public class BinarySearch {
    static int[] list = {2,4,5,6,7,9,10,12,15,16,18,19,25,29,40,45,48,60,75};

    static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length -1;

        while (high >= low) {
            int mid = (low + high) /2;
            if (value < array[mid]) {
                high = mid -1;
            } else if (value > array[mid]){
                low = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 64));
        System.out.println(binarySearch(list, 15));
        System.out.println(binarySearch(list, 13));
        System.out.println(binarySearch(list, 75));
    }
}
