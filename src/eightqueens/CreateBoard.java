/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueens;


public class CreateBoard {
    //Creates an 8x8 chess board that holds strings
    String[][] ChessBoard = new String[8][8];
   
    
        //I don't understand why this has an illegal start of expression
        /*
        //A loop to fill the 
        //entire thing with asterixes
        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                ChessBoard[i][y] = "*";

            }
        } */
    
    public void FillBoard(){
        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                ChessBoard[i][y] = "*";

            }
        }
    }
    
    public void PrintBoard(){
        //Print the whole thing out    
        for (int i = 0; i < 8; i++) {
            System.out.print("\n");
            for (int y = 0; y < 8; y++) {
                System.out.print(" " + ChessBoard[y][i]);
            }
        }
    }
}
