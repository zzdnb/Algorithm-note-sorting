package leetcode;

public class Ac5824 {
    public static void main(String[] args) {
        System.out.println(maximumNumber("0",new int[]{
                5,3,4,1,2,6,8,0,4,2}));
    }
    public static String maximumNumber(String num, int[] change) {
        int left = 0, right = num.length();
        int start = 0;
        int end = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while(left < right){
            if(flag && change[num.charAt(left)-'0']>=num.charAt(left)-'0'){
                sb.append(change[num.charAt(left)-'0']);
                end = left+1;

            }
            if(!flag && change[num.charAt(left)-'0']>num.charAt(left)-'0'){
                sb.append(change[num.charAt(left)-'0']);
                start = left;
                flag = true;
            }


            if(flag&&change[num.charAt(left)-'0'] < num.charAt(left)-'0'){

                end = left;
                break;
            }
            left++;
        }
        
        System.out.println(start+" "+end);
        return num.substring(0,start)+sb+ num.substring(end);
    }
}
