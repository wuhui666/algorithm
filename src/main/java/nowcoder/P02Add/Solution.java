package nowcoder.P02Add;

/**
 * 不用加减乘除做加法
 * */
/**
 *     第1步（忽略进位）：0＋0＝0，0＋1＝1，1＋0＝1，1＋1＝0，典型的异或运算。
 *     第2步：很明显，只有1＋1会向前产生进位1，相对于这一数位的进位值为10，而10＝(1&1)<<1。
 *     第3步：将第1步和第2步得到的结果相加，其实又是在重复这2步，直到不再产生进位为止。
 */
public class Solution {
    public int Add(int num1,int num2) {
        if (num2==0){
            return num1;
        }
        return Add(num1^num2, (num1&num2)<<1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().Add(13, 11));
    }
}