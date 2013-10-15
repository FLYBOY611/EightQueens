package eightqueens;

import java.util.Scanner;

public class CreateBoard {
    //Creates an 8x8 chess board that holds strings
    String[][] ChessBoard = new String[8][8];

    //Fill the board with asterixes 
    public void FillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                ChessBoard[i][y] = "*";

            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("REMEMBER: all values must be 0-7");
        System.out.println("Please enter in the X cordinate"
                + " of the first Queen");
        int FirstX = input.nextInt();
        System.out.println("Please enter in the Y cordinate");
        int FirstY = input.nextInt();

        //Puts down the first Queen
        ChessBoard[FirstX][FirstY] = "Q";
        //Start the program at 0,0
        PlaceAQueen(0, 0);


    }

    //The start of our recursion
    public boolean PlaceAQueen(int Xstart, int Ystart) {
        int VerticalSpot = 0;
        boolean KeepGoing = false;

        if (Xstart == ChessBoard.length) {
            return true;
        } else {
            while (VerticalSpot < ChessBoard.length && !KeepGoing == true) {
                //If the board detects the column has a threat
                if (ColumnThreat(Xstart, VerticalSpot) == true) {
                    //We skip that column and return the vertical to zero
                    KeepGoing = PlaceAQueen(Xstart + 1, VerticalSpot);
                    break;
                }
                //Test the other threat methods
                if (IsAThreat(Xstart, VerticalSpot) == true) {
                    //Iterate up the vertical to test the other threats
                    VerticalSpot++;
                } else {
                    //If its not a threat then place a Queen                   
                    ChessBoard[Xstart][VerticalSpot] = "Q";
                    //Move to the next column, reset vertical to zero
                    KeepGoing = PlaceAQueen(Xstart + 1, VerticalSpot);

                    //Remove the Queen 
                    if (KeepGoing == false) {
                        ChessBoard[Xstart][VerticalSpot] = "*";
                        VerticalSpot++;
                    }

                }
            }
            return KeepGoing;
        }
    }

    //Test the column threat
    public boolean ColumnThreat(int row, int column) {

        for (int i = 0; i < ChessBoard.length; i++) {
            if (ChessBoard[row][i].equals("Q")) {
                return true;
            }
        }
        return false;
    }

    //Determine if the new piece threatens another
    public boolean IsAThreat(int row, int column) {

        //Test the row threat
        for (int i = 0; i < ChessBoard.length; i++) {
            if (ChessBoard[i][column].equals("Q")) {
                return true;
            }
        }

        //Test the diagonal threat trending upward right
        for (int i = 0; i < ChessBoard.length; i++) {
            if (row + i >= ChessBoard.length
                    || column + i >= ChessBoard.length) {
                break;
            }
            if (ChessBoard[row + i][column + i].equals("Q")) {
                return true;
            }
        }

        //Test the diagonal threat trending downward right
        for (int i = 0; i < ChessBoard.length; i++) {
            if (row + i >= ChessBoard.length
                    || column - i < 0) {
                break;
            }
            if (ChessBoard[row + i][column - i].equals("Q")) {
                return true;
            }
        }

        //Test the diagonal threat trending upward left
        for (int i = 0; i < ChessBoard.length; i++) {
            if (row - i < 0
                    || column + i >= ChessBoard.length) {
                break;
            }
            if (ChessBoard[row - i][column + i].equals("Q")) {
                return true;
            }
        }

        //Test the diagonal threat trending downward left
        for (int i = 0; i < ChessBoard.length; i++) {
            if (row - i < 0
                    || column - i < 0) {
                break;
            }
            if (ChessBoard[row - i][column - i].equals("Q")) {
                return true;
            }
        }


        return false;
    }

    //Print the whole thing out 
    public void PrintBoard() {
        for (int y = 7; y >= 0; y--) {
            System.out.print("\n");
            for (int x = 0; x < 8; x++) {
                System.out.print(" " + ChessBoard[x][y]);
            }
        }
    }
}
/*CURRENT DESIGN PLANS:
 * 
 * Start the program running at space 0,0
 * Check the current column to see if a threat exists
 * If yes, then call recursion and skip that column because only one 
 * Queen per column may exist. If no then check all other methods of threat.
 * If another threat THAT IS NOT A COLUMN TYPE exists then iterate up the
 * column checking each space. If a perfectly clean space is found then place
 * the Queen and call recursion to move one column over
 */
