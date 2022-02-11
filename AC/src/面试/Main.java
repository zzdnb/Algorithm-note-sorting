package 面试;

public class Main {
    public static void main(String[] args) {
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }
    public static boolean winnerOfGame(String colors) {
        int n = colors.length();
        int len1 = 0,len2 = 0;
        int i = 0,j = 0;
        while(i < n){
            while(j < n && colors.charAt(j)=='A'){
                j++;
            }
            if(j-i>=3){
                len1 += j-i-2;
            }
            i = j;

            while(j < n && colors.charAt(j)=='B'){
                j++;
            }
            if(j-i>=3){
                len2 += j-i-2;
            }

            i = j;

        }

        if(len1 > len2){
            return true;
        }else if(len1 == len2){
            return false;
        }else{
            return false;
        }

    }
}

//统计连续的a或b的个数
// bbbb 2 n-3+1
// bbbbb 3 n-3+1