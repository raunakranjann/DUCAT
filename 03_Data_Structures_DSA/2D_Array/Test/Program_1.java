// Write a program in java to accept a number to find out number is palindrome or not 
// using array.

import java.util.Scanner;

class program1{

    public static void main(String arg[]) {
        
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number");
        input = scanner.nextInt();

       int arr[];

        for(int i=0; i<input.length;i++){
            int m = input[i]%10;
            arr[i]= m;

        }

        for(int j;j<arr.length;j++){
            System.out.println(arr[j]);
        }

        System.out.println("The number is :"+input);

    }
}