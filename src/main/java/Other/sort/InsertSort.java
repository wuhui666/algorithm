package Other.sort;

import java.util.Arrays;

/** 从无序区那拿一个元素arr[i]，从0开始拿
 * 有序区倒着一个个和arr[i]比较，找到该元素在有序区的位置
 * @author: wuhui
 * @time: 2019/9/13 22:03
 * @desc:
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,1,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int tmp=0;
        // 从无序区那拿一个元素arr[i]，从0开始拿
        for (int i = 0; i < arr.length; i++) {
            // 有序区倒着一个个和arr[i]比较，从i-1开始，0~i-1是排好序的
            for (int j = i; j > 0; j--) {
                // 如果arr[j]>=arr[j-1]，说明它在有序区位置就应该为j
                if (arr[j]>=arr[j-1]){
                    // 本趟结束，下标j即为它在有序区的位置
                   break;
                }
                // arr[j]<arr[j-1],应该交换,j--,直到找到arr[j]>=arr[j-1]或者j=0退出
                tmp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=tmp;
            }
        }
    }
}
