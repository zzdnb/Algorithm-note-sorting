package leetcode;

import java.util.Scanner;

public class AC8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(myAtoi(" -91283472332 dfsaf "));
    }
    public static int myAtoi(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='-'){
                if(i+1 < s.length()&&Character.isDigit(s.charAt(i+1))){
                    res.append(s.charAt(i));
                }
            }else{
                if(i+1 < s.length()&&Character.isDigit(s.charAt(i+1))&&Character.isDigit(s.charAt(i))||(i-1>=0&&Character.isDigit(s.charAt(i)))){
                    res.append(s.charAt(i));
                }
            }

        }
        int len = 0;
        len = res.length();
        if(res.charAt(0) == '-'){
            len = len - 1;
        }

//        while(len !=0){
//
//        }
        System.out.println(res);
        return 0;
    }
}
