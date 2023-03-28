import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        String boardChoices[][] = new String[ROW][COL];
        Scanner in = new Scanner(System.in);
        int moveChoice = 0;
        boolean done = false;
        int moveCount = 0;
        boolean haveWinner = false;
        String move;
        int moveCheck;

        do {
            clearBoard(); //Clear board of previous game for new game
            moveCount = 0; //Reset move count for new game
            do {
                boolean goodMove = false;
                //boolean invalidMove = false;
                System.out.println("Here are your board placement choices");
                boardChoices(); //Show choices on a board that user can choose for their move
                //System.out.println();
                System.out.println("Current game board");
                showBoard();
                do {
                    int x;
                    int y;
                    moveChoice = SafeInput.getRangedInt(in, "Choose a number spot for your move: 1-9 ", 1, 9);
                    x = moveChoice -1;
                    y = moveChoice -1;

                    System.out.println(board[x][y]);
                    goodMove = isValidMove(x, y);
                    if(!goodMove)
                    {
                        System.out.println("Spot is taken. Choose another board position");
                    }
                    else {
                        goodMove = true;
                    }
                }while(!goodMove);

                if (moveCount % 2 == 0) //Check if move counter is even or odd. Since X always goes first then it will always be even.
                {
                    move = "X"; // Variable assigment of player X
                } else //if move counter is odd then player O
                {
                    move = "O"; //Variable assignment of player O
                }
                //Placement of X or O
                switch (moveChoice) {
                    case 1:
                        board[0][0] = move;
                        break;
                    case 2:
                        board[0][1] = move;
                        break;
                    case 3:
                        board[0][2] = move;
                        break;
                    case 4:
                        board[1][0] = move;
                        break;
                    case 5:
                        board[1][1] = move;
                        break;
                    case 6:
                        board[1][2] = move;
                        break;
                    case 7:
                        board[2][0] = move;
                        break;
                    case 8:
                        board[2][1] = move;
                        break;
                    case 9:
                        board[2][2] = move;
                        break;
                }
                moveCount = moveCount + 1;
            } while (!haveWinner);
            System.out.println("You played Tic Tac Toe");
            done = SafeInput.getYNConfirm(in, "Do you want to play again?");
        } while (!done);

    }

    //Methods go below here
    //Check for Valid move method
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if (board[row][col].equals(" ")) //Check to see if coordinate is a space
            retVal = true;
        return retVal;
    }

    //    //Method to show the board
    private static void showBoard() {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    //Method to clear the moves for the board for new game
    private static void clearBoard() //Sets all the board elements to a space
    {   //final int ROW = 0;
        //final int COL = 0;
        //String [][] board = new String[3][3];
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " "; //Make this cell a space
            }
        }
    }

    //2D array showing the board with numeric choices for moves
    private static void boardChoices() {
        String[][] boardChoices =
                {{" ", " ", " "},
                        {" ", " ", " "},
                        {" ", " ", " "}};

        //String [][] tttBoard = new String[X] [O];
        boardChoices[0][0] = "1";
        boardChoices[0][1] = "2";
        boardChoices[0][2] = "3";
        boardChoices[1][0] = "4";
        boardChoices[1][1] = "5";
        boardChoices[1][2] = "6";
        boardChoices[2][0] = "7";
        boardChoices[2][1] = "8";
        boardChoices[2][2] = "9";

        System.out.println(boardChoices[0][0] + "|" + boardChoices[0][1] + "|" + boardChoices[0][2]);
        System.out.println("-+-+-");
        System.out.println(boardChoices[1][0] + "|" + boardChoices[1][1] + "|" + boardChoices[1][2]);
        System.out.println("-+-+-");
        System.out.println(boardChoices[2][0] + "|" + boardChoices[2][1] + "|" + boardChoices[2][2]);
    }

    //CHECK FOR WINNER METHODS
//    private static boolean isWinner(String player)
//    {
//        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player)) //Calling 3 sub methods
//        {
//            return true;
//        }
//        return false;
//    }
//Winner sub-methods
//    private static boolean isRowWin(String player)
//    {
//        final int ROW = 0;
//        for(int row = 0; row < ROW; row++)
//        {
//            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
//            {
//                return true;
//            }
//        }
//        return false; //no row win
//    }
//    private static boolean isColWin(String player)
//    {
//        final int COL = 0;
//        for(int col= 0; col < COL; col++)
//        {
//            if(board[col][0].equals(player) && board[col][1].equals(player) && board[col][2].equals(player))
//            {
//                return true;
//            }
//        }
//        return false; // no col win
//    }
    //Check for diagonal win
//    private static boolean isDiagWin(String player)
//    {
//        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
//        {
//            return true;
//        }
//        else
//        {
//            return false; //no diagonal win
//        }
//    }
    //CHECK FOR TIE METHOD


}