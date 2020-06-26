package nowcoder.P12NumberOf1;

/**  二进制中1的个数
 * @author: wuhui
 * @time: 2019/9/5 22:32
 * @desc:
 */
public class Solution {
    public int NumberOf1(int n) {
        int oneCount=0;
        int tmp=0;
        // 如果为负数，先左移再右移动（补零），去掉负数符号位,
        // （111010...101 -->  011010...101），少了负数符号位的1，初始1数量要设为1，
        // 相当于变成负数相反数
        if (n<0){
            n=n<<1;
            n=n>>>1;
            oneCount=1;
        }
        // 此时n一定为正整数
        while (n!=0){

            tmp=n;
            n=n>>1;
            // 如果减小的不止为一半，说明右移动移出来了1
            if (tmp>2*n){
                ++oneCount;
            }
        }
        return oneCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1(10));
    }
}
