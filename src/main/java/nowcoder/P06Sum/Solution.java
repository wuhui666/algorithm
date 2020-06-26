package nowcoder.P06Sum;

/**求1+2+3+...+n
 * @author: wuhui
 * @time: 2019/9/4 16:26
 * @desc:
 */
public class Solution {
    public int Sum_Solution(int n) {

        return ((int)Math.pow(n,2)-n)>>1;
    }
    public int Sum_SolutionPro(int n) {
        int ans = n;
        boolean t=((ans!=0) && ((ans += Sum_Solution(n - 1))!=0));
        return ans;
    }
}
