package TicTacToe;

public class Board {
    private int[][] board = new int[3][3];
    private boolean handshake = false;
    private boolean playerWon = false;

    public void setTile(int x, int y, int condition) {
        if(board[y][x] != 1 && board[y][x] != 2) {
            board[y][x] = condition;
            handshake = true;
        } else {
            System.out.println("That tile is already checked");
            handshake = false;
        }
    }

    public String condenseRC(int x, String condition) {
        String condensed = "";
        if(condition.equals("row")) {
            for(int i = 0; i < board[0].length; i++) {
                condensed = condensed + board[x][i];
            }
        } else if(condition.equals("column")) {
            for(int i = 0; i < board[0].length; i++) {
                condensed = condensed + board[i][x];
            }
        }
        return condensed;
    }

    public void checkWin() {
        String testCase;
        for(int i = 0; i < board[0].length; i++) {
            // Checking for row win
            testCase = condenseRC(i, "row");
            if(testCase.equals("111") || testCase.equals("222")) {
                playerWon = true;
            }
            //Checking for column win
            testCase = condenseRC(i, "column");
            if (testCase.equals("111") || testCase.equals("222")) {
                playerWon = true;
            }
            //Player 1 left diagonal win
            if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
                playerWon = true;
            }
            //Player 1 right diagonal win
            if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
                playerWon = true;
            }
            //Player 2 left diagonal win
            if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
                playerWon = true;
            }
            //Player 2 right diagonal win
            if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
                playerWon = true;
            }
        }
    }

    public void printBoard() {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                System.out.print(board[r][c] + "    ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public boolean getHandshake() {
        return handshake;
    }

    public void setHandshake(boolean condition) {
        handshake = condition;
    }

    public boolean getPlayerWon() {
        return playerWon;
    }
}