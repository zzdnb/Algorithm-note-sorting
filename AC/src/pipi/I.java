package pipi;

import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        double res = n;
        for(int i = 1; i <= y; i++){
            res *= 2.0 /3;
            if(i==x){
                res += (double)n/2;
            }
            if(res<(double)n/32){
                System.out.println("N0!");
                System.out.println(i+" "+String.format("%.6f",res));
                return;
            }
        }
        System.out.println("YE5!");
        System.out.println(String.format("%.6f",res));

    }
}
