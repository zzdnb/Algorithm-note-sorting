package pipi;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n;
        while (sc.hasNext()) {
            n = sc.nextLong();

            System.out.println((int)(Math.log10(n)/Math.log10(2)) + 1);

        }
        sc.close();
    }
}
