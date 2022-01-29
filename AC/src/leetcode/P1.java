package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P1 {
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{2012,2014},{2032,2038},{1989,2035},{1979,1981},{2010,2013},{1971,2036},{2024,2037},{2028,2047}}));
    }
    public static int maximumPopulation(int[][] logs) {
        Arrays.sort(logs,(o1, o2)->{
            return o1[0]-o2[0];
        });
        int[] res = new int[logs.length];
        Arrays.fill(res,1);
        int max = 1;
        for(int i = 1; i < logs.length; i++){
            for(int j = 0; j < i ; j++){
                if(logs[j][1]>logs[i][0]){
                    res[i]++;
                }
                max = Math.max(max,res[i]);
            }
        }
        for(int[] x: logs){
            System.out.println(Arrays.toString(x));
        }
        System.out.println(Arrays.toString(res));
        int ans = 0;
        for(int i = 0; i < logs.length; i++){
            if(res[i] == max){
                ans = logs[i][0];
                break;
            }
        }
        return ans;
    }
}
