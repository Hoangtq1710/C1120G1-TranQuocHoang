package hackkerrank_method;

public class SumElementArray {
//    static int sumArray(int[] arr) {
//        int max = 0;
//        for (int i = 0; i < arr.length -1; i++) {
//            LinkedList<Integer> list = new LinkedList<>();
//            list.offer(arr[i]);
//            for (int j = (i +1); j < arr.length; j++) {
//                if (list.getLast() <= arr[j]) {
//                    list.offer(arr[j]);
//                } else {
//                    break;
//                }
//            }
//            if (list.size() > max) {
//                max = list.size();
//            }
//        }
//        return max;
//    }

    static int sumArray(int[] arr) {
        int max = 0;
        int indexI = 0;
        int indexJ = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = 0;
            if (arr[i] > 0) {
                temp += arr[i];
                for (int j = (i + 1); j < arr.length; j++) {
                    if (arr[j] > 0) {
                        temp += arr[j];
                        if (temp > max) {
                            indexI = i;
                            indexJ = j;
                            max = temp;
                        }
                    } else {
                        temp += arr[j];
                    }
                }
            }
        }

        for (int i = indexI; i <= indexJ; i++) {
            System.out.print(arr[i] + " ");
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("\n" + sumArray(array));
    }
}
