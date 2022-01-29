package niuke;

import java.util.HashMap;
import java.util.HashSet;

public class F {
    public static void main(String[] args) {
        HashMap<Integer,int[]> map = new HashMap<>();

        int[] ans = new int[51];
        for(int i = 1; i <= 50 ;i++){

            HashSet<Integer> set = new HashSet<>();
            for(int j = 1; j*j <= i; j++){
                if(i%j == 0){
                    set.add(j);
                    set.add(i/j);
                }
            }
            ans[i] = set.size()%2;
        }
        for(int i = 1; i <= 50; i++){
            ans[i] = ans[i-1]+ans[i];
            System.out.println(i+" "+ans[i]);
        }
    }
}
