import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();
        // Заповнення матриці випадковими числами від 1 до 50
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }
        // Виведення матриці
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
        // Розрахунок сум для парних та непарних рядків
        int evenRowSum = 0, oddRowSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }
        // Розрахунок добутків для парних та непарних стовпців
        long evenColProduct = 1, oddColProduct = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    evenColProduct *= matrix[i][j];
                } else {
                    oddColProduct *= matrix[i][j];
                }
            }
        }
        // Виведення результатів
        System.out.println("\nСума елементів у парних рядках (рядок 0, 2): " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + oddRowSum);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + evenColProduct);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + oddColProduct);
        // Перевірка, чи є матриця магічним квадратом
        boolean isMagicSquare = checkMagicSquare(matrix);
        System.out.println("\nМатриця " + (isMagicSquare ? "є" : "не є") + " магічним квадратом.");
    }
    private static boolean checkMagicSquare(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        // Обчислення суми першого рядка
        for (int j = 0; j < n; j++) {
            sum += matrix[0][j];
        }
        // Перевірка сум рядків
        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != sum) {
                return false;
            }
        }
        // Перевірка сум стовпців
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != sum) {
                return false;
            }
        }
        // Перевірка сум діагоналей
        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < n; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][n - 1 - i];
        }
        return diag1Sum == sum && diag2Sum == sum;
    }
}
