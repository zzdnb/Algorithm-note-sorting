package leetcode;

public class AC5764 {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1,3,2},1.9));
    }
    public static  int minSpeedOnTime(int[] dist, double hour) {
        if(hour<= dist.length-1){
            return -1;
        }
        double sum = 0;
        for(int x:dist){
            sum += x;
        }
        for(int i = (int) Math.ceil(sum/hour); ; i++){
            double cnt = 0;
            for(int j = 0; j < dist.length-1; j++){
                cnt += Math.ceil((double)dist[j]/i);

            }


            cnt += (double) dist[dist.length-1]/i;

            if (cnt <= hour){
                return i;
            }


        }
    }
}
