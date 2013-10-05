/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueens;

/**
 *
 * @author Richard
 */
public class EightQueens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Welcome to the EightQueens program!");
        
        //Creates an 8x8 chess board that holds strings 
        String[][] ChessBoard = new String[8][8];
        
        //sum(5);
        System.out.println(sum(3));
        
        
    }
    
    //Lets try a basic recursive loop
    //This loop returns the factorial sum of every number less than it
    public static int sum(int num){
        int result;
        if (num == 1){
            result = 1;
        }else{
            result = num + sum(num-1);
        }
        return result;
    }
    
    /*
    Hint: to determine whether setting q[n] = i conflicts with q[0] through q[n-1] 
    if q[i] equals q[n]: two queens are placed in the same column
    if q[i] - q[n] equals n - i: two queens are on same major diagonal
    if q[n] - q[i] equals n - i: two queens are on same minor diagonal 
     */
}
