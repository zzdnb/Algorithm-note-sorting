package Acwing;

import java.util.HashMap;
import java.util.Scanner;

public class AC1726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m = sc.nextInt(), k =sc.nextInt();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int[]ab = new int[110];
        for(int i = 1 ; i <= m; i++){
            int con = sc.nextInt();
            map1.put(con,i);
            map2.put(i,con);
        }
        for(int i = 0; i< k; i++){
            int content = sc.nextInt();
            ab[sc.nextInt()] = content;
        }
        for(int i = 1; i <= n; i++){
            if(ab[i] != 0 && map1.get(ab[i])!=null){
                int j = map1.get(ab[i])-1,c = i-1;
                while(j > 0 && c > 0){
                    if(ab[c]!=0){
                        c--;
                        continue;
                    }
                    ab[c--] = map2.get(j--);
                }
            }

        }
        for(int i = 1; i <= n; i++){
            System.out.println(ab[i]);
            if(ab[i] == 0){
                System.out.println(i);
                return;
            }
        }

    }
}
