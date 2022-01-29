package leetcode;

public class I {
}
class S {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
    }
    public static String longestNiceSubstring(String s) {
        String ss = "";
        for(int i = 0; i < s.length()-1; i++){
            System.out.println(s.charAt(i));
            if(s.charAt(i)==s.charAt(i+1)-32||s.charAt(i)==s.charAt(i+1)+32){
                ss = ss+s.charAt(i)+s.charAt(i+1);
                for(int j = i-1; j >=0; j-- ){
                    if(s.charAt(j)==s.charAt(i)){
                        ss = s.charAt(j)+ss;
                    }else{
                        break;
                    }
                }
                for(int j = i+2; j <s.length(); j++ ){
                    if(s.charAt(j)==s.charAt(i+1)-32||s.charAt(j)==s.charAt(i+1)+32||s.charAt(i+1)==s.charAt(j)){
                        ss = ss+s.charAt(j);
                    }else{
                        break;
                    }
                }
                break;
            }
        }
        return ss;
    }
}