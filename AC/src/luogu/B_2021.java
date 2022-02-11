package luogu;

import java.util.Scanner;

public class B_2021 {
    static int T;
    static int a,p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(T-- != 0){
            a = sc.nextInt();
            p = sc.nextInt();
            if(p < 16){
                a = a-10;
                if(a < 0){
                    a = 0;
                }
            }
            if(p > 20){
                a = a - (p-20)*1 ;
                if(a <= 0){
                    a = 0;
                }
            }
            System.out.println(a);
        }
    }
}
