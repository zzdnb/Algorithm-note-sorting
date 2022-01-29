package niuke;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        while (n-- != 0) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();

            sum += (b-a)/b;
        }

        System.out.println(sum * 100);
    }
}
