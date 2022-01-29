package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SA {
    public static void main(String[] args) {
        findingUsersActiveMinutes(new int[][]{{185799173, 108}, {185799173, 108}, {185799171, 107}, {185799173, 104}, {185799170, 109}, {185799170, 108}, {185799173, 105}, {185799169, 108}
        } ,5);
    }
    public static  int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] time = new int[100005];
        Arrays.sort(logs,(o1, o2)->{
            if(o1[0]==o2[0]&&o1[1]!=o2[1]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });
        for(int []arr:logs){
            System.out.println(Arrays.toString(arr));
        }
        int tmp = 0;
        if(logs.length==1){
            time[1]++;
        }
        for(int i = 0; i < logs.length-1; i++){
            if(logs[i][0]==logs[i+1][0]){
                if(logs[i][1]!=logs[i+1][1]){
                    tmp++;
                    if(i+1==logs.length-1){
                        time[tmp+1]++;
                    }
                }else{
                    if(i+1==logs.length-1){
                        time[tmp+1]++;
                    }
                }
            }else{
                time[tmp+1]++;
                if(i+1==logs.length-1){
                    time[1]++;
                }
                tmp = 0;
            }

        }
        int[] ans = Arrays.copyOfRange(time,1,k+1);
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
