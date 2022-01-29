package lanqiao;

import java.util.*;

class E {
    public static void main(String[] Qargs) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Integer.MIN_VALUE;;
        int s = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(s<=0){
                s = 0;
            }
            s+=x;
            res = Math.max(res,s);
        }
        System.out.println(res);
    }



}