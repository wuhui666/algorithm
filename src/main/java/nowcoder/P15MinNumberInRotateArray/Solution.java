package nowcoder.P15MinNumberInRotateArray;

/** 旋转数组的最小数字
 * @author: wuhui
 * @time: 2019/9/14 16:42
 * @desc:
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        // 为空返回0
        if (array.length==0){
            return 0;
        }
        //找到不满足升序的第一个元素既是最小
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1]){
                return array[i+1];
            }
        }
        // 说明升序
        return array[0];
    }

    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        System.out.println(new Solution().minNumberInRotateArray(arr));
    }
}
