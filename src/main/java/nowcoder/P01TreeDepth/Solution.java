package nowcoder.P01TreeDepth;

/**二叉树的深度
 * @author: wuhui
 * @time: 2019/8/24 17:56
 * @desc:
 *
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth=TreeDepth(root.left)+1;
        int rightDepth=TreeDepth(root.right)+1;
        return leftDepth>=rightDepth?leftDepth:rightDepth;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        node3.left=new TreeNode(4);
        node.left=new TreeNode(2);
        node.right=node3;
        System.out.println(new Solution().TreeDepth(node));
    }
}