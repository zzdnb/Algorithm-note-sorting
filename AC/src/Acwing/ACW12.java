package Acwing;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class ACW12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int[] arr = new int[26];
            for(int i = 0; i < s.length();i++){
                arr[s.charAt(i)-'a']++;
            }
            String ss = "";
            for(int i = 0; i < 26;i++){
                if(arr[i] != 0){
                    ss += (char) ('a' + i);
                }
            }
            System.out.println(ss);
            StringBuilder sb = new StringBuilder();
            if (n < k) {
                for (int i = 0; i < k - n; i++) {
                    s = s + ss.charAt(0);
                }
                sb.append(s);

            } else {
//
                for(int i = k-1; i >= 0; i--){
                    int tmp = ss.indexOf(s.charAt(i));

                    if (tmp != ss.length()-1 ){
                        sb.append(ss.charAt(tmp+1));
                        for(int j = i-1; j >= 0; j--){
                            sb.append(s.charAt(j));
                        }
                        break;
                    }
                    System.out.println();
                    sb.append(ss.charAt(0));
                    System.out.println(sb);
                }
                sb = sb.reverse();
            }
            System.out.println(sb);
        }


    }
}

