package Acwing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G{
    static int N = 100010;
    static int []stack =  new int[N];
    static int up = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        while ((n--)!=0) {
            String[] s = read.readLine().split(" ");
            if("push".equals(s[0])){
                push(Integer.valueOf(s[1]));
            }else if("query".equals(s[0])){
                System.out.println(query());
            }else if("pop".equals(s[0])){
                pop();
            }else if("empty".equals(s[0])){
                System.out.println(empty());
            }
        }

    }
    static void push(int x){
        stack[++up] = x;
    }
    static void pop(){
        up--;
    }
    static int query(){
        return stack[up];
    }
    static String empty(){
        if(up==0){
            return "YES";
        }else{
            return "NO";
        }
    }
}