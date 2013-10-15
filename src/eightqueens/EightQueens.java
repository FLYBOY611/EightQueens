package eightqueens;

import java.util.Scanner;

public class EightQueens {

    

    public static void main(String[] args) {
        CreateBoard Board = new CreateBoard();
        
        //Fills the board then jumps into placing queens
        Board.FillBoard();        
        
        //Prints the board out
        Board.PrintBoard();

    }

    

    
}

