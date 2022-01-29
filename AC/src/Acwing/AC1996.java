package Acwing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AC1996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        String[] s1 = new String[n];
        String[] s2 = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = sc.next();
        }
        for(int i = 0; i < n; i++){
            char[] ch = s[i].toCharArray();
            Arrays.sort(ch);
            s1[i] = new String(ch);
            s2[i] = String.valueOf(new StringBuilder(String.valueOf(ch)).reverse());
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i = 0; i < n; i++){
            System.out.println(s1[i]+" "+s2[i]);
        }

        for(String ss:s){
            int x=0,y = 0;
            char[] ch = ss.toCharArray();
            Arrays.sort(ch);
            ss = new String(ch);
            int l = 0, r = s.length-1;
            while(l < r){
                int mid = (l+r)>>1;
                if(ss.compareTo(s2[mid]) == 0||ss.compareTo(s2[mid])<0){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            x = r+1;
            //
            l = 0;
            r = s.length-1;
            ss = String.valueOf(new StringBuilder(String.valueOf(ch)).reverse());
            while(l < r){
                int mid = (l+r+1)>>1;
                if(ss.compareTo(s1[mid]) == 0||ss.compareTo(s1[mid]) > 0){
                    l = mid;
                }else{
                    r = mid-1;
                }
            }
            y = r+1;
            System.out.println(x-1 +" "+ (y-1));
        }





    }
}
