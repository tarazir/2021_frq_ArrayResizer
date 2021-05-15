/*

* Program by: Mr. Tarazi, ASK HS Technology Teacher
* Date: 05/14/2021
* The question involves manipulating a two-dimensional array of integers. You will write two static methods
* of the ArrayResizer class as per the FRQ documentation
*
* 2021 FRQ - Question #4
* */


import java.util.Arrays;

public class Main {

    public static int count;


    public static void main(String[] args) {
	// write your code here

        int[][] array2D = {{2,1,0}, {1,3,2}, {0,0,0},{4,5,6}};
        System.out.println("Atleast one value in Row is not ZERO -> " + isNonZeroRow(array2D,3));
        System.out.println("Number of rows not equal to ZERO -> " + numNonZeroRows(array2D));
        // I used  Arrays.deepToString to print 2 dimensional arrays
        System.out.println("Resize Array method -> " + Arrays.deepToString(resize(array2D)));
    }

    // Method isNonZeroRow which returns true if and only if all elements in a row r
    // of a two dimensional array array2D are not equal to ZERO

    public static boolean isNonZeroRow(int[][] array2D, int rowNum) {

        for (int i=0; i< array2D[0].length; i++) {
            if (array2D[rowNum][i] == 0)
                return false;
        }
        return true;
    }

    // Helper method. This method returns the number of rows in its
    // two dimensional aray paramter that contain no zero values
    public static int numNonZeroRows(int[][] array2D) {

        // Two instance variables. Count -> Count the number of Rows that doesn't have a ZERO column.
        // Flag -> Set the flag to true if the row doesn't have a ZERO in its column
        int count = 0;
        boolean flag = true;

        // Nested loop to go over the row/column to check for ZERO value
        for (int row=0; row<array2D.length; row++) {
            for (int col = 0; col < array2D[0].length; col++) {
                if (array2D[row][col] == 0) {
                    flag = false;
                    break;
                }
            }
            // If flag is true then incrementt row counter; otherwsie keep the flag false.
            if (flag == true)
                count++;
            else
                flag = true;
        }
        return count;
    }

   // Method returns two dimensional array containing only rows from array2D with all non-zero values
   // The elements of the array should appear in the same order in which they appear in the origional array

   public static int[][] resize(int[][] array2D) {
        // Calculate the number of Non Zero Rows from the Helper method
       int row = numNonZeroRows(array2D);
       int[][] newArray = new int[row][array2D[0].length];

       int newR = 0;
       for(int oldR = 0; oldR < array2D.length; oldR++)
       {
           if(isNonZeroRow(array2D, oldR))
           {
               // could copy elements within row instead
               newArray[newR] = array2D[oldR];
               newR++;
           }
       }
       return newArray;
    }
}
