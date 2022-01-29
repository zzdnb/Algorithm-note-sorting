package Acwing;

import java.util.Scanner;
import java.util.TreeSet;

public class J {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i= 2; i <= n/i;i++){
            while(n%i==0){
                set.add(i);
                n = n/i;
            }
        }
        if(n>1){
            set.add(n);
        }
        System.out.println(set.last());
    }
}
