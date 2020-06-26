package nowcoder.P18EntryForLoopList;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuhui
 * @time: 2019/9/14 17:00
 * @desc:
 * 两个结论：
 * 1、设置快慢指针，假如有环，他们最后一定相遇。
 * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
 * 证明结论1：设置快慢指针fast和low，fast每次走两步，low每次走一步。
 * 假如有环，两者一定会相遇（因为low一旦进环，可看作fast在后面追赶low的过程，每次两者都接近一步，最后一定能追上）。
 * 证明结论2：
 * 设：
 * 链表头到环入口长度为--a
 * 环入口到相遇点长度为--b
 * 相遇点到环入口长度为--c
 *
 * 则：相遇时
 * 快指针路程=a+(b+c)k+b ，k>=1  其中b+c为环的长度，k为绕环的圈数（k>=1,即最少一圈，
 * 不能是0圈，不然和慢指针走的一样长，矛盾）。
 * 慢指针路程=a+b
 * 快指针走的路程是慢指针的两倍，所以：
 * （a+b）*2=a+(b+c)k+b
 * 化简可得：
 * a=(k-1)(b+c)+c 这个式子的意思是：
 * 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。其中k>=1,所以k-1>=0圈。
 * 所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
 */
public class Solution {
    // 双指针，复杂度 N
    public ListNode EntryNodeOfLoopPro(ListNode pHead){

        if (pHead == null||pHead.next==null) {
            return null;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;

        while (true){
            slow=slow.next;
            // 说明没环
            if (fast.next==null&&fast.next.next==null){
                return null;
            }
            fast=fast.next.next;
            // 说明有环
            if (fast==slow){
                break;
            }
        }
        // 将其中一个指针指向表头，另一个指向相遇点
        fast=pHead;
        while (fast!=slow) {
            // 修改速度为一样
            slow=slow.next;
            fast=fast.next;
        }
        // 返回相遇点即为入口
        return fast;
    }
    // 我的暴力 N2
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null||pHead.next==null) {
            return null;
        }
        List<ListNode> nodes=new ArrayList<>();
        while (pHead.next!=null){
            if (nodes.contains(pHead.next)){
                return pHead.next;
            }
            nodes.add(pHead);
            pHead=pHead.next;
        }
        return null;
    }

}
