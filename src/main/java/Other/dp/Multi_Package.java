package Other.dp;

import java.util.Arrays;

/**    多重背包问题（即物品数量有限制，只能取若干次）
 * 有n种物品与承重为weight的背包。每种物品有有限件num[i]，
 * 每个物品都有对应的重量weight[i]与价值value[i]，
 * 求解如何装包使得价值最大。
 * @author: wuhui
 * @time: 2019/9/3 10:20
 * @desc: 这里是直接遍历每种物品的个数，可以参照二进制的思想改造，百度吧，略了
 */
public class Multi_Package {

    public static void main(String[] args) {
        int[] w={2,3,5};
        int[] v={3,2,7};
        int[] nums={2,3,3};
        int n=3;
        int weight=10;
        Multi_Package multi_package=new Multi_Package();
        System.out.println(multi_package.maxValue(weight, nums, w, v));
    }
    public int maxValue(int weight,int[] nums,int[] w,int[] v){
        int[] temp=new int[weight+1];
        // 前i种物品
        for (int i = 0; i < w.length; i++) {
            // 该类物品全部数量选取容量装不下，则取不完该物品。类似物品数量无限制，完全背包模板解法
            if (nums[i] * w[i] >= weight) {
                // -------------完全背包----------------
                // 遍历该类物品的该类取法的不同容量的最大值
                for (int k = 1; k <= weight; k++) {
                    // 容量足够
                    if (k - w[i] >= 0) {
                        // 取与不取择优
                        temp[k] = Math.max(temp[k], temp[k - w[i]] + v[i]);
                    }
                    // 容量不够，则相当于不取
                }
                // -------------完全背包----------------
            }
            // 可以取完该物品。类似物品数量有限制，把相同类型物品看成不同
            // 物品，每件物品只能取一次或者不取，转化为01背包解法
            else {
                //遍历该种物品的取法情况，取0个，取1个。。。。取nums[i]个，对应的容量消耗j*w[i]，价值增加j*v[i]
                for (int j = 0; j <= nums[i]; j++) {
                    // -------------01背包----------------
                    for (int k = weight; k >=j*w[i]; k--) {
                        temp[k] = Math.max(temp[k], temp[k - j*w[i]] + j*v[i]);
                    }
                    // -------------01背包----------------
                }
            }
            // 打印每次迭代更新好的滚动一维数组即是我们填好的表格
            System.out.println(Arrays.toString(temp));
        }
        return temp[weight];
    }
}
