package 面试.字节;

import java.util.Scanner;

/**
 * @author 福尔摩东
 * @date 2022/2/24 20:20
 * @公众号 IT云家
 * @Github https://github.com/zzdnb
 * @博客 https://blog.csdn.net/qq_43688587
 * @网站 https://blog.zzdnb.cn
 */
public class AC2019_1 {
    static void solve(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //  排除AAA型
            if (i < 2 || ch != sb.charAt(sb.length() - 1) || ch != sb.charAt(sb.length() - 2)) {
                // 排除AABB型
                if (i < 3 || ch != sb.charAt(sb.length() - 1) || sb.charAt(sb.length() - 2) != sb.charAt(sb.length() - 3)) {
                    sb.append(ch);
                }
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0){
            solve(sc.next());
        }
    }
}
