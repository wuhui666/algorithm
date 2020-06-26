package nowcoder.P03Mirror;

import nowcoder.P01TreeDepth.TreeNode;

/**二叉树的镜像
 * @author: wuhui
 * @time: 2019/8/24 17:56
 * @desc:
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if (root==null){
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        node3.left=new TreeNode(4);
        node.left=new TreeNode(2);
        node.right=node3;
        new Solution().Mirror(node);
        System.out.println(node.left.val);
    }
}