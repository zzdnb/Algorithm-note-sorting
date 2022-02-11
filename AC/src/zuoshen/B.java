package zuoshen;

import javax.swing.plaf.metal.MetalTheme;
import java.lang.reflect.Array;
import java.util.Arrays;

public class B {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 2, 3, 5, 4};
        int[] arr1 = new int[]{1, 1, 2};
        bit1(arr1);
        bit2(arr);
        bit3(10);
    }

    public static void bit1(int[] arr) {
        int eor = 0;
        for (int x : arr) {
            eor ^= x;
        }
        System.out.println(eor);
    }

    public static void bit2(int[] arr) {
        int a = 0;
        for (int x : arr) {
            a ^= x;
        }
        int k = 0;
        int res = a;
        while (res != 0) {
            if ((res ^ 1) == 0) {
                break;
            }
            k++;
            res = res >> 1;
        }
        int ans = 0;
        for (int x : arr) {
            if ((x >> k & 1) == 0) {
                ans ^= x;
            }
        }
        System.out.println(ans + " " + (ans ^ a));
    }

    public static void bit3(int x) {
        int res = 0;
        while (x != 0) {
            x = x & (x - 1);
            res++;
        }
        System.out.println(res);
    }
}
