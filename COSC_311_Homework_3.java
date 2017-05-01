package cosc_311_homework_3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author      Michael Boettner
 * @version     1.0
 * Public class containing main method and static methods for each solution
 */
public class COSC_311_Homework_3 {
    
    static Scanner keyboard = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
        * one-dimensional array to be used for questions 1 and 2
        */
        int myArray1[] = {1, 2, 3, 4, 5};
        
        /**
        * two-dimensional array to be used for questions 3 and 4
        */
        int myArray2[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        //print elements of the 1D array
        System.out.print("1D array contents: ");
        for(int i = 0; i < myArray1.length; i++)
        {
            System.out.print(myArray1[i] + " ");
        }
        
        //call methods for problem 1 and 2 solutions, passing the 1D array
        problemOne(myArray1);
        problemTwo(myArray1);
        
        //print elements of the 2D array
        System.out.println("\n2D array contents: ");
        for(int i = 0; i < myArray2.length; i++)
        {
            for(int j = 0; j < myArray2[0].length; j++)
            {
                System.out.print(myArray2[i][j] + " ");
            } 
            System.out.println();                           
        }
        
        problemThree(myArray2);
        problemFour(myArray2);
        problemFive();
    }
    
    /**
    * Problem one iterative solution to sum all elements in a 1D array
    *
    * @param  myArray1[] a one-dimensional array containing int values
    */
    static void problemOne(int myArray1[])
    {       
        /**
        * variable used for running sum of 1D array elements
        */
        int runningSum = 0;
        
        System.out.print("\n\nProblem #1: Methods to sum all elements in the"
                + " 1D array");
        
        //iterative solution to add all elements
        for(int i = 0; i < myArray1.length; i++)
        {
            runningSum += myArray1[i];
        }
        
        System.out.println("\n     Iterative solution: " + runningSum);
        
        //calls and prints the recursive solution
        System.out.println("     Recursive solution: " +
                problemOneRecursive(myArray1));     
    }
    
    /**
    * Problem one recursive solution to sum all int elements in a 1D array
    *
    * @param  myArray1[] a one-dimensional array containing int values
    * 
    * @return int value containing the running sum
    */
    static int problemOneRecursive(int[] myArray1)
    {
        //base case if array has been reduced down to empty
        if(myArray1.length == 0)
            return 0;
        /*recursion returns the int value of the zeroth element in the current
            array plus (a recursive call to) the int value of the zeroth
            element in a new array containing just the tail elements of the
            current array. This function will eventually reduce to an empty
            array.
            */
        return myArray1[0] + problemOneRecursive(Arrays.copyOfRange(myArray1,
                1, myArray1.length));
    }
    
    /**
    * Problem two iterative solution to sum all elements greater than a user-
    * specified value, k, in a 1D array
    *
    * @param  myArray1[] a one-dimensional array containing int values
    */
    static void problemTwo(int myArray1[])
    {
        /**
        * variable used for running sum of 1D array elements
        */
        int runningSum = 0;
        
        /**
        * user-specified value to be used in sum calculation
        */
        int k;
        
        System.out.print("\nProblem #2: Methods to sum all elements > k in "
                + "the 1D array");
        
        System.out.print("\n     Enter an int value, k: ");
        
        k = keyboard.nextInt();
        
        //iterative solution to add all elements greater than k
        for(int i = 0; i < myArray1.length; i++)
        {
            if(myArray1[i] > k)
                runningSum += myArray1[i];
        }
        
        System.out.println("     Iterative solution: " + runningSum);
        
        //calls and prints the recursive solution
        System.out.println("     Recursive solution: " +
                problemTwoRecursive(myArray1, k));  
    }
    
