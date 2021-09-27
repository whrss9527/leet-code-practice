package sword_to_offer;

public class _剑指Offer_II_077_链表排序_practice {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode l = new ListNode(0), p = l;

        while (left != null && right != null) {
            if (left.val<right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;

        }
        if(left != null){
            p.next = left;
        }
        if(right != null){
            p.next = right;
        }
        return l.next;
    }
}
