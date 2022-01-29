package leetcode;

public class AC14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        String s = "";
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(i>=strs[j].length()){
                    return s;
                }
                if(!strs[j].substring(0,i+1).equals(strs[0].substring(0,i+1))){
                    return s;
                }

            }
            s = s+strs[0].charAt(i);
        }
        return s;
    }
}
