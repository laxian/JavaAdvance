package algorithm;

/**
 * Created by leochou on 2019/10/20.
 */


public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {

        // p往后遍历
        ListNode p = head;
        // h备用
        ListNode h = null;
        while (p != null){
            // 备份下下
            ListNode pn = p.next;
            if (p==head) {
                p.next = null;
                h=p;
            }
            else {
                p.next = h;
                h=p;
            }
            p=pn;
        }
        return h;
    }
    
    public static void main(String[] args) {

        ListNode n = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        ListNode listNode = ReverseList(n);
        System.out.println(listNode);
    }
}