package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class AC5296 {
    static int[] lr;{}
    static TreeSet<Integer> set = new TreeSet<>();
    static HashMap<Integer, List> map = new HashMap<>();
    static int n;
    static int[]arr;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] =sc.nextInt();
        }
        int cnt = 0;
        for(int i = 0, j = 0;  i < n; i++){

            if(j < n && arr[j] != 0){
                cnt++;
            }
            while(j < n && arr[j] != 0){
                j++;
            }

            while(j < n && arr[j] == 0){
                j++;
            }
            i = j-1;
        }
        lr = new int[]{-1,arr[1]};


    }
}
// left==null || right == null continue;
// left && right cnt++;
//2  2  5
//1  1
//0012022021
//首先记录一下初始的大小【非0段的个数】
//开hash表存一下每个值对应的左右两边
// hash<int,list> list[l,r] 先存一下最左和最右,
// 不需要恢复现场，开一个Treeset存一下key，容易去遍历，遍历过程中存一下最大值。
