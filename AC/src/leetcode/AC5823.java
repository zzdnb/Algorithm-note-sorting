package leetcode;

public class AC5823 {
    public static void main(String[] args) {
        System.out.println(getLucky("zbax",2));
    }

    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c-'a'+1);
        }
        int cnt = 0;
        int tmp = 0;
        int res = 0;
        while(cnt < k ){

            for(char c:sb.toString().toCharArray()){
                res+=c-'0';
            }
            tmp = res;
            sb = new StringBuilder(String.valueOf(res));
            res  = 0;
            cnt++;
        }

        return tmp;
    }
}