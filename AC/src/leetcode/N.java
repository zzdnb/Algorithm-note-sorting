package leetcode;

public class N {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char x: s.toCharArray()){
            if(x>='A'&&x<='Z'){
                sb.append((char)('a'+x-'A'));
            }
            if(x>='a'&&x<='z'){
                sb.append(x);
            }
            if(x>='0'&&x<='9'){
                sb.append(x);
            }
        }
        System.out.println(sb);
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
