package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        //new一个返回list 用以装载层序遍历的返回结果
        List<List<Integer>> res = new ArrayList<>();
        //使用队列对节点进行遍历，把每一层的节点依次放入队列中，一层遍历完刚好一层出队并把这层的下一层入队
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //先把根节点放入
        queue.add(root);
        //开始遍历 入队出队
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
