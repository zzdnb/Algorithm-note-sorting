package offer;

public class D {
    public static void main(String[] args) {
        System.out.println(new Solution().digitAtIndex(2147483647));
    }
}
class Solution {
    public int digitAtIndex(int n) {
        int x = 0;
        StringBuilder sb = new StringBuilder();
        while(x<=n){
            sb.append(x);
            x++;
        }
        return sb.charAt(n)-'0';
    }
}