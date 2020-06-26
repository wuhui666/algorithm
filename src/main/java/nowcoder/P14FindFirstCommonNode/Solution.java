package nowcoder.P14FindFirstCommonNode;

import java.util.concurrent.Phaser;

/** 两个链表的第一个公共结点
 * @author: wuhui
 * @time: 2019/9/6 16:22
 * @desc: 我能想到的就是暴力
 *
 */
public class Solution {
    // 大佬解法
    //长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
    //长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
       while (p1!=p2){
           p1=(p1==null)?pHead2:p1.next;
           p2=(p2==null)?pHead1:p2.next;
       }
       return p1;
    }

    // 尝试类比数组第一个相等，可惜不满足第一个后面元素一定重合，所以数组长度相同时不对
    public int firstEqual(int[] a,int[] b){
        int[] aa = a;
        int[] bb = b;

        int ai=0,bi=0;
        while (aa[ai]!=bb[bi]){
            if (ai+1>=aa.length){
                if (a.length==b.length){
                    return Integer.MIN_VALUE;
                }
                aa=b;
                ai=0;
            }
            else {
                ++ai;
            }
            if (bi+1>=bb.length){
                bb=a;
                bi=0;
            }
            else {
                ++bi;
            }
        }
        return aa[ai];
    }

    public static void main(String[] args) {
        //不能满足以下情况
        /*int[] a={1,2,3,4,5};
        int[] b={7,8,33,3,23};*/

        // 其他情况ok,总之这个算法对找第一个相等数组元素行不通
        int[] a={1,2,3,4,5};
        int[] b={7,8,33,3};
        System.out.println(new Solution().firstEqual(a,b));
    }
}
