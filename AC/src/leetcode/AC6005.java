package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class AC6005 {
    public static void main(String[] args) {


    }

    public int minimumOperations(int[] nums) {

        int len = nums.length;
        int[] ds = new int[(int) 1e5 ];
        int[] ss = new int[(int) 1e5 + 10];
        int[][] tmp = new int[4][2];
        for(int i=0;i<len;i++){
            if(i%2!=0)  ds[nums[i]]++;
            else        ss[nums[i]]++;
        }
        int maxD1=0,maxD2=0,maxS1=0,maxS2=0;
        int flagD = 0,flagS = 0;
        for(int i=1;i<=1e5;i++){
            if(nums[i]>maxD1){
                maxD1=nums[i];
                flagD=i;
            }
        }
        for(int i=1;i<=1e5;i++){
            if(i!=flagD) maxD2=Math.max(maxD2,nums[i]);
        }
        for(int i=1;i<=1e5;i++){
            if(nums[i]>maxS1){
                maxS1=nums[i];
                flagS=i;
            }
        }
        for(int i=1;i<=1e5;i++){
            if(i!=flagS) maxS2=Math.max(maxS2,nums[i]);
        }
//        cout<<maxD1<<" "<<maxD2<<" "<<maxS1<<" "<<maxS2<<endl;
        if(maxD1!=maxS1)    return len-maxD1-maxS1;
        else{
            return len-Math.max(maxD1+maxS2,maxD2+maxS1);
        }

    }
}
