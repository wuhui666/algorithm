package reciteWrite;

/**
 * @author: wuhui
 * @time: 2019/10/4 21:24
 * @desc:
 */
public class BuildByPreAndMid {
    int[] preorder;
    int[] inorder;
    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]={2,3,1};
        TreeNode root=new BuildByPreAndMid().buildTree(a,b);
        System.out.println(root.val);
        System.out.println(root.right);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);

    }
    /*
    * 前序遍历 preorder = [3,9,20,15,7]
    中序遍历 inorder = [9,3,15,20,7]
    * */
    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length<=0) {
            return null;
        }
        preorder=pre;
        inorder=in;
        return build(0, pre.length-1, 0, in.length-1);

    }
    public TreeNode build(int preStart,int preEnd,int inStart,int inEnd){

        TreeNode root=new TreeNode(preorder[preStart]);
        //如果范围内不是只有一个元素
        if (preStart!=preEnd){
            for (int i = inStart; i <=inEnd ; i++) {
                // 寻根
                if (inorder[i]==preorder[preStart]){
                    // 左边长度
                    int len=i-inStart;
                    // 构建左子树
                    // 前序：根节点+1位置到根节点+len位置
                    // 中序：当前inStart位置到i-1（根节点位置前面一个）
                    if (preStart+1<=preEnd&&inStart<=i-1){//越界检查
                        root.left=build(preStart+1,preStart+len,inStart, i-1);
                    }
                    // 构建右子树
                    // 前序：根节点+len+1位置到当前preEnd位置
                    // 中序：从i+1（根节点位置后面一个）到当前的inEnd位置
                    if (preStart+len+1<=preEnd&&i+1<=inEnd){//越界检查
                        root.right=build(preStart+len+1,preEnd,i+1, inEnd);
                    }

                    return root;
                }

            }

        }
        //范围内只有一个元素。直接返回当前根节点
        return root;

    }
}
