package Other.dp;

import java.util.Arrays;

/**
 *  硬币找零问题
 * @author: wuhui
 * @time: 2019/8/31 22:53
 * @desc: 完全背包问题
 */
public class Dp_Coins {
    public static void main(String[] args) {
        int[] arr={6,7};
        int money=8;
        Dp_Coins dp_coins=new Dp_Coins();
        System.out.println(dp_coins.leastCoinPro(arr, money));
    }
    // 1.fx=min{f(x-2)+1,f(x-5)+1,f(x-7)+1}
    // 2. f0=0;f(<0)=max_value,f1=max_value

    // 就是一个完全背包问题
    public int leastCoin(int[] arr,int money){
        if (money==0){
            return 0;
        }
        // 小于0，直接凑不出
        if (money<0){
            return Integer.MAX_VALUE;
        }
        // temp[i] 储存凑i元的最少硬币数量
        int[] temp=new int[money+1];
        // 初始值，0元0个
        temp[0]=0;
        for (int i = 1; i <= money; i++) {
            //int min=Integer.MAX_VALUE; //+1就变负数
            int min=Integer.MAX_VALUE-money*arr.length;
            for (int j = 0; j < arr.length; j++) {
                // 找到目标金额大于的硬币面值
                if (i-arr[j]>=0){
                    temp[i]=temp[i-arr[j]]+1;
                    min=temp[i]<min?temp[i]:min;
                }
            }
            // 没有面币值小于目标金额或者已经更新了min指
            temp[i]=min;
        }
        // 返回凑出money元的最少数量
        return temp[money];
    }

    // 滚动数组优化，原理和01背包优化一样，不过需要把01背包逆序的循环改为正序，
    public int leastCoinPro(int[] arr,int money){
        if (money==0){
            return 0;
        }
        // 小于0，直接凑不出
        if (money<0){
            return Integer.MAX_VALUE;
        }
        // temp[i] 储存凑i元的最少硬币数量
        int[] temp=new int[money+1];

        // 最初temp需要硬币数量无穷大，不然默认为0.min（0，1）取到0不和逻辑
        Arrays.fill(temp, Integer.MAX_VALUE);
        // 初始值，0元0个
        temp[0]=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 1; j < money+1; j++) {
                if (j>=arr[i]){
                    temp[j]=Math.min(temp[j],temp[j-arr[i]]+1);
                }

            }
            System.out.println(Arrays.toString(temp));
        }

        // 返回凑出money元的最少数量
        return temp[money];
    }
}
