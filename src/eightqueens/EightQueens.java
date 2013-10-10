package eightqueens;

import java.util.Scanner;

public class EightQueens {

    

    public static void main(String[] args) {
        CreateBoard Board = new CreateBoard();
        Board.FillBoard();
        
        //Board.PlaceAQueen(Xstart, Ystart);
        
        
        //Prints the board out
        Board.PrintBoard();
        
        



    }

    

    
}


/*
 //Lets try a basic recursive loop
 //This loop returns the factorial sum of every number less than it
 public static int sum(int num) {
 int result;
 if (num == 1) {
 result = 1;
 } else {
 result = num + sum(num - 1);
 }
 return result;
 } */


/*
        //A loop to fill the 
        //entire thing with asterixes
        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                Board.ChessBoard[i][y] = "*";

            }
        }
        */