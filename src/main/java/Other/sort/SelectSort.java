package Other.sort;

import java.util.Arrays;

/** 遍历n趟，每趟从无序区选择最小的到无序区的第一个位置
 *
 * @author: wuhui
 * @time: 2019/9/13 21:50
 * @desc:
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={1,2,1,2,2,1,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int tmp=0,minIndex=0;
        for (int i = 0; i < arr.length; i++) {
            // 每一趟默认无序区第一个元素下标为最小元素下标
            minIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                // 更新最小元素下标
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            // 交换最小元素和无序区第一个元素的值
            tmp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=tmp;

        }
    }
}
