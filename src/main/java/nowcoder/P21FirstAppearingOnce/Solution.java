package nowcoder.P21FirstAppearingOnce;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**  字符流中第一个不重复的字符
 * @author: wuhui
 * @time: 2019/9/14 23:27
 * @desc:
 * 思路：时间复杂度O（1），空间复杂度O（n）
 *         1、用一个128大小的数组统计每个字符出现的次数
 *         2、用一个队列，如果第一次遇到ch字符，则插入队列；其他情况不在插入
 *         3、求解第一个出现的字符，判断队首元素是否只出现一次，如果是直接返回，否则删除继续第3步骤
 */
public class Solution {

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(String string) {
        int[] countArr = new int[128];
        char[] chars = string.toCharArray();
        Queue<Character> queue = new ArrayBlockingQueue<>(128);
        for (int i = 0; i < chars.length; i++) {
            ++countArr[chars[i]];
            if (countArr[chars[i]] == 1) {
                queue.add(chars[i]);
            }

        }
        while (!queue.isEmpty() && countArr[queue.peek()] != 1) {
            queue.remove();
        }
        return queue.peek();
    }
    // 自己写的好傻逼
    public char test(String s)
    {
        char[] chars = s.toCharArray();
        Map<Character,String> map=new HashMap<>();
        for (Integer i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==null){
                map.put(chars[i],1+","+i.toString());
            }
            else {
                String count=map.get(chars[i]).split(",")[0];
                String pos=map.get(chars[i]).split(",")[1];
                map.put(chars[i], (Integer.valueOf(count) + 1) +pos);
            }

        }
        Set<Map.Entry<Character, String>> entries = map.entrySet();
        String count,pos;
        String min=""+s.length();
        for (Map.Entry<Character, String> entry : entries) {
            count=entry.getValue().split(",")[0];
            if (count.equals("1")){
                pos=entry.getValue().split(",")[1];
                min=pos.compareTo(min)<0?pos:min;
            }
        }
        String v="1"+","+min;
        Set<Character> characters = map.keySet();
        for (Character character : characters) {
            if (map.get(character).equals(v)){
                return character;
            }
        }
        return '#';

    }

    public static void main(String[] args) {
        //System.out.println(new Solution().test("google"));
        System.out.println(new Solution().FirstAppearingOnce("google"));
    }
}
