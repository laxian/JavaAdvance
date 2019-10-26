package algorithm;

/**
 * Created by leochou on 2019/10/20.
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindByTail {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head==null)
            return null;
        int len = 0;
        ListNode p = head;
        do {
            len++;
            p=p.next;
        } while (p != null);
        if (k>len){
            return null;
        }
        int i = len - k;
        p=head;
        while (i > 0) {
            i--;
            p = p.next;
        }

        return p;
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
        ListNode r= FindKthToTail(n, 1);
        System.out.println(n);
    }
}