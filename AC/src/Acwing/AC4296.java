package Acwing;

import java.util.Scanner;

public class AC4296 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        boolean flag = false;
        int x = 0,y = 0;
        for(int i = 0; i <= 1000; i++){
//            System.out.println((n-a*i)/b);
            if((n-a*i)/b == (int)((n-a*i)/b) && (n-a*i)/b >= 0 ){
                flag = true;
                x = i;
                y = (int) ((int)(n-a*i)/b);
                break;
            }
        }
        if (flag){
            System.out.println("YES");
            System.out.println(x+" "+y);
        }else{
            System.out.println("NO");
        }
    }
}
