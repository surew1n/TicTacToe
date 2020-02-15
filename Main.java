package TicTacToe;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int curPlayer = (int) (Math.random() * 2 + 1);
        int playerX = -1;
        int playerY = -1;
        Scanner userScan = new Scanner(System.in);
        Board mainBoard = new Board();

        mainBoard.printBoard();

        while(mainBoard.getPlayerWon() == false) {
            System.out.println("It is player " + curPlayer + "'s turn");
            while(mainBoard.getHandshake() == false) {
                while(playerX != 0 && playerX != 1 && playerX != 2) {
                    System.out.println("What is the x of the tile do you want to mark? (1-3)");
                    try {
                        playerX = userScan.nextInt() - 1;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number");
                        userScan.nextLine();
                    }
                }
                while(playerY != 0 && playerY != 1 && playerY != 2) {
                    System.out.println("What is the y of the tile do you want to mark? (1-3)");
                    try {
                        playerY = userScan.nextInt() - 1;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number");
                        userScan.nextLine();
                    }
                }
                mainBoard.setTile(playerX, playerY, curPlayer);

                if(mainBoard.getHandshake() == false) {
                    playerX = -1;
                    playerY = -1;
                }
            }
            mainBoard.checkWin();
            mainBoard.printBoard();

            //Reset values
            playerX = -1;
            playerY = -1;
            mainBoard.setHandshake(false);

            if(curPlayer == 1) {
                curPlayer = 2;
            } else {
                curPlayer = 1;
            }
        }

        if(curPlayer == 1) {
            System.out.println("The winner is player 2");
        } else if(curPlayer == 2) {
            System.out.println("The winner is player 1");
        }
    }
}