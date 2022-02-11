package pipi;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A = sc.nextInt();
        double B = sc.nextInt();
        double a = sc.nextInt();
        double b = sc.nextInt();
        if (A < a || B < b) {
            System.out.println(0);
        }
        long x = 0, y = 0;

        while (A > 0) {
            if (A - a - a + 0.00000001 >= 0) {
                x++;
                A = A - a - a + 0.00000001;
            } else {
                if (A - a >= 0) {
                    x++;

                }
                break;
            }
        }
        while (B > 0) {
            if (B - b - b + 0.00000001>= 0) {
                y++;
                B = B - b - b + 0.00000001;
            } else {
                if (B - b >= 0) {
                    y++;
                }
                break;
            }
        }
        System.out.println(x * y);


    }
}
