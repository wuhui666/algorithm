package nowcoder.P08MaxSumOfSubArray;

/**
 * 连续子数组的最大和
 * @author: wuhui
 * @time: 2019/9/4 21:59
 * @desc:
 */
public class Solution {
    public static void main(String[] args) {
        int arr[]={2,-13,4,7,-15,1,2,2};
        //int arr[]={1,-2,3,4,-3};
        //System.out.println(new Solution().FindGreatestSumOfSubArray(arr));
        System.out.println(new Solution().FindGreatestSumOfSubArrayPro(arr));
    }
    // 暴力
    public int FindGreatestSumOfSubArray(int[] array) {

        // 负无穷
        int max=Integer.MAX_VALUE+1;

        // n个数字，子数组有n类型（长度1---n）
     for (int i = 1; i <= array.length; i++) {
            int sum;
            // 子数组长度i，在连续的情况下，只有array.length-i种组合
           // 例如 i=1，有n种情况，i=2，有n-1种情况
            for (int j =array.length-i; j >=0 ; j--) {
                sum=0;
                // k表示当子数组个数为i时，子数组第一个一个元素在array的下标
                // 例如 i=1，加一次，i=2，每种情况加2次
                for (int k = j; k < j+i ; k++) {
                    sum+=array[k];
                }
                // 子数组长度i的每种情况的最大值，到最后也是n类型子数组的最大值
                max=sum>max?sum:max;
            }
        }
        return max;
    }
    // 推荐，好理解
    public int FindGreatestSumOfSubArrayPro(int[] array) {
     int sum=array[0];
     int max=array[0];
     for (int i = 1; i <array.length; i++) {
         // 加了还不如不加,即sum+array[i]<array[i]，
         // 并且array[i]的值大于当前max，  不然4,7,-15,1会把max设为1，而不是11
         // 说明前面可以不要了，直接max=array[i];
        if (sum<=0&&array[i]>max){
            max=array[i];
            sum=array[i];
        }
        // 否则继续增加sun
        else{
            sum+=array[i];
        }
        // 更新max
         if (sum>max){
             max=sum;
         }
     }
        return max;
    }

    // dp 转移方程不容易想到，可以看看
    public int FindGreatestSumOfSubArrayDp(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }


}
