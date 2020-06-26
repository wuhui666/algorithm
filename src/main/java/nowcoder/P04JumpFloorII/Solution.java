package nowcoder.P04JumpFloorII;

/** 变态跳台阶
 *
 * 1 1 1
 *  2 2 11,2
 *  3 4 111,12,21,3
 *  4 8 1111,211,121,112,22,31,13,4
 *  5 16
 *      11111,2111,1211,1121,1112,221,212,122,
 *      311,131,113,32,23,41,14,5
 * @author: wuhui
 * @time: 2019/8/25 22:14
 * @desc:
 */
public class Solution {
    public int JumpFloorII(int target) {
     return 2<<target-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorII(4));
    }
}
