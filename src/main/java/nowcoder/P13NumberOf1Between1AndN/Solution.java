package nowcoder.P13NumberOf1Between1AndN;

/**  整数中1出现的次数
 * @author: wuhui
 * @time: 2019/9/6 10:23
 * @desc:
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        StringBuffer buffer=new StringBuffer();
        for (int i = 1; i <= n; i++) {
            buffer.append(i);
        }
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == '1') {
                ++count;
            }
        }
        return count;
    }
    public int NumberOf1Between1AndN_SolutionPro(int n) {
        /*int len=String.valueOf(n).length();
        if (len==1){
            return 1;
        }
        int max=(int)Math.pow(10, len-1);
        if (String.valueOf(n).charAt(0)==1){
            return NumberOf1Between1AndN_SolutionPro(max-1)+(n-max+1)+NumberOf1Between1AndN_SolutionPro(n-max);
        }
        if (String.valueOf(n).charAt(0)>1){
            return NumberOf1Between1AndN_SolutionPro(max-1)+(n-max+1)+NumberOf1Between1AndN_SolutionPro(n-max);
        }*/
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1Between1AndN_Solution(21));
    }
}
