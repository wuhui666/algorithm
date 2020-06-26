package nowcoder.P20CutRope;

/**   剪绳子
 * @author: wuhui
 * @time: 2019/9/14 22:21
 * @desc:
 * 完全背包问题，因为割出多个长度为x的绳子，相当于物品可以重复拿，
 * 共target种物品（长度1到target），每种物品为价值为它的长度，体积也是它的长度，
 * 总价值是所选长度乘积
 * 注意：由于题目要求不能为一段，即直接把绳子总长度当为最大乘积无效，要稍作判断下
 */
public class Solution {

    public int cutRope(int target) {
        if (target==0){
            return 0;
        }
        // 滚动数组，temp[i]表示容量为i（绳子总长）能获得的最大价值（乘积）
        int[] temp=new int[target+1];
        temp[0]=1;
        for (int i = 1; i <= target; i++) {
            // 完全背包正序遍历
            for (int j = 1; j <= target; j++) {
                // 如果容量足够，可以拿
                if (j>=i){
                    // 把绳子总长度当为最大乘积无效，不更新
                    if (j==i&&j==target){
                        continue;
                    }
                    else {
                        temp[j]=Math.max(temp[j],temp[j-i]*i);
                    }

                }
                // 如果容量不足够，啥也不做，不更新
            }
        }
        return temp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cutRope(8));
    }
}
