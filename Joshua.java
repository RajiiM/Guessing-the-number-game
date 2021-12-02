package tasks;
 
import java.util.Random;
import java.util.Scanner;
 
public class Random_Number_Guess_Game {
 
    static Random random = new Random();
    static int[] unique_number;
    Scanner s = new Scanner(System.in);
 
    public static void main(String[] args) {
        Random_Number_Guess_Game r_obj = new Random_Number_Guess_Game();
 
        unique_number = r_obj.print_generate_random();
 
        r_obj.print_Guess_number(unique_number);
 
    }
 
 
    /*
This function is used to generate a 4 digit unique 
number and store it in an array. this function 
also returns the 4 digit unique number 
in array format.
     */
    public int[] print_generate_random() {
 
        int[] a = new int[4];
 
        int i = 0;
        while (true) {
 
//this line is used to generate single digit random number
            int num = random.nextInt(9) + 1;
 
/*
The next step will be, to store that single digit into an array. If we run
the above line again, it will generate another random number, but it might or
might not be a different number than the previous number. if the second
number is different from the first we can store the second number in an array
but if it is same as the previous number, we must not store it and we must
ignore that number.
 */
 
            for (int j = 0; j < a.length; j++) {
 
                if (a[j] == num) {
                    num = 0;
                }
 
            }
 
            a[i] = num;
 
            if (a[i] == 0) {
 
            } else
                i++;
 
            if (a[3] != 0) {
                break;
            }
        }
 
        //this for loop can be used to view your random number
        /*
         * for (int k = 0; k < a.length; k++) { System.out.print(a[k] + " "); }
         * System.out.println();
         */
 
        return a;
 
    }
 
     
     
     
/*
In this method we give the random number as input and 
also get input from the user to compare the user number 
with our secret number to validate the user number.
*/
    public void print_Guess_number(int[] r_no) {
         
        System.out.println("Let the Game begin...");
        System.out.println("We have a secret  number, try to guess the number...");
        System.out.println("Enter your guess number (any 4 digit unqiue number between 1 and 9) : ");
        System.out.println("Before you begin, please note the following...");
        System.out.println("X - The number is not Present");
        System.out.println("P - The number is Present but not in the correct position");
        System.out.println("C - The number is Present in the correct position");
 
 
         
         
        while (true) 
        {
            //getting a 4 digit number from the user.
            int user = s.nextInt();
 
            int[] user_num = new int[4];
 
            char[] c = new char[4];
 
             
/*
Since we need to check each digit of the user number we convert the 
user number into an array using the below process
*/
            for (int i = 3; i >= 0; i--) {
                user_num[i] = user % 10;
                user = user / 10;
 
            }
             
    /*Printing the user guess number as an array*/
            for (int k = 0; k < c.length; k++) {
                System.out.print(user_num[k] + " ");
            }
            System.out.println();
             
             
             
             
             
/*
Once we have the user number as an array, we have to take 
each digit of the user number and compare it with the secret number.
 
If the first digit of the user number matches the first digit of the
secret number we can note it by using another char array 
and store first value of the array as 'C'.
 
If we find that the first digit of the user number is present in 
the secret number but the position is different, then we store 
the 'P' into the char array.
  
If the first digit of the user number is not present in the secret number
then we can store 'X' into the char array.
  
We repeat the above process until the char array contains 'C' in all its Indices.
*/
             
            for (int j = 0; j < user_num.length; j++) {
                for (int i = 0; i < user_num.length; i++) { // 1
                    if (user_num[j] == r_no[i]) {
                        if (j == i) {
                            c[j] = 'C';
                        } else
                            c[j] = 'P';
                        break;
                    } else
                        c[j] = 'X';
                }
            }
 
             
             
             
            // the below loop is to print the current values of the char array 
            for (int k = 0; k < c.length; k++) {
                System.out.print(c[k] + " ");
            }
            System.out.println();
             
             
             
/*
Once we obtain 'C' in all the Indices of the char array we need to break 
the while loop. so we first convert the char array into a String and the we 
use the equals method to check if the string contains "CCCC". if the condition
becomes true then we end the loop. 
*/
 
            String str = String.valueOf(c);
            if (str.equals("CCCC")) {
                System.out.println("Hurrah!!! You have successfully guessed the number.");
                break;
            }
        }
 
    }
 
}