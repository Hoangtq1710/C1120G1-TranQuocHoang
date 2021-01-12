//package extra_exercise.opp_module_1;
//
//public class MatrixByMrsVi {
//
//    public static int[][] transpose(int[][] array) {
//        int rows = array.length;
//        int columns = array[0].length;
//        int[][] tmpArray = new int[columns][rows];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                tmpArray[j][i] = array[i][j];
//            }
//        }
//        return tmpArray;
//    }
//
//    ​public static void sortArray(int[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[i]) {
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
//    }
//
//    public static int[][] sortInColumn(int[][] array) {
//        int[][] tmpArray = transpose(array);
//        for (int i = 0; i < tmpArray.length; i++) {
//            sortArray(tmpArray[i]);
//        }
//        return transpose(tmpArray);
//    }
//
//    public static void displayMatrix(int[][] array) {
//        for (int[] nums : array) {
//            for (int num : nums) {
//                System.out.print(num + "\t");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 1, -1, 2, 1},
//                {2, 3, -1, 4, 5},
//                {3, 2, -3, 7, 4},
//                {-1, 1, 2, -3, 1}
//        };
//        System.out.println("Matrix:");
//        displayMatrix(matrix);
//        System.out.println("Transpose:");
//        displayMatrix(transpose(matrix));
//        System.out.println("Matrix sorted in column:");
//        displayMatrix(sortInColumn(matrix));
//    }
//}
