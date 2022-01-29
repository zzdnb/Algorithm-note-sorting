package Acwing;

import java.util.Scanner;
import java.util.Stack;

public class AC2005 {
    static final int N = 10;
    static char[][] ch = new char[N][N];
    static int n;
//    static Stack<Character> stk = new Stack<>();
    static int ans = 0;
    static int[]dx = {-1,0,1,0},dy = {0,1,0,-1};
    static boolean[][] st = new boolean[N][N];
//    static void dfs(int i,int j,int k){
//        if(stk.size()==1 && stk.peek() == '('&&ch[i][j] ==')'){
//            ans = Math.max(ans,k+2);
//        }
//        System.out.println(i+" "+j+" "+k);
//        if(stk.size()!=0 && stk.peek() == '('&&ch[i][j] ==')'){
//            k += 2;
//            stk.pop();
//        }
//        if(stk.size() == 0 && ch[i][j] == ')'){
//            return ;
//        }
//        stk.push(ch[i][j]);
//        st[i][j] = true;
//        for(int b = 0; b < 4; b++){
//            int xx = i + dx[b];
//            int yy = j + dy[b];
//            if(xx >= 0 &&xx < n &&yy >= 0 && yy < n&&!st[xx][yy]){
//                dfs(xx,yy,k);
//            }
//        }
//        st[i][j] =false;
//
//
//    }
    static void dfs(int x,int y,int l,int r){
        if(l > 0 && l == r){
            ans = Math.max(ans,l+r);
            return;
        }
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx >= 0 && xx < n && yy >= 0 && yy < n && !st[xx][yy]){
                if(r > 0 && ch[xx][yy] =='('){
                    continue;
                }
                st[xx][yy] = true;
                if(ch[xx][yy] =='('){
                    dfs(xx,yy,l+1,r);
                }else{
                    dfs(xx,yy,l,r+1);
                }
                st[xx][yy] = false;
            }
        }
        return;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < n; j++){
                ch[i][j] = s.charAt(j);
            }
        }
        if(ch[0][0] == ')'){
            System.out.println(0);
            return;
        }
        st[0][0] = true;
        dfs(0,0,1,0);
        System.out.println(ans);
    }
}
