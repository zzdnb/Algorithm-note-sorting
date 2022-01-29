package Acwing;

import java.util.Scanner;

public class AC1801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // index 1 ：剪刀 2：石头 3：布
        String[]ans = {"123","132","213","231","312","321"};
        int n = sc.nextInt();
        int[][]arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int res = 0;
        for(String s:ans){
            int tmp = 0;
            for(int[] x:arr){
                for(int i = 0; i < 3; i++){
                    if(x[1] == s.charAt((i+1)%3)-'0'&&x[0] == s.charAt(i)-'0'){
                        tmp++;
                    }
                }
            }
            res = Math.max(res,tmp);
        }
        System.out.println(res);
    }
}
