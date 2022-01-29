package leetcode;

import java.util.Arrays;

class E{
    public static int maximumScore(int a, int b, int c) {
        int res = 0;
        int [] arr = new int[]{a,b,c};
        while((arr[0]!=0||arr[1]!=0)&&(arr[0]!=0||arr[2]!=0)){
            System.out.println(arr[0]+" "+arr[1]);
            Arrays.sort(arr);
            if(arr[0]==0){
                arr[1]--;
                arr[2]--;
            }else{
                arr[0]--;
                arr[2]--;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumScore(2,4,6));
    }
}