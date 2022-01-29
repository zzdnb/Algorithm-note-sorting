package leetcode;

public class ACW5841 {
    public static void main(String[] args) {
        System.out.println(longestObstacleCourseAtEachPosition(new int[]{1,2,3,2,4}));
    }
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] f = new int[obstacles.length];
        int[] ret = new int[obstacles.length];
        int cnt = 0;
        int m = obstacles.length;
        for (int i = 0; i < m; ++i) {
            int l = 0, r = cnt;
            //记录各个长度之下的结尾的最小值
            int num = obstacles[i];
            while(l < r) {
                int mid = (l+r)>>1;
                if(f[mid] > num) r = mid;
                else l = mid + 1;
            }
            f[r] = num;
            //数组中的r+1就是每个位置对应的最长的子序列长度
            ret[i] = r+1;
            if(r == cnt) ++cnt;
        }
        for(int i = 0; i < f.length; i++){
            System.out.println(obstacles[i]+" "+f[i]+" "+ ret[i]);
        }
        return ret;

    }
}
