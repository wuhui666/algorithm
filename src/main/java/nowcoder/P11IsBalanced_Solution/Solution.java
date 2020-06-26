package nowcoder.P11IsBalanced_Solution;

/** 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author: wuhui
 * @time: 2019/9/5 21:35
 * @desc:
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        // 空树直接为真
        if (root==null){
            return true;
        }
        // 判断左右子树是否为avl
        if (!IsBalanced_Solution(root.left)){
            return false;
        }
        if (!IsBalanced_Solution(root.right)){
            return false;
        }
        // 判断左右子树深度差距是否大于1
        // 孩子节点为空，深度当作0，否则加一
        int leftDepth=root.left==null?0:root.left.val+1;
        int rightDepth=root.right==null?0:root.right.val+1;
        // 叶子节点值为0，反着向上层推，节点值表示该节点到叶子节点的深度

        //把左右孩子较大的节点值+1（深度加一）赋值给父节点
        root.val=Math.max(leftDepth,rightDepth);

        // 如果左右深度差异小于1，返回真
        return root.val - Math.min(leftDepth,rightDepth) <= 1;

    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(0);
        TreeNode node2=new TreeNode(0);
        TreeNode node3=new TreeNode(0);
        TreeNode node4=new TreeNode(0);
        TreeNode node5=new TreeNode(0);
        TreeNode node6=new TreeNode(0);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node5.left=node6;

        System.out.println(new Solution().IsBalanced_Solution(node1));
    }
}
