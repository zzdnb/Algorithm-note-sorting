package pipi;

import Acwing.S;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] s = new String[]{" ling"," yi"," er"," san"," si"," wu"," liu"," qi"," ba"," jiu","fu"};
        if(a==0){
            System.out.println(s[0].trim());
            return;
        }
        String ss =new String();
        boolean flag = false;
        if(a<0){
            flag  =true;
        }
        a = Math.abs(a);
        while(a!=0){
            int x = a%10;
            ss = s[x]+ss;
;           a = a/10;
        }
        if(flag){
            ss = s[10]+ss;
        }
        System.out.println(ss.trim());
    }
}
