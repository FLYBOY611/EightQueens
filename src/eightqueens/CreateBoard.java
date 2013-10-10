/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueens;

import java.util.Scanner;

public class CreateBoard {
    //Creates an 8x8 chess board that holds strings

    String[][] ChessBoard = new String[8][8];

    //Create the board and fill it with asterixes 
    public void FillBoard() {
        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                ChessBoard[i][y] = "*";

            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter in the X cordinate"
                + " of the first Queen");
        int FirstX = input.nextInt();
        System.out.println("Please enter in the Y cordinate");
        int FirstY = input.nextInt();

        //Puts down the first Queen
        ChessBoard[FirstX][FirstY] = "Q";

        PlaceAQueen(FirstX, FirstY);


    }

    //The start of our recursion
    public boolean PlaceAQueen(int Xstart, int Ystart) {
        //int CountStart = Xstart;
        int RowSpot = 0;
        boolean KeepGoing = false;

        if (Ystart == ChessBoard.length) {
            return true;
        } else {
            while (RowSpot < ChessBoard.length && !KeepGoing == true) {
                //If the spot is a threat, 
                //test the next spot to put a Queen
                if (IsAThreat(RowSpot, Ystart) == true) {
                    RowSpot++;
                } else {
                    //If its not a threat then
                    //Place a Queen and do recursion
                    //to try and place another Queen in next column.
                    ChessBoard[RowSpot][Ystart] = "Q";
                    KeepGoing = PlaceAQueen(RowSpot, Ystart + 1);

                    /*     //BACKTRACKING
                     //Remove the Queen 
                     if (KeepGoing == true) {                       
                     ChessBoard[RowSpot][Ystart] = "*";
                     RowSpot++;
                     }  */

                }
            }
            return KeepGoing;
        }
    }

    //Determine if the new piece threatens another
    public boolean IsAThreat(int row, int column) {

        //Test the row threat
        for (int i = 0; i < ChessBoard.length; i++) {
            if (ChessBoard[row][i] == "Q") {
                return true;
            }
        }
        
        //Test the diagonal threat trending upwards
        for (int i = 0; i < ChessBoard.length; i++) {
            if (row+i >= ChessBoard.length
                    || column+i >= ChessBoard.length){
                break;
            }
            if (ChessBoard[row+i][column+i] == "Q") {
                return true;
            }
        }
        
        
        return false;
    }

    //Print the whole thing out 
    public void PrintBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print("\n");
            for (int y = 0; y < 8; y++) {
                System.out.print(" " + ChessBoard[y][i]);
            }
        }
    }
}


/*
 Hint: to determine whether setting q[n] = i conflicts with q[0] through q[n-1] 
 if q[i] equals q[n]: two queens are placed in the same column
 if q[i] - q[n] equals n - i: two queens are on same major diagonal
 if q[n] - q[i] equals n - i: two queens are on same minor diagonal 
 */