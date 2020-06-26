package reciteWrite;

import Other.shame.ListNode;

/**
 * @author: wuhui
 * @time: 2019/10/4 17:52
 * @desc:
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 构造任意哨兵节点
        ListNode head=new ListNode(-999);
        // 维持一个前驱节点
        ListNode pre=head;
        while (l1!=null&&l2!=null){
            // pre指向总是l1与l2较小者，
            // 然后较小链表向后移动一个节点，另一个链表不动
            if (l1.val<=l2.val){
                pre.next=l1;
                l1=l1.next;
            }
            else {
                pre.next=l2;
                l2=l2.next;
            }
            // 更新前驱节点（pre实际上代表排好序的链表的最后一个节点）
            pre=pre.next;
        }
        // 谁先到达尾部就把最后一个节点（正好是pre）指向另外一条链表
        if (l1==null){
            pre.next=l2;
        }
        if (l2==null){
            pre.next=l1;
        }
        // 返回哨兵的next就是头节点
        return head.next;
    }
    public static void main(String[] args) {
        ListNode pre1=new ListNode(1);
        ListNode pre3=new ListNode(2);
        ListNode pre5=new ListNode(4);
        ListNode pre2=new ListNode(1);
        ListNode pre4=new ListNode(3);
        ListNode pre6=new ListNode(4);
        pre1.next=pre3;
        pre3.next=pre5;
        pre2.next=pre4;
        pre4.next=pre6;
        ListNode r=new MergeList().mergeTwoLists(pre1, pre2);
        while (r!=null){
            System.out.println(r.val);
            r=r.next;
        }

    }
}
