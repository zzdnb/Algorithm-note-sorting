package lanqiao;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        if(n<0){
            System.out.println(0);
            return;
        }
        long x = (long)Math.sqrt(n);
        if(x*x==n){

            System.out.println(n);
        }else{
            System.out.println((x+1)*(x+1));
        }

    }
}
