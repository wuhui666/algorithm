package nowcoder.P19LeftRotateString;

/** 左旋转字符串
 * @author: wuhui
 * @time: 2019/9/14 22:06
 * @desc:
 */
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str.length()==0){
            return str;
        }
        // 如果n大于字符串长度，将n变为取模后余数
        if (str.length()<n){
            n=n%str.length();
        }
        return str.substring(n, str.length())+str.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LeftRotateString("123", 2));
    }
}
