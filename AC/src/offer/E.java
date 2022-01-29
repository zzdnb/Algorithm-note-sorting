package offer;

public class E {
    static boolean[][] st;
    static int cnt;
    static public boolean hasPath(char[][] m, String str) {
        if(m.length==0){
            return false;
        }
        st = new boolean[m.length][m[0].length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(m[i][j]==str.charAt(0)){
                    dfs(m,i,j,1,str);
                        if(cnt == 1){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    static void  dfs(char[][] m,int i, int j, int u ,String str){
        System.out.println(i+" "+j+" "+u);
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        st[i][j] = true;
        if(u==str.length()){
            cnt = 1;
            return;
        }
        for(int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x>=0&&x<m.length&&y>=0&&y<m[0].length&&str.charAt(u)==m[x][y]&&!st[x][y]){
                dfs(m,x,y,u+1,str);
            }
        }
        st[i][j] = false;

    }
    public static void main(String[] args) {
        char[][] ch = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(hasPath(ch,"ABCES"));
    }
}