    /**
    * Problem two recursive solution to sum all elements greater than a user-
    * specified value, k, in a 1D array
    *
    * @param  myArray1[] a one-dimensional array containing int values
    * @param  k the value used to test which elements of the array will be
    *       added to the sum
    * 
    * @return int value containing the running sum
    */
    static int problemTwoRecursive(int[] myArray1, int k)
    {
        //base case if array has been reduced down to empty
        if(myArray1.length == 0)
            return 0;
        /*if the zeroth element is less than or equal to k, then we
            recursively return the tail of the array, without performing any
            addition
            */
        if(myArray1[0] <= k)
            return problemTwoRecursive(Arrays.copyOfRange(myArray1, 1,
                    myArray1.length), k);
        /*else we return the int value of the zeroth element in the current
            array, (which has tested to be greater than k), plus a recursive
            call with a new array containing just the tail elements of the
            current array. This is where the accumulated total happens. This
            function will eventually reduce to an empty array.
            */
        return myArray1[0] + problemTwoRecursive(Arrays.copyOfRange(myArray1,
                1, myArray1.length), k);
    }
    
    /**
    * Problem three iterative solution to sum all elements in a 2D array
    *
    * @param  myArray2[][] a two-dimensional array containing int values
    */
    static void problemThree(int[][] myArray2)
    {
        /**
        * variable used for running sum of 2D array elements
        */
        int runningSum = 0;
        
        System.out.print("\nProblem #3: Methods to sum all elements in the"
                + " 2D array");
        
        //iterative solution to add all elements in 2d array
        for(int i = 0; i < myArray2.length; i++)
        {
            for(int j = 0; j < myArray2[0].length; j++)
            {
                runningSum += myArray2[i][j];
            }                        
        }
        
        System.out.println("\n     Iterative solution: " + runningSum);
        
        //calls and prints the recursive solution
        System.out.println("     Recursive solution: " +
                problemThreeRecursive(myArray2));
    }
    
    /**
    * Problem three recursive solution to sum all int elements in a 2D array
    *
    * @param  myArray2[][] a two-dimensional array containing int values
    * 
    * @return int value containing the running sum
    */
    static int problemThreeRecursive(int[][] myArray2)
    {
        /*base case tests the number of rows contained in the 2d array. if
            the number of rows left in the array = 0, the 2D array has been
            processed (or it was empty to begin with)
            */
        if(myArray2.length == 0)
            return 0;
        /*Since the 2d array is just an array of arrays, we can add all
            elements by thinking of each row as a 1d array, and recursively
            adding each row together. This solution uses the
            recursive solution for 1d arrays, and then adds it to a recursive
            call to a new 2d array containing the tail of rows remaining.
        */
        return problemOneRecursive(myArray2[0]) +
                problemThreeRecursive(Arrays.copyOfRange(myArray2, 1,
                        myArray2.length));
    }
    
    /**
    * Problem four iterative solution to sum all elements greater than user-
    * specified value, k, in a 2D array
    *
    * @param  myArray2[][] a two-dimensional array containing int values
    */
    static void problemFour(int myArray2[][])
    {
        /**
        * variable used for running sum of 2D array elements
        */
        int runningSum = 0;
        
        /**
        * user-specified value to be used in sum calculation
        */
        int k;

        System.out.print("\nProblem #4: Methods to sum all elements > k in"
                + " the 2D array");

        System.out.print("\n     Enter an int value, k: ");

        k = keyboard.nextInt();

        //iterative solution to add all elements > k in 2d array
        for(int i = 0; i < myArray2.length; i++)
        {
            for(int j = 0; j < myArray2[0].length; j++)
            {
                if(myArray2[i][j] > k)           
                runningSum += myArray2[i][j];
            }
        }

        System.out.println("     Iterative solution: " + runningSum);
        
        //calls and prints the recursive solution
        System.out.println("     Recursive solution: " +
                problemFourRecursive(myArray2, k));  
    }
    
    /**
    * Problem four recursive solution to sum all elements greater than a user-
    * specified value, k, in a 2D array
    *
    * @param  myArray2[][] a two-dimensional array containing int values
    * @param  k the value used to test which elements of the array will be
    *       added to the sum
    * 
    * @return int value containing the running sum
    */
    static int problemFourRecursive(int[][] myArray2, int k)
    {
        //same logic as problemThreeRecursive, only this time we use the
            //1d recursive solution for values > k
        if(myArray2.length == 0)
            return 0;
        return problemTwoRecursive(myArray2[0], k) +
                problemFourRecursive(Arrays.copyOfRange(myArray2, 1,
                        myArray2.length), k);
    }
    
