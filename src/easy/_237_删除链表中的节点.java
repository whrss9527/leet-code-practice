package easy;

public class _237_删除链表中的节点 {
    // 将本节点的值替换为下一个节点，然后直接指向下下个节点。（替换）
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
