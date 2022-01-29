    package CCF;

    import java.util.*;

    public class C20210902 {
        static int N = (int)5e5+10;
        static int a[] = new int[N];
        static int n;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            for(int i = 1; i <= n; i++){
                a[i] = sc.nextInt();
                if(a[i] == 0){
                    continue;
                }
                if(map.containsKey(a[i])) {
                    map.get(a[i]).add(i);
                }else{
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    map.put(a[i],tmp);
                }
            }



            int cnt = 0;
            for(int i = 1, j = 1;  i <= n; i++){

                if(j <= n && a[j] != 0){
                    cnt++;
                }
                while(j <= n && a[j] != 0){
                    j++;
                }

                while(j <= n && a[j] == 0){
                    j++;
                }
                i = j-1;
            }

            Collection<ArrayList<Integer>> list = map.values();

            int res = cnt;
            for(ArrayList<Integer> t:list){

               for(int x:t){
                   a[x] = 0;
                   if(a[x-1] == 0 && a[x+1] == 0){
                      cnt--;
                   }
                   if(a[x-1]!= 0&&a[x+1]!= 0){
                      cnt++;
                   }
               }



               res = Math.max(cnt,res);

            }
            System.out.println(res);

        }
    }
