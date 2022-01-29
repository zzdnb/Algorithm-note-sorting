package Acwing;

import java.util.TreeSet;
import java.util.Scanner;

public class AC4199 {
    static int a, b;
    static  TreeSet<Integer> set3 = new TreeSet<>();
    static void solve(int l, int r) {
        int ans = -1;

        for (int x : set3) {
            if (x >= l && x <= r) {
                ans = x;
            }
            if(x>r){
                break;
            }

        }
   System.out.println(ans);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int q = sc.nextInt();
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        set1.add(1);
        set1.add(a);

        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                set1.add(i);
                set1.add(a/i);
            }
        }

        set2.add(1);
        set2.add(b);

        for (int i = 2; i <= b / i; i++) {

            if (b % i == 0) {
                set2.add(i);
                set2.add(b/i);
            }

        }



        for (int x : set1) {
            if (set2.contains(x)) {
                set3.add(x);
            }
        }

        while (q-- != 0) {

            int l = sc.nextInt();
            int r = sc.nextInt();
            solve(l, r);
        }

    }
}
