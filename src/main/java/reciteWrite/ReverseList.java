package reciteWrite;

import Other.shame.ListNode;

/**
 * @author: wuhui
 * @time: 2019/10/3 22:27
 * @desc:
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {

        // 代表前一个节点
        ListNode pre=null;
        ListNode pos=null;
        while (head!=null){
            // 备份后一个节点
            pos= head.next;
            // 指向前一个节点
            head.next=pre;
            //当前节点作为下一次pre
            pre=head;
            // 后一个节点作为下一次head
            head=pos;

        }
        // 退出循环时候head为null,返回pre就好了
        return pre;
    }
}
