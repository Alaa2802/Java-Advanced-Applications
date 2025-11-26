import java.util.Arrays;

public class public class GeneralAssignment{
    public static void main(String[] args) {
        int[] genotype = {4, 2, 7, 3, 6, 8, 5, 1};
        displayBoard(genotype);
    }
    public static void displayBoard(int[] genotype) {
        int n = 8;
        char ch = '.';
        char[][] board = new char[n][n];
        for (char[] Line : board) {
            Arrays.fill(Line, ch);
        }
        for (int row = 0; row < n; row++) {
            int col = genotype[row] -1;
            board[row][col] = 'Q';
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}