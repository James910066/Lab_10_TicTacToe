import java.util.Scanner; //Import of Scanner
public class TicTacToe
{    private static final int ROW = 3; //Global variable for index size
    private static final int COL = 3; //Global variable for index size
    private static String board[][] = new String[ROW][COL]; //Global variable for 2d array on constructing game board
    private static int moveCount; //Global variable to track game moves and used to determine which player is which
    private static int moveChoice; //Glabal variable on what each player inputs for move position
    //private static int player;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);//Scanner variable assignment
        boolean done; //Variable used for main game loop
        String move; //Variable used for either players move such as X or O
        boolean winnerOrTie; //Variable used for inner game loop for main game play

        do //Start of main game loop
        {    clearBoard(); //Clear board of previous game for new game
                moveCount = 0; //Reset move count for new game
            do //Start of inner game loop
            {   boolean goodMove; //isValidMove method result is assigned to this variable
                boolean xValue; //Variable is used for isWinner method to check if player X is a winner
                boolean oValue; //Variable is used for isWinner method to check if player O is a winner
                winnerOrTie = false; //Used for do while inner game loop for determining if game continues if no winner is determined
                System.out.println("Here are your board placement choices"); //Output message to players for game board move choices
                boardChoices(); //Show choices on a board that user can choose for their move
                System.out.println("Current game board"); //Output message to players for actual game board with current moves played
                showBoard(); //This method displays game board with current moves played
                do //Start of loop for checking players moves
                {
                    int xIndex; //Variable used for row coordinate of array index
                    int yIndex; //Variable used for col coordinate of array index
                    moveChoice = SafeInput.getRangedInt(in, "Choose a number spot for your move: 1-9 ", 1, 9); //Calling method to get players move choice and verify it
                    if(moveChoice == 1) //Check if players move choice matches grid 1 of the board
                        {
                            xIndex = 0; //Variable assignment of row index coordinate
                            yIndex = 0; //Variable assignment of col index coordinate
                        }
                    else if (moveChoice == 2) //Check if players move choice matches grid 2 on the board
                        {
                            xIndex = 0; //Variable assignment of row index coordinate
                            yIndex = 1; //Variable assignment of col index coordinate
                        }
                    else if (moveChoice == 3) //Check if players move choice matches grid 3 on the board
                        {
                            xIndex = 0; //Variable assignment of row index coordinate
                            yIndex = 2; //Variable assignment of col index coordinate
                        }
                    else if (moveChoice == 4) //Check if players move choice matches grid 4 on the board
                        {
                            xIndex = 1; //Variable assignment of row index coordinate
                            yIndex = 0; //Variable assignment of col index coordinate
                        }
                    else if (moveChoice == 5) //Check if players move choice matches grid 5 on the board
                        {
                            xIndex = 1; //Variable assignment of row index coordinate
                            yIndex = 1; //Variable assignment of col index coordinate
                        }
                    else if (moveChoice == 6) //Check if players move choice matches grid 6 on the board
                        {
                            xIndex = 1; //Variable assignment of row index coordinate
                            yIndex = 2; //Variable assignment of col index coordinate
                        }
                    else if (moveChoice == 7) //Check if players move choice matches grid 7 on the board
                        {
                            xIndex = 2; //Variable assignment of row index coordinate
                            yIndex = 0; //Variable assignment of col index coordinate
                        }
                    else if (moveChoice == 8) //Check if players move choice matches grid 8 on the board
                        {
                            xIndex = 2; //Variable assignment of row index coordinate
                            yIndex = 1; //Variable assignment of col index coordinate
                        }
                    else //Finally move choice has to be grid 9 on the board
                        {
                            xIndex = 2; //Variable assignment of row index coordinate
                            yIndex = 2; //Variable assignment of col index coordinate
                        }
                    goodMove = isValidMove(xIndex,yIndex); //Call method to check players move choice to see if that number on the board grid has not been played yet.
                    if(!goodMove) //If isValidMove returns false then this executes
                        {
                            System.out.println("Spot is taken. Choose another board position"); //Output to player to choose another position that is available
                        }
                }while(!goodMove); //Keeps looping to ask player for valid move until it is valid
                getPlayerMove(moveChoice); //Calls method to get players choice from the board grid for move placement
                moveCount = moveCount + 1; //Incremented 1 for each player's turn to determine if player is X or O and also for determining a tie
                if(moveCount >= 5) //Threshold used to start checking if either player has won the game
                {
                    xValue = isWinner("X"); //Call method to check if player X has won the game
                    if(xValue == true) //Execute this block if Player X won the game
                    {
                        System.out.println("Congrats player X you win!!"); //Output to both players that player X won
                        winnerOrTie = true; //Reset variable to stop inner game loop. Based on if players play again or quit
                    }
                    oValue = isWinner("O"); //Call method to check if player O has won the game
                    if(oValue == true) //Execute this block if Player O won the game
                    {
                        System.out.println("Congrats player O you win!!"); //Output to both players that player O won
                        winnerOrTie = true; //Reset variable to stop inner game loop. Based on if players play again or quit
                    }
                    if(moveCount == 9) //Execute this block if no player has won and there are no moves left on the board
                    {
                        System.out.println("Tie Game!"); //Output to both players that the game is a tie
                        winnerOrTie = true; //Reset variable to stop inner game loop. Based on if players play again or quit
                    }
                }
            } while (!winnerOrTie); //Keeps looping until someone wins or game ends in a tie
            done = SafeInput.getYNConfirm(in, "Do you want to play again?"); //Call method to ask players if they want to play game again
        } while (!done); //Keeps looping until if players confirm Yes to play again. Otherwise loop stops on No
    }
    //Check for Valid move method
    private static boolean isValidMove(int row, int col) //Method for checking player's move choice
        {
            boolean retVal = board[row][col].equals(" ");//Check to see if coordinate is a space
            return retVal; //Boolean value returned to main method
        }
    //Method to show the board
    private static void showBoard() //Method to display gameboard to players
        {
            System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]); //Displays first row of grid for game board with spaces or player moves
            System.out.println("-+-+-"); //Used as part of visual creation of the game board
            System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]); //Displays second row of grid for game board with spaces or player moves
            System.out.println("-+-+-"); //Used as part of visual creation of the game board
            System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]); //Displays third row of grid for game board with spaces or player moves
        }
    //Method to clear the moves for the board for new game
    private static void clearBoard() //Method that sets all the board elements to a space
    {
        for (int row = 0; row < ROW; row++) //Loops 3 times through array for row to remove players moves and nulls on initial start of a game
            {
                for (int col = 0; col < COL; col++) //Loops 3 times through array for col to remove players moves and nulls on initial start of a game
                    {
                        board[row][col] = " "; //Make this cell a space
                    }
            }
    }
    //2D array showing the board with numeric choices for moves
    private static void boardChoices() //Method to display number coordinates for choosing a move on actual game board
    {
        String[][] boardChoices = //2D array creation
                {
                        {"1", "2", "3"}, //String literal 2d array
                        {"4", "5", "6"},
                        {"7", "8", "9"}
                };
//        boardChoices[0][0] = "1"; //These set of lines are technically not needed
//        boardChoices[0][1] = "2"; //So I left these in to show the actual index coordinates and what their value is
//        boardChoices[0][2] = "3";
//        boardChoices[1][0] = "4";
//        boardChoices[1][1] = "5";
//        boardChoices[1][2] = "6";
//        boardChoices[2][0] = "7";
//        boardChoices[2][1] = "8";
//        boardChoices[2][2] = "9";
        System.out.println(boardChoices[0][0] + "|" + boardChoices[0][1] + "|" + boardChoices[0][2]); //Displays first row of grid for game board with move choices
        System.out.println("-+-+-"); //Used as part of visual creation of the game board
        System.out.println(boardChoices[1][0] + "|" + boardChoices[1][1] + "|" + boardChoices[1][2]); //Displays second row of grid for game board with move choices
        System.out.println("-+-+-"); //Used as part of visual creation of the game board
        System.out.println(boardChoices[2][0] + "|" + boardChoices[2][1] + "|" + boardChoices[2][2]); //Displays third row of grid for game board with move choices
    }
    //CHECK FOR WINNER METHODS
    private static boolean isWinner(String player) //Method that calls 3 other methods (method chaining) to check if a player is a winner
    {
        if(isRowWin(player) || isDiagWin(player) || isColWin(player)) //Calling 3 sub methods
            {
                return true; //Boolean value returned to main method. Found winner
            }
        return false; //Boolean value returned to main method. No winner for current player being checked
    }
