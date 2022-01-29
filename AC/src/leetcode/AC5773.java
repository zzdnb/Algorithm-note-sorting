package leetcode;

public class AC5773 {
    public static String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        if(n.charAt(0)=='-'){
            sb.append('-');
            boolean flag = false;
            for(int i = 1, j = 1; i < n.length(); i++){
                j = i;
                while(j < n.length()&& n.charAt(j)==n.charAt(i)){
                    j++;
                }

                if(x < n.charAt(j-1)-'0'&&flag == false){
                    sb.append(x);
                    flag = true;
                }

                System.out.print(sb.toString());
                sb.append(n.substring(i,j));
                i = j-1;

            }
            if(!flag){
                sb.append(x);
            }
        }else{
            boolean flag = false;
            for(int i = 0, j = 0; i < n.length(); i++){
                j = i;
                while(j < n.length()&& n.charAt(j)==n.charAt(i)){
                    j++;
                }

                if(x > n.charAt(j-1)-'0'&&flag == false){
                    sb.append(x);
                    flag = true;
                }


                sb.append(n.substring(i,j));
                i = j-1;

            }
            if(!flag){
                sb.append(x);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maxValue("962942516613939",

                3));
    }
}
