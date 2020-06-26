package Other.dp;

import java.util.Arrays;

/**
 * @author: wuhui
 * @time: 2019/9/1 11:19
 * @desc: 一维01背包
 */
public class ZeroOnePackage {
    public static void main(String[] args) {
        int[] w={2,2,6,5,4};
        int[] v={6,3,5,4,6};
        int capicty=10;
        ZeroOnePackage zeroOnePackage=new ZeroOnePackage();
        //System.out.println(zeroOnePackage.maxValue(w, v, capicty));
        System.out.println(zeroOnePackage.maxValuePro(w, v, capicty));
    }
    // 普通二维数组
    public int maxValue(int[] ww,int vv[],int capcity){

        int[] w=new int[ww.length+1];
        int[] v=new int[vv.length+1];
        // 由于容量0-10，下标取到10，长度为11
        int[][] temp=new int[w.length][capcity+1];
        // 前0个物品的重量与价值为0
        w[0]=0;
        v[0]=0;
        // 为了方便，使得第n个物品在数组的下标为n的形式
        for (int i = 1; i <= ww.length; i++) {
            w[i]=ww[i-1];
        }
        for (int i = 1; i <= vv.length; i++) {
            v[i]=vv[i-1];
        }
        // 初始值，前0个物品，最大价值为0，不管容量为多少
        for (int i = 0; i <= capcity; i++) {
            temp[0][i]=0;
        }

        /*for (int i = 1; i <= capcity; i++) {
            int max=0;
            int j=1;
            for (; j < w.length; j++) {
                if (i-w[j]>=0){
                    temp[j][i]=temp[j-1][i-w[j]]+v[j];
                    max=temp[j][i]>max?temp[j][i]:max;
                }
            }

        }*/
        // 开始填表
        for (int j = 1; j <w.length; j++) {
            // 对前j个物体，求出不同容量0-10能获得的最大价值
            for (int i=0; i <= capcity; i++) {
                // 如果容量足够，可以选择取或者不取，保留两种情况的最大值
                if (i-w[j]>=0){
                    int yes=temp[j-1][i-w[j]]+v[j];// 选择第j个物品
                    int no=temp[j-1][i];// 不选第j个物品
                    temp[j][i]=yes>no?yes:no;// 填入最大值
                }
                // 如果容量太小，不能放入当前物品，直接填入不选该物品情况的最大值
                else {
                    temp[j][i]=temp[j-1][i];
                }
            }
        }
        // 输出下二维数组表看看
        for (int i = 0; i < temp.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        return temp[w.length-1][capcity];// 返回最终结果
    }

    // 滚动数组优化,一维数组
    public int maxValuePro(int[] ww,int vv[],int capcity){

        int[] w=new int[ww.length+1];
        int[] v=new int[vv.length+1];
        // 由于容量0-10，下标取到10，长度为11
        // 滚动数组 temp[i] 表示容量为i能获得的最大价值，省略了一维
        int[] temp=new int[capcity+1];
        // 边界前0个物品的重量与价值为0
        w[0]=0;
        v[0]=0;
        // 为了方便，使得第n个物品在数组的下标为n的形式
        for (int i = 1; i <= ww.length; i++) {
            w[i]=ww[i-1];
        }
        for (int i = 1; i <= vv.length; i++) {
            v[i]=vv[i-1];
        }
        // 初始值，容量为0，最大价值0
        temp[0]=0;
        // 开始填表
        for (int j = 1; j <w.length; j++) {
            // i >=w[j]确保能装下物品j,一定要逆序遍历,不然存在覆盖，获取不了上一次循环的temp[i]
            for (int i=capcity; i >=w[j]; i--) {
                /* 由于逆序遍历，
                 * 这个时候max括号里的temp[i]存的是j-1那层循环（即j=0时）
                 * 的容量为j能获得的最大价值
                 */
                   temp[i]=Math.max(temp[i],temp[i-w[j]]+v[j]);
            }
            // 如果i <w[j],装不下，所以直接按不装的情况处理，
            // 本轮容量为i在前j个物品获取的最大价值temp[i]储存的值不更新，
            // 仍然是上一次的循环存的temp[i]
            // 所以不做任何处理效果和temp[j][i]=temp[j-1][i];作用一样
            //
           System.out.println(Arrays.toString(temp));
        }
        return temp[capcity];// 返回最终结果
    }
}
