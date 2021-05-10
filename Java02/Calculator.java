package Java02;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        System.out.println("Enter 5 values:");
        int[] arr= new int[5];
        double sum = 0;
        double avg = 0;
        for (int i=0;i<5;i++){
             arr[i]=x.nextInt();
        }
        for (int i=0;i<5;i++){
            System.out.println("element "+i+" typed value was :"+arr[i]);
            sum += arr[i];
            avg = sum/5;
        }
        System.out.println("Average is " + avg);
    }
}