    /**
    * Problem five iterative solution to sort the elements in a 1D array into
    * two separate arrays, one for even index numbers, and one for odd
    */
    static void problemFive()
    {    
        /**
        * one-dimensional array, initialized
        */
        int arr[] = {11, 21, 23, 31, 14};
        
        /**
        * the length of the array containing all elements
        */
        int MAX = arr.length;
        
        /**
        * array which will hold the even-indexed values, declared at half
        * the size of the source array
        */
        int[] arr0 = new int[(int)Math.ceil(MAX/2.0)];
        
        /**
        * array which will hold the odd-indexed values, declared at half
        * the size of the source array
        */
        int[] arr1 = new int[(int)Math.ceil(MAX/2.0)];
        
        /**
        * incrementer value to track the index of the even array
        */
        int inc0 = 0;
        
        /**
        * incrementer value to track the index of the odd array
        */
        int inc1 = 0;
        
        System.out.println("\n\nProblem #5: Put the elements at even indexes "
                + "of arr into arr0, elements at odd indexes of arr into "
                + "arr1");
        
        System.out.print("     arr contents: ");
        for(int i = 0; i < MAX; i++)
        {
            System.out.print(arr[i] + " ");
        }
        
        //Iterative solution
        for(int i = 0; i < MAX; i++)
        {  
            //if the index of the source array is even, add to arr0 then 
                //increment to the next index for that array
            if(i%2 == 0)
            {
                arr0[inc0] = arr[i];
                inc0++;
            }
            //if the index of the source array is odd, add to arr1 then 
                //increment to the next index for that array
            else
            {
                arr1[inc1] = arr[i];
                inc1++;
            }
        }
        
        //print all elements in each array
        System.out.print("\n\n     Iterative solution:");
        System.out.print("\n     arr0 contents: ");
        
        //print elements of arr0
        for(int i = 0; i < arr0.length; i++)
        {
            System.out.print(arr0[i] + " ");
        }
        
        //print elements of arr1
        System.out.print("\n     arr1 contents: ");
        for(int i = 0; i < arr1.length; i++)
        {
            System.out.print(arr1[i] + " ");
        }
        
        /**
        * declare a two-dimensional array which will serve as a container
        * for two one-dimensional arrays for recursive implementation
        */
        int[][] arrRec = new int[2][(int)Math.ceil(MAX/2.0)];
        
        //calls the recursive function
        arrRec = problemFiveRecursive(MAX, arr, arrRec, 0, 0, 0);
        
        //copies the row 0 contents of the 2D array into 1D array
        arr0 = Arrays.copyOf(arrRec[0], arr0.length);
        //copies the row 1 contents of the 2D array into 1D array
        arr1 = Arrays.copyOf(arrRec[1], arr1.length);
        
        System.out.print("\n\n     Recursive solution: ");
        
        System.out.print("\n     arr1 contents: ");
        for(int i = 0; i < arr0.length; i++)
        {
            System.out.print(arr0[i] + " ");
        }
        
        System.out.print("\n     arr1 contents: ");
        for(int i = 0; i < arr1.length; i++)
        {
            System.out.print(arr1[i] + " ");
        }    
    }
    
    /**
    * Problem five recursive solution to sort the elements in a 1D array into
    * two separate arrays, one for even index numbers, and one for odd
    *
    * @param  MAX int containing the length of the source array
    * @param  arr[] a one-dimensional source array containing int values
    * @param  arrRec[][] 2D array which will serve as container for the return
    * @param  i int which will increment through indexes of the source array
    * @param inc0 int which will increment through indexes of the evens array
    * @param inc1 int which will increment through indexes of the odds array
    * 
    * @return int[][] 2D array which holds the two separate sorted arrays
    */
    static int[][] problemFiveRecursive(int MAX, int arr[], int arrRec[][],
            int i, int inc0, int inc1)
    {
        if(i == MAX)
            return arrRec;
        else if(i%2 == 0)
        {
            arrRec[0][inc0] = arr[i];
            return problemFiveRecursive(MAX, arr, arrRec, i + 1, inc0 + 1,
                    inc1);
        }
        arrRec[1][inc1] = arr[i];
        return problemFiveRecursive(MAX, arr, arrRec, i + 1, inc0, inc1 + 1);
    }   
}