//Winner sub-methods
    private static boolean isRowWin(String player) //A sub-method to isWinner to check for a row winner
    {
        for(int row = 0; row < board.length; row++) //Loops the length of the array
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) //Checks to see if 3 row positions are all X or O
                {
                    return true; //Boolean value returned to main method. Found winner
                }
        }
        return false; //Boolean value returned to main method. No row winner for current player being checked
    }
    private static boolean isColWin(String player) //A sub-method to isWinner to check for a column winner
    {
        for(int col= 0; col < COL; col++) //Loops for each column in array
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) //Checks to see if 3 column positions are all X or O
                {
                    return true; //Boolean value returned to main method. Found winner
                }
        }
        return false; //Boolean value returned to main method. No column winner for current player being checked
    }
    //Check for diagonal win
    private static boolean isDiagWin(String player) //A sub-method to isWinner to check for a diagonal winner
    {
        //Checks to see if 3 board positions diagonally either direction  are all X's or O's
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
            {
                return true; //Boolean value returned to main method. Found winner
            }
        else
            {
                return false; //Boolean value returned to main method. No diagonal winner for current player being checked
            }
    }
    private static void getPlayerMove(int moveChoice) //Method that uses moveCount to determine player X or O and place move on game board
    {
        String move = ""; //Intializing variable to empty string
        if (moveCount % 2 == 0) //Check if move counter is even or odd. Since X always goes first then it will always be even.
            {
                move = "X"; // Variable assigment of player X
            }
        else //if move counter is odd then player O
            {
                move = "O"; //Variable assignment of player O
            }
    switch (moveChoice) //Switch case used for placement of players move on board
    {
        case 1: //If player chooses number 1
            board[0][0] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 2: //If player chooses number 2
            board[0][1] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 3: //If player chooses number 3
            board[0][2] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 4: //If player chooses number 4
            board[1][0] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 5: //If player chooses number 5
            board[1][1] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 6: //If player chooses number 6
            board[1][2] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 7: //If player chooses number 7
            board[2][0] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 8: //If player chooses number 8
            board[2][1] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
        case 9: //If player chooses number 9
            board[2][2] = move; //Sets players move to game board coordinate in 2d array.
            break; //Stop switch case since players move has been placed
    }
}

}
