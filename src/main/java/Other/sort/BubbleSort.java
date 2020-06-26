package Other.sort;

import java.util.Arrays;

/** 遍历n趟，每趟把无序数组中最大的移到最后
 * 每一趟从第一个元素开始和下一个元素比较，
 * 如果后者小于前者才交换
 * @author: wuhui
 * @time: 2019/9/12 22:20
 * @desc:
 */
public class BubbleSort {
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if (arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={2,1,24,2,39,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
