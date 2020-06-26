package reciteWrite;

import java.util.Stack;

/**
 * @author: wuhui
 * @time: 2019/9/30 12:37
 * @desc:
 */
public class QuickSort {
    // 递归
    public static void sort(int[] arr,int start,int end){
        if (arr==null||arr.length<=1||start-end>=0){
            return;
        }
        boolean atLeft=true;
        int i = start,j=end;
        for (; i <j ; ) {
            if (atLeft){
                if (arr[i]>arr[j]){
                    int tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                    ++i;
                    atLeft=!atLeft;
                }
                else {
                    --j;
                }
            }
            else {
                if (arr[j]<arr[i]){
                    int tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                    --j;
                    atLeft=!atLeft;
                }
                else {
                    ++i;
                }
            }
        }
        sort(arr, start, i);
        sort(arr, i+1, end);
    }
    // 迭代
    public static void sortPro(int[] arr,int start,int end){
        if (arr==null||arr.length<=1||start-end>=0){
            return;
        }
        Stack<Integer> stack=new Stack<>();
        // 记录起始下标
        stack.push(start);
        stack.push(end);
        int i=0,j=0;
        while (!stack.empty()){
            j=stack.pop();//end
            i=stack.pop();//start
            // 每次出栈更新当前start,end,用于后面入栈
            start=i;
            end=j;
            boolean atLeft=true;
            for (; i <j ; ) {
                if (atLeft){
                    if (arr[i]>arr[j]){
                        swap(arr, i, j);
                        ++i;
                        atLeft=!atLeft;
                    }
                    else {
                        --j;
                    }
                }
                else {
                    if (arr[j]<arr[i]){
                        swap(arr, i, j);
                        --j;
                        atLeft=!atLeft;
                    }
                    else {
                        ++i;
                    }
                }
            }
            // 未越界则入栈
            if (i+1<end){
                //后半段
                stack.push(i+1);
                stack.push(end);
            }
            // 未越界则入栈
           if (i-1>start){
               //前半段
               stack.push(start);
               stack.push(i-1);
           }

        }
    }
    //迭代
    public void sortProPro(int[] arr,int start,int end){
        Stack<Integer> stack=new Stack<>();
        int right=0,left=0;
        stack.push(start);
        stack.push(end);
        while (!stack.empty()){
            Boolean asLeft=true;
            //先弹出end
            int endTmp= stack.pop();
            int startTmp= stack.pop();
            for (left = startTmp, right=endTmp; left < right;) {
                if (asLeft){
                    if (arr[left]>arr[right]){
                        swap(arr,left,right);
                        ++left;
                        asLeft=!asLeft;
                    }
                    else{
                        --right;
                    }

                }
                else{
                    if (arr[right]<arr[left]){
                        swap(arr, left, right);
                        --right;
                        asLeft=!asLeft;
                    }
                    else{
                        ++left;
                    }
                }
                // 当要结束本趟就用栈记录下标
                // 不用担心越界，因为越界了进不了循环也不会有影响
                if (left==right){
                    stack.push(startTmp);
                    stack.push(left-1);
                    stack.push(left+1);
                    stack.push(endTmp);
                }
            }

        }
    }
    public static void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    public static void main(String[] args) {
        int[] arr={12,14,1,12};
        sortPro(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
