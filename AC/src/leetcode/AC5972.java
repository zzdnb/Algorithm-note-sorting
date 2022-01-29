package leetcode;

public class AC5972 {
    public static void main(String[] args) {
        System.out.println(new AC5972().numberOfArrays(new int[]{-40},-46,53));
    }
    public int numberOfArrays(int[] d, int lower, int upper) {
        long pre = 0;
        long maxx = -(int)1e6,minn = (int)1e6;
        for(int i = 0; i < d.length; i++){
            pre += d[i];
            maxx = Math.max(maxx,pre);
            minn = Math.min(minn,pre);
        }
        int ans = (int) (Math.min(upper-maxx,upper)-Math.max(lower-minn,lower)+1);
        return ans > 0?ans:0;


    }
}
