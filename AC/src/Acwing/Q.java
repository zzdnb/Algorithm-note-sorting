package Acwing;

class Solution {
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        char tmp1 = '0';
        char tmp2 = '0';
        int cnt = 0;
        boolean flag = false;
        for(int i = 0; i < s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)&&cnt==0){
                tmp1 = s1.charAt(i);
                tmp2 = s2.charAt(i);
            }
            if(s1.charAt(i)!=s2.charAt(i)){
                cnt++;
            }
            if(cnt==2&& !flag){
                flag = true;
                if(tmp1!=s2.charAt(i)||tmp2!=s1.charAt(i)){
                    return false;
                }
            }
            if(cnt>2){
                return false;
            }
            if(i==s2.length()-1&&cnt==1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("siyolsdcjthwsiplccjbuceoxmpjgrauocx","siyolsdcjthwsiplccpbuceoxmjjgrauocx"));
    }
}