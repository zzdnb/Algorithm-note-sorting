package zuoshen;


import javax.crypto.spec.PSource;
import java.util.Arrays;

/**
 * 冒泡排序与选择排序的实现
 */
public class A {
    public static void main(String[] args) {
    bubbleSort(new int[]{9,8,8,7,5,10,23,45});
    selectSort(new int[]{9,8,8,7,5,10,23,45});
    }
    public static void  bubbleSort(int []nums){
        if(nums ==null||nums.length<2){
            return ;
        }
        for(int i  = 0 ;i < nums.length;i++){
            for(int j = 0; j < nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void  swap(int [] nums,int a,int b){
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
         nums[a] = nums[a]^nums[b];
         nums[b] = nums[a]^nums[b];
         nums[a] = nums[a]^nums[b];
        System.out.println(nums[a]+" "+nums[b]);
    }

    public static void selectSort(int []nums){
        if(nums==null||nums.length<2){
            return;
        }

        for(int i = 0;i < nums.length-1;i++){
            int tmp = i;
            for(int j = i+1;j<nums.length;j++){
                tmp = nums[j]<=nums[tmp]?j:tmp;
            }
            swap(nums,i,tmp);
        }
        System.out.println(Arrays.toString(nums));
    }

}

// 异或 相同为0不同为1  无进位相加
// 异或满足交换律和结合律
