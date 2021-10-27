package sword_to_offer;

public class _剑指Offer_26_树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 先序遍历树 A 中的每个节点A（对应函数 isSubStructure(A, B)）
        // 判断树 A 中 以A为根节点的子树 是否包含树 B 。（对应函数 recur(A, B)）
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
