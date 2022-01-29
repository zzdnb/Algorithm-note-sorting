package Acwing;

import java.util.*;
public class B{
    static int [][] nums;
    static int []arr;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        for(int k = 0; k < n ;k++){
            x = sc.nextInt();
            nums = new int[x*x][x*x];
            for(int i = 0; i < x*x;i++){
                for(int j = 0; j < x*x; j++){
                    nums[i][j] = sc.nextInt();
                }
            }
            if(cal(x)){
                System.out.println("Case #"+(k+1)+": Yes");
            }else{
                System.out.println("Case #"+(k+1)+": No");
            }
        }

    }
    public static boolean cal(int x){
        //横向遍历
        for(int i = 0; i < x*x;i++){
            arr = new int[x*x];
            for(int j = 0; j < x*x; j++){
                if(0<nums[i][j]&nums[i][j]<x*x){
                    arr[nums[i][j]]++;
                    if(arr[nums[i][j]]>1){
                        return false;
                    }
                }
            }
        }
        for(int i = 0; i < x*x;i++){
            arr = new int[x*x];
            for(int j = 0; j < x*x; j++){
                if(0<nums[j][i]&&nums[j][i]<x*x){
                    arr[nums[j][i]]++;
                    if(arr[nums[j][i]]>1){
                        return false;
                    }
                }
            }
        }
        for(int i = 0; i < x*x;i=i+x){
            for(int j = 0; j <x*x;j = j+x){
                arr = new int[x*x];
                for(int k = i; k < i+x;k++){
                    for(int l = j; l < j+x;l++){

                        if(0<nums[k][l]&&nums[k][l]<x*x){
                            arr[nums[k][l]]++;
                            if(arr[nums[k][l]]>1){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}