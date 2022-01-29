package niuke;

import java.util.ArrayList;
import java.util.Arrays;

public class NC54 {
    public static void main(String[] args) {
        new NC54().threeSum(new int[]{-2,0,1,1,2});
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        //去除重复方案是最难的
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        int n = num.length;
        if (num == null || n < 3) {
            return list;
        }
        for (int i = 0; i < n; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {

                int sum = num[l] + num[r] + num[i];
                if (sum == 0) {
                    tmp = new ArrayList<>();
                    tmp.add(num[i]);
                    tmp.add(num[l]);
                    tmp.add(num[r]);
                    list.add(tmp);
                    for(int x: tmp){
                        System.out.print(x+" ");
                    }
                    System.out.println();
//                    tmp.clear();
                    while (l < r && num[l] == num[l + 1]) {
                        l++;
                    }
                    while (l < r && num[r] == num[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

        }return list;
    }
}
