package leetcode;

public class Ac5982 {
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[]arr = new long[n+1];
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(i+1<n){
                arr[i+1] = Math.max(arr[i],arr[i+1]);
            }
            arr[i]+=q[i][0];
            if(i+q[i][1]+1 < n){
                arr[i+q[i][1]+1] = Math.max(arr[i],arr[i+q[i][1]+1]);
            }
            System.out.println(i+" "+arr[i]);
            ans = Math.max(ans,arr[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Ac5982().mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
    }
}
