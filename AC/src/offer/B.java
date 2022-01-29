package offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 剑指offer53题
 */
public class B {
    static char []path = new char[10];
    static boolean []flag = new boolean[26];
    static ArrayList<String> list = new ArrayList<>();
    public static String[] permutation(String s) {
        char[] ch = s.toCharArray();
        dfs(0,ch);
        String [] ss = new String[list.size()];
        for(int i = 0; i < list.size();i++ ){
            ss[i] = list.get(i);
        }
        return ss;
    }
    public static void dfs(int x,char[] ch){
        if(x==ch.length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ;i < x;i++){
                sb.append(path[i]);
            }
            list.add(sb.toString());
            return;
        }
        for(int i = 0 ;i < ch.length;i++ ){


                path[x] = ch[i];

                dfs(x+1,ch);


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String []ss = permutation(s);
        for(int i = 0 ; i< ss.length;i++){
            System.out.println(ss[i]);
        }
    }
}
