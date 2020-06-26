package reciteWrite;

import java.util.Arrays;

/**
 * @author: wuhui
 * @time: 2019/10/28 16:33
 * @desc:
 */
public class BubbleSortPro {
    public static void main(String[] args) {
        int[] arr={2,1,24,2,39,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    //原生冒泡
    private static void sort(int[] arr) {
        int nCount=0,nnCount=0;
        for (int i = 0; i < arr.length; i++) {
            ++nCount;
            for (int j = 0; j+1 <arr.length; j++) {
                ++nnCount;
                if (arr[j+1]<arr[j]){
                    swap(arr, j, j+1);
                }
            }
        }
        System.out.println(nCount+"趟---"+nnCount+"次比较");

    }
    //未发生交换说明有序退出
    private static void sort0(int[] arr) {
        int nCount=0,nnCount=0;
        for (int i = 0; i < arr.length; i++) {
            ++nCount;
            boolean flag=true;
            for (int j = 0; j+1 <arr.length; j++) {
                ++nnCount;
                if (arr[j+1]<arr[j]){
                    swap(arr, j, j+1);
                    flag=false;
                }
            }
            if (flag){
                break;
            }
        }
        System.out.println(nCount+"趟---"+nnCount+"次比较");

    }
    //并且后面肯定有序，不用比较了，只要比较前length-i个
    private static void sort1(int[] arr) {
        int nCount=0,nnCount=0;
        for (int i = 0; i < arr.length; i++) {
            ++nCount;
            boolean flag=true;
            for (int j = 0; j+1 <arr.length-i; j++) {
                ++nnCount;
                if (arr[j+1]<arr[j]){
                   swap(arr, j, j+1);
                    flag=false;
                }
            }
            if (flag){
                break;
            }
        }
        System.out.println(nCount+"趟---"+nnCount+"次比较");
        
    }
    // 并且每趟把最小的也找出来交换
    private static void sortPro(int[] arr) {
        //int nCount=0,nnCount=0;
        for (int i = 0; i < arr.length; i++) {
            //++nCount;
            boolean flag=true;
            int minPos=i;
            for (int j = i; j+1 <arr.length-i ; j++) {
                //++nnCount;
                minPos=arr[minPos]>arr[j]?j:minPos;
                if (arr[j+1]<arr[j]){
                    swap(arr, j, j+1);
                    flag=false;
                }
                if(j+1==arr.length-i){
                    swap(arr, i, minPos);
                }
            }
            if (flag){
                break;
            }
        }
        //System.out.println(nCount+"趟---"+nnCount+"次");
    }
}
