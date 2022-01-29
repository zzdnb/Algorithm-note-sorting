package leetcode;



import java.util.Stack;

public class jieyushui {
    public static void main(String[] args) {
        System.out.println(trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static  int trap1(int[] height) {
        //特判数组是否为空
        if(height==null||height.length==0){
            return 0;
        }
        int n = height.length;
        int res = 0;
        //遍历数组
        for(int i = 0; i < n; i++){
            //找到该数左边最大的值
            int l = Integer.MIN_VALUE;
            for(int j = i-1; j >=0; j--){
                l = Math.max(l,height[j]);
            }
            //如果该数左边最大的值小于等于当前数，说明不能接雨水
            if(l<=height[i]){
                continue;
            }
            //找到该数右边最大的值
            int r = Integer.MIN_VALUE;
            for(int j = i+1; j < n; j++){
                r = Math.max(r,height[j]);
            }
            //如果该数左边最大的值小于等于当前数，说明不能接雨水
            if(r<=height[i]){
                continue;
            }
            //将结果累加
            res += Math.min(l,r)-height[i];
        }
        return res;
    }

    //优化二：上面每次要找每个数左边以及右边最大的值，直接预处理存储，使用额外的空间来换时间
    public static  int trap2(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        int n = height.length;
        int max = Integer.MIN_VALUE;
        //定义两个数组用来存储各个元素左边以及右边的最大值
        int[] l = new int[n];
        int[] r = new int[n];
        //由于第一个数的左边的最大值肯定是0，所以从第一个开始计算
        for(int i = 1; i < n; i++){
            max = Math.max(max,height[i-1]);
            l[i] = max;
        }
        max = Integer.MIN_VALUE;
        //由于最后一个数的右边的最大值肯定是0，所以直接置为0
        for(int i = n-2; i >= 0; i--){
            max = Math.max(max,height[i+1]);
            r[i] = max;
        }
        int res = 0;
        //这里进行特判一下：如果当前l，r里对应下标的最小值<=当前值的话，就不能接雨水，就直接置为0，否则算差值。
        for(int i = 1; i < n-1; i++){
            res += Math.min(l[i],r[i])<=height[i]?0:Math.min(l[i],r[i])-height[i];
        }
        return res;
    }
    public static int trap3(int[] height){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        for(int i = 0; i < n; i++){
            //只有当栈为空的时候并且形成一个递增的序列。
            while(!stack.isEmpty()&&height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left],height[i]-height[top]);
                System.out.println(ans);
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
