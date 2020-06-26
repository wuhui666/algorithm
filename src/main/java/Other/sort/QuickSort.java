package Other.sort;

import java.util.Arrays;

/** 一般第一个数为基准，i,j分别指向头尾元素
 *  整个过程是一个交替扫描和交换的过程，
 *  刚开始atLeft=true,表示基准在左边，需要从从后往前遍历寻找比基准小的
 *  如果比基准大，j--,直到找到最近的一个比基准小的，和基准交换,
 *  改变方向（atLeft取反），从前往后遍历，
 *  然后
 *  如果比基准小，i++,直到找到最近的一个比基准大的，和基准交换
 *  改变方向（atLeft取反），从后往前
 *  i=j退出循环，第一趟结束
 *  然后划分为比基准小的和大的两个子数组，
 *  找到两个子数组的第一个元素为基准。分别递归
 * @author: wuhui
 * @time: 2019/9/12 22:32
 * @desc: 平均复杂度nlogn
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,1,1};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int start,int end){
        if (end-start<=0){
            return;
        }
        int tmp=0;
        boolean atLeft=true;
        int left =start,right=end;
        for (; left!=right ; ) {
            if (atLeft){
                if (arr[right]<arr[left]){
                    tmp=arr[right];
                    arr[right]=arr[left];
                    arr[left]=tmp;
                    ++left;
                    atLeft=!atLeft;
                }
                else {
                    --right;
                }
            }
            else {
                if (arr[left]>arr[right]){
                    tmp=arr[right];
                    arr[right]=arr[left];
                    arr[left]=tmp;
                    --right;
                    atLeft=!atLeft;
                }
                else {
                    ++left;
                }
            }
        }
        sort(arr, start, left-1);
        sort(arr, left+1, end);
    }
}
