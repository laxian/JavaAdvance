package algorithm;

/**
 * Created by leochou on 2019/10/20.
 */
public class MergeList {


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null || list2 != null) {
            ListNode one = null;
            if (list1 == null) {
                one = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                one = list1;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                one = list1;
                list1 = list1.next;
            } else {
                one = list2;
                list2 = list2.next;
            }

            // one is the smaller one of current loop
            p.next=one;
            p=p.next;
        }
        return head.next;
    }
}