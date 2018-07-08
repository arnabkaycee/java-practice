package NQueensProblem;


import java.util.Scanner;

public class NQueensProblem {


    static boolean[][] board;
    static int n;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        board = new boolean[n][n];
        solveNQueens(board, 0);
        for (boolean[] row : board) {
            //System.out.println(Arrays.toString(row));
            for (boolean el : row){
                System.out.print(el?"Q ":". ");
            }
            System.out.print("\n");
        }
    }

    private static int queensOnBoard = 0;

    private static boolean solveNQueens(boolean[][] board, int level) {
        if (queensOnBoard == board.length) {
            return true;
        }
        for (int j = 0; j < n; j++) {
            //iterate through each column in a given row to try and place a queen
            board[level][j] = true;
            boolean isQueenSafe = checkSafeBoard(board, level, j);
            if (isQueenSafe) {
                //proceed to next level
                queensOnBoard++;
                if(!solveNQueens(board, level + 1)){
                    queensOnBoard--;
                    board[level][j] = false;
                }else {
                    return true;
                }
            } else {
                board[level][j] = false;
            }
        }
        //cannot place queen on the board at the given level
        return false;
    }

    private enum DIAGONAL_TYPE {L2R, R2L}

    private static int[] getDiagonalPosition(int level, int position, DIAGONAL_TYPE diagonal_type, int magnitude) {
        int endLevel = -1, endPosition = -1;
        if (diagonal_type == DIAGONAL_TYPE.L2R) {
            endLevel = level + magnitude;
            endPosition = position + magnitude;
        } else if (diagonal_type == DIAGONAL_TYPE.R2L) {
            endLevel = level + magnitude;
            endPosition = position - magnitude;
        }
        return new int[]{endLevel, endPosition};
    }

    private static boolean checkPositionInBoard(int x, int y) {
        return x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1;
    }

    private static boolean checkSafeBoard(boolean[][] board, int level, int position) {
        //check col
        for (int i = level - 1; i >= 0; i--) {
            if (board[i][position]) {
                return false;
            }
        }
        //check diagonal L2R
        int mag = 1;
        int calculatedLevelL2R, calculatedPositionL2R, calculatedLevelR2L, calculatedPositionR2L;
        while (true) {
            int[] retArr = getDiagonalPosition(level, position, DIAGONAL_TYPE.L2R, -mag);
            calculatedLevelL2R = retArr[0];
            calculatedPositionL2R = retArr[1];
            if (checkPositionInBoard(calculatedLevelL2R, calculatedPositionL2R)) {
                if (board[calculatedLevelL2R][calculatedPositionL2R]) {
                    return false;
                }
                mag++;
            } else {
                break;
            }
        }
        mag = 1;
        while (true) {
            int[] retArr;
            retArr = getDiagonalPosition(level, position, DIAGONAL_TYPE.R2L, -mag);
            calculatedLevelR2L = retArr[0];
            calculatedPositionR2L = retArr[1];
            if (checkPositionInBoard(calculatedLevelR2L, calculatedPositionR2L)) {
                if (board[calculatedLevelR2L][calculatedPositionR2L]) {
                    return false;
                }
                mag++;
            } else {
                break;
            }
        }
        return true;
    }

}
