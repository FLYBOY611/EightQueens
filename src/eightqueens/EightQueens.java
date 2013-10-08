package eightqueens;

import java.util.Scanner;

public class EightQueens {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Eight Queens program!");
        System.out.println("Please enter in the X cordinate"
                + " of the first Queen");
        int FirstX = input.nextInt();
        System.out.println("Please enter in the Y cordinate");
        int FirstY = input.nextInt();

        //Creates an 8x8 chess board that holds strings
        String[][] ChessBoard = new String[8][8];

        //A loop to fill the 
        //entire thing with asterixes
        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                ChessBoard[i][y] = "*";

            }
        }
        //Puts down the first Queen
        ChessBoard[FirstX][FirstY] = "Q";



        //Print the whole thing out    
        for (int i = 0; i < 8; i++) {
            System.out.print("\n");
            for (int y = 0; y < 8; y++) {
                System.out.print(" " + ChessBoard[y][i]);
            }
        }


    }

    /*
     Hint: to determine whether setting q[n] = i conflicts with q[0] through q[n-1] 
     if q[i] equals q[n]: two queens are placed in the same column
     if q[i] - q[n] equals n - i: two queens are on same major diagonal
     if q[n] - q[i] equals n - i: two queens are on same minor diagonal 
     */
    public void PrintItOut() {
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
