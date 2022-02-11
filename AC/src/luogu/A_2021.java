package luogu;

import java.util.Scanner;

public interface A_2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        int ans = (int)(a*0.2+b*0.3+c*0.5);
        System.out.println(ans);
    }
}
