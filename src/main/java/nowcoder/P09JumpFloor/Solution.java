package nowcoder.P09JumpFloor;

/** 跳台阶
 * @author: wuhui
 * @time: 2019/9/5 17:07
 * @desc: 说白了就是斐波拉契数列
 */
public class Solution {
    // Dp
    public int JumpFloorDp(int target) {
        if (target==0){
            return 0;
        }
        if (target==1){
            return 1;
        }
        if (target==2){
            return 2;
        }
        int[] temp=new int[target+1];
        // 0级阶梯只有一种跳法：不跳
        temp[0]=1;
        temp[1]=1;
        temp[2]=2;
        for (int i = 2; i <= target; i++) {
                temp[i]=temp[i-1]+temp[i-2];
        }
        return temp[target];
    }
    // 递归
    public int JumpFloor(int target) {
        if (target==0){
            return 0;
        }
        if (target==1){
            return 1;
        }
        if (target==2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
    // 1 2 3 5 8
    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorDp(3));
    }
}
