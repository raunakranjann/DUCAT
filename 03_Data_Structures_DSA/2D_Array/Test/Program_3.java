// Write a program in java to accept a number in 2D array .
// find out the sum of two dimensional array.

import java.util.Scanner;

class Program3
{
    public static void main(String arg[]) {

        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of rows :");
        int a = scanner.nextInt();
        System.out.println("Number of columns :");
        int b = scanner.nextInt();
        
        for(int x=0;x<a;x++){
            for(int y=0;y<b;y++){
        int arr[a][b] = scanner.nextInt();
            }
        }
       


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
                sum = sum +arr[i][j];

            }
            System.out.println();
        }
        System.out.println("Sum of the elements of array is " +sum);
    }
}