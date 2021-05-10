package Java02;

import java.util.Scanner;

public class Temperatures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many day's temperatures? ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        double sum = 0;
        double avg = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Day " + (i + 1) + "'s high temp: " + arr[i]);
            sum += arr[i];
            avg = sum/n;
            count = 0;
            for (int j = 0;j < n; j++) {
                if (arr[j] > avg) {
                    count++;
                }
            }
        }
        System.out.println("Average = " + avg);

        System.out.println(count + " days about average");
    }
}
