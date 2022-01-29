package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AC860{
    static int n;
    static int m;
    static int N = 100010;
    static int M = 200010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int idx = 0;
    static int[] color = new int[N];//共1和2两种不同的颜色
    static boolean[] st = new boolean[N];
    public static void add(int a,int b)
    {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    //dfs(u,c)表示把u号点染色成c颜色，并且判断从u号点开始染其他相连的点是否成功
    public static boolean dfs(int u,int c)
    {
        color[u] = c;
        for(int i = h[u];i != -1;i = ne[i])
        {
            int j = e[i];
            if(color[j] == 0)
            {
                if(!dfs(j,3 - c)) {
                    return false;
                }
            }
            else if(color[j] == c) {
                return false;//颜色重复
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        Arrays.fill(h, -1);
        while(m -- > 0)
        {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            add(a,b);
            add(b,a);
        }
        boolean flag = true;//标记是否染色成功
        for(int i = 1;i <= n;i++)
        {
            //若未染色
            if(color[i] == 0)
            {
                if(!dfs(i,1))
                {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}


