package Acwing;



import java.util.*;
public class A{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]arr = new int[n+1][n+1];
        int [][]nums =  new int[n+1][n+1];
        for(int i = 1; i <= n;i++){
            for(int j = 1 ; j <= n;j++){
                arr[i][j] = sc.nextInt();
                nums[i][j] = arr[i][j]+nums[i][j-1]+nums[i-1][j]-nums[i-1][j-1];
            }
        }
        int res = Integer.MIN_VALUE;
        int s = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1 ;j <= n;j++){
                for(int wx = i; wx<=n;wx++){
                    for(int wy = j ;wy <=n;wy++){
                        s+=nums[wx][wy]-nums[wx][j-1]-nums[i-1][wy]+nums[i-1][j-1];
                        res = Math.max(res,s);
                        s = 0;
                    }
                }

            }
        }
        System.out.println(res);
    }
}
