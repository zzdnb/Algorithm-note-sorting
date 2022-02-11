package 面试.理想汽车;

public class Main {
    public String between (String chars, String id1, String id2) {
        // write code here
        char[] ch = chars.toCharArray();
        String ans = id1;
        int cnt = -1;
        if(id1.length() > id2.length()){
            return "Impossible";
        }
        for(int i = 0; i < Math.min(id1.length(),id2.length()); i++){
            if(id1.charAt(i)!=id2.charAt(i)){
                cnt = i;
                if(id1.charAt(i)>id2.charAt(i)){
                    return "Impossible";
                }

            }
        }
//        System.out.println(cnt +" "+id1.length()+id2.length());
        if(cnt == -1 && id1.length() == id2.length()){
            return "Impossible";
        }
        if(cnt == -1){
            cnt = id1.length()-1;
        }

        for(char s:ch){
            if(s <= id1.charAt(cnt)){
                ans += s;
                break;
            }
        }
        String tmp = ans;
        for(int i = ans.length()-1; i < id2.length()-1; i++){
            tmp += ans.charAt(ans.length()-1);
        }
        if(tmp.equals(id2)){
            return "Impossible";
        }
        if(ans.equals(id2)){
            return "Impossible";
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Main().between("0123sdfsf","0fdsaf","0sdfaf"));
    }
}

