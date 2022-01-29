package leetcode;

public class AC5772 {
    public static void main(String[] args) {
        System.out.println(isSumEqual("acb",
                "cba",
                "cdb"));
    }
    public static boolean isSumEqual(String f, String s, String t) {
        int x = 0,y = 0, z = 0;
        for(int i = 0; i <f.length(); i++){
            x = 10*x + f.charAt(i)-'a';

        }
        for(int i = 0; i < s.length(); i++){
            y = 10 * y+s.charAt(i)-'a';
        }
        for(int i = 0;i < t.length(); i++){
            z = 10 * z+ t.charAt(i)-'a';
        }
        System.out.println(x+" "+y+" "+z);
        if(x+y==z){
            return true;
        }else{
            return false;
        }
    }
}
