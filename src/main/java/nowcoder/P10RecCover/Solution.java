package nowcoder.P10RecCover;

/** 矩形覆盖
 * @author: wuhui
 * @time: 2019/9/5 21:11
 * @desc: ，枚举前几个找出规律，斐波拉契数列
 */
public class Solution {
    public int RectCover(int target) {
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
}
