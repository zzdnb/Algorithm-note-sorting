package leetcode;

public class LC5831 {
    public static void main(String[] args) {
//        System.out.println(minTimeToType("zjpc"));
        System.out.println(maxMatrixSum(new int[][]{{-1,0,-1},{-2,1,3},{3,2,2}}));
    }
    public static int minTimeToType(String word) {
        int cnt = 0,tmp = 0;
        for(int i = 0; i < word.length(); i++){
            int x=  Math.abs(word.charAt(i)-'a'-tmp);
            cnt += Math.min(x, 26-x)+1;
            tmp = word.charAt(i)-'a';
        }
        return  cnt;
    }
    public static long maxMatrixSum(int[][] m) {
        int cnt = 0;
        long res = 0;
        int min= (int)(1e5+10);
        boolean flag = false;
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                min = Math.min(Math.abs(m[i][j]),min);
                res += Math.abs(m[i][j]);
                if(m[i][j] < 0){
                    cnt++;
                }
                if(m[i][j] == 0){
                    flag = true;
                }
            }
        }
        if(cnt % 2 == 0 || flag){
            return res;
        }else{

            return res + -2*min;
        }
    }
}
