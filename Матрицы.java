
public class Matrix {
    static void summMatrixes(int[][] matrix1, int[][] matrix2) {
        int[][] matrixSum = new int[matrix1.length][matrix1[0].length];
        for (int y = 0; y < matrix1.length; y++) {
            for (int x = 0; x < matrix1[y].length; x++) {
                int numMatrix1 = matrix1[y][x];
                int numMatrix2 = matrix2[y][x];
                int sum = numMatrix1 + numMatrix2;
                matrixSum[y][x] = sum;
            }
        }
        for (int y = 0; y < matrix1.length; y++) {
            for (int x = 0; x < matrixSum[y].length; x++) {
                System.out.printf("%5d ", matrixSum[y][x]);
            }
            System.out.println();
        }
    }
    
    static void Matrix_Multiply_On_Number(int[][] matrix1){
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(" " + matrix1[i][j]*2 + " "); //вывод элемента
            }
            System.out.println();
        }
    }
    
    static void Matrix_Print(int[][] matrix1) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(" " + matrix1[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void Matrix_Multiply(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[matrix1.length][matrix2[0].length];
        
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(matrix1, matrix2, row, col);
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(" " + result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int multiplyMatricesCell(int[][] matrix1, int[][] matrix2, int row, int col) {
        int cell = 0;
        for (int i = 0; i < matrix2.length; i++) {
            cell += matrix1[row][i] * matrix2[i][col];
            }
            return cell;
        }
    
public static void main(String[] args){
    int[][] matrix1 = {
                {10, 5, 12},
                {98, 5, 6},
                {8, 4, 6},
        };
        int[][] matrix2 = {
                {8, 7, 5},
                {19, 56, 4},
                {8, 76, 90},
        };
       summMatrixes(matrix1, matrix2);
       Matrix_Multiply_On_Number(matrix1);
       Matrix_Print(matrix1);
       Matrix_Multiply(matrix1, matrix2);
    }
        
}
