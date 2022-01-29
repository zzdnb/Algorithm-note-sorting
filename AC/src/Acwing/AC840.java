package Acwing;
import java.util.*;
public class AC840 {
    static int N = (int)2e5+10;
    static int M = 0x3f3f3f3f;
    static int p[] = new int[N];
    static int find(int x){
        x = (x%N+N)%N;
        while(p[x]!=M&&p[x]!=x){
            x = (x+1)%N;
        }
        return x;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(p,M);
        for(int i =0 ; i < n; i++){
            String[] s = sc.nextLine().split(" ");
            for(String ss:s){
                System.out.println(ss);
            }
//            int x = Integer.parseInt(s.split(" ")[1]);
//            if(s.split(" ")[0].equals("I")){
//                p[find(x)] = x;
//            }else{
//                if(p[find(x)] == M){
//                    System.out.println("No");
//                }else{
//                    System.out.println("Yes");
//                }
//            }
        }
    }
}


