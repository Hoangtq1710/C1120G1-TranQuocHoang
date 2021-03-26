package hackkerrank_method;

public class CavityMap {

    //grid = ['1112', '1912', '1892', '1234']
    // return = ['1112', '1X12', '18X2', '1234']


    static String[] cavityMap(String[] grid) {
        int n = grid.length;
        int[][] matrix = stringArrayToMatrix(grid);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != 0 && i != (n-1) && j != 0 && j != (n-1))) {
                    if (matrix[i][j] == max && matrix[i][j] > matrix[i-1][j] && matrix[i][j] > matrix[i+1][j] && matrix[i][j] > matrix[i][j-1] && matrix[i][j] > matrix[i][j+1]) {
                        matrix[i][j] = -1;
                    }
                }
            }
        }
        return matrixToStringArray(matrix);
    }

    static int[][] stringArrayToMatrix(String[] grid) { //convert a String Array to a int[][]
        int n = grid.length;
        int[][] matrix = new int[n][n];
        String[] str;


        for (int i = 0; i < n; i++) {
            str = grid[i].split("");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        return matrix;
    }

    static String[] matrixToStringArray(int[][] matrix){ //convert a int[][] to a String Array
        String[] strArray = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    str.append("X");
                    continue;
                }
                str.append(matrix[i][j]);
            }
            strArray[i] = str.toString();
        }
        return strArray;
    }

    public static void main(String[] args) {
        String[] grid = {"1112", "1912", "1892", "1234"};
        String[] result = cavityMap(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
