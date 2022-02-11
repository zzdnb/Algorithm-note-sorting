package bigdataclass;

import java.util.Scanner;

public class Main {
    static String reverseWords(String s){
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int i = s.length()-1;
        while(i>=0){
            while(i >= 0&&ch[i]!=' '){
                sb.append(ch[i]);
                i--;
            }
            ans.append(sb.reverse());
            sb = new StringBuilder();
            ans.append(' ');
            i--;
        }
        return ans.toString();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = reverseWords(s);
        System.out.println(ans);
    }
}
