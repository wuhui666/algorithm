package reciteWrite;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.w3c.dom.NodeList;

import java.util.*;

/**
 * @author: wuhui
 * @time: 2019/10/2 15:01
 * @desc:
 */
class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class BinaryTree {
    //层次遍历
    public List<TreeNode> level(TreeNode root){
        List<TreeNode> nodes=new LinkedList<>();
        Queue<TreeNode> nodeQueue=new ArrayDeque<>();
        // 初始根入队，保证队列非空
        if (root!=null){
            nodeQueue.add(root);
        }
        while (!nodeQueue.isEmpty()){
            //新的根出队
            root=nodeQueue.remove();
            // 出队的根的孩子入队
            if (root.left!=null){
                nodeQueue.add(root.left);
            }
            if (root.right!=null){
                nodeQueue.add(root.right);
            }
            // 输出出队的根节点
            nodes.add(root);
        }
        return nodes;
    }

    //recursion
    public void pre(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }
    public void mid(TreeNode root){
        if (root==null){
            return;
        }
        mid(root.left);
        System.out.println(root.val);
        mid(root.right);
    }
    public void pos(TreeNode root){
        if (root==null){
            return;
        }

        pos(root.left);
        pos(root.right);
        System.out.println(root.val);
    }
    //iteration
    public List<TreeNode> prePro(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> nodes=new LinkedList<>();
        stack.push(root);
        TreeNode tmp=null;
        while (!stack.isEmpty()){
            tmp = stack.pop();
            nodes.add(tmp);
            // 先让右孩子（not null）入栈，保证左孩子在栈顶
            if (tmp.right != null) {
                stack.push(tmp.right);
            }

            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            
        }
        return nodes;
    }
    // leetcode大佬思路，服了
    /*接下来我们思考一下前序遍历和后序遍历之间的关系：
    前序遍历顺序为：根 -> 左 -> 右
    后序遍历顺序为：左 -> 右 -> 根
    如果1： 我们将前序遍历中节点插入结果链表尾部的逻辑，
    修改为将节点插入结果链表的头部
    那么结果链表就变为了：右 -> 左 -> 根
    如果2： 我们将遍历的顺序由从左到右修改为从右到左，配合如果1
    那么结果链表就变为了：左 -> 右 -> 根
    这刚好是后序遍历的顺序
    * */
    public List<TreeNode> posPro(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> nodes=new LinkedList<>();
        stack.push(root);
        TreeNode tmp=null;
        while (!stack.isEmpty()){
            tmp = stack.pop();
            // 头插
            nodes.add(0,tmp);
            // 先让左孩子（not null）入栈,
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }

        }
        return nodes;
    }
    // 不易理解
    public List<TreeNode> midPro(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> nodes=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            // 一直处理左孩子直到到达叶子节点使得root==null
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            // 如果当前root是作为对应父节点的左孩子而且null
            // 那么stack.pop();为其父节点,接着处理其父节点的右孩子
            // 如果当前root是作为对应父节点的右孩子而且null
            // 那么stack.pop();为其父节点的父节点，
            // 接着处理其父节点的的父节点右孩子
            root=stack.pop();
            nodes.add(root);
            root=root.right;
        }
        return nodes;
    }

    // #########推荐#################
    // 这个方法绝了，很好记效率高，通用前中后遍历，改下顺序即可
    /*使用boolean标记节点入栈时是根还是叶子节点，
    叶子节点为false，根节点为true。
    如果遇到的节点是作为叶子节点存在于栈中，
    则将其出栈（只是出栈，还会作为根再入一次栈），
    并且按照遍历顺序把该节点（此时该节点作为根入栈），
    其左右孩子入栈（作为叶子节点入栈）
    如果遇到的节点是作为根节点存在于栈中，则将节点出栈直接收集（输出或者加入链表）。
    *
    *标记思路：
    *可以搞个两个栈stack<TreeNode>和stack<Boolean>,做到出入栈同步
    *或者一个栈不用泛型，压入一个节点立马压入对应的boolean标记
    *
    *原理是把树每个节点作为根，找到左右孩子，合理入栈，保证出栈顺序，
    *然后对出栈的叶子节点循环这个逻辑，继续把它及其孩子这样处理
    *
    */
    public List<TreeNode> posProPlus(TreeNode root){
        // Object类型
        Stack<Object> stack=new Stack<>();
        List<TreeNode> nodes=new LinkedList<>();
        // 为空直接返回
        if (root==null){
            return nodes;
        }
        // 将根节点及其孩子按照逻辑入栈，保证栈不为空
        stack.push(root);
        stack.push(true);
        // 孩子不存在不用入栈
        if (root.right!=null){
            stack.push(root.right);
            stack.push(false);
        }
        if (root.left!=null){
            stack.push(root.left);
            stack.push(true);
        }
        // 根标记
        boolean asRoot;
        while (!stack.isEmpty()){
            //取出标记
            asRoot=(boolean) stack.pop();
            // 是作为根入的栈
            if (asRoot){
                // 直接出栈并收集
                nodes.add((TreeNode) stack.pop());
                // 继续循环
                continue;
            }
            // 是作为叶子入的栈，出栈并找到其左右孩子按照逻辑入栈
            else {
                root=(TreeNode)stack.pop();
            }
            stack.push(root);
            stack.push(true);
            // 孩子不存在不用入栈
            if (root.right!=null){
                stack.push(root.right);
                stack.push(false);
            }
            if (root.left!=null){
                stack.push(root.left);
                stack.push(true);
            }
        }
        return nodes;
    }
    public List<TreeNode> midProPlus(TreeNode root){

        // Object类型
        Stack<Object> stack=new Stack<>();
        List<TreeNode> nodes=new LinkedList<>();
        // 为空直接返回
        if (root==null){
            return nodes;
        }
        // 将根节点及其孩子按照逻辑入栈，保证栈不为空

        // 孩子不存在不用入栈
        if (root.right!=null){
            stack.push(root.right);
            stack.push(false);
        }
        stack.push(root);
        stack.push(true);
        if (root.left!=null){
            stack.push(root.left);
            stack.push(true);
        }
        // 根标记
        boolean asRoot;
        while (!stack.isEmpty()){
            //取出标记
            asRoot=(boolean) stack.pop();
            // 是作为根入的栈
            if (asRoot){
                // 直接出栈并收集
                nodes.add((TreeNode) stack.pop());
                // 继续循环
                continue;
            }
            // 是作为叶子入的栈，出栈并找到其左右孩子按照逻辑入栈
            else {
                root=(TreeNode)stack.pop();
            }

            // 孩子不存在不用入栈
            if (root.right!=null){
                stack.push(root.right);
                stack.push(false);
            }
            stack.push(root);
            stack.push(true);
            if (root.left!=null){
                stack.push(root.left);
                stack.push(true);
            }
        }
        return nodes;
    }
    public List<TreeNode> preProPlus(TreeNode root){

        // Object类型
        Stack<Object> stack=new Stack<>();
        List<TreeNode> nodes=new LinkedList<>();
        // 为空直接返回
        if (root==null){
            return nodes;
        }
        // 将根节点及其孩子按照逻辑入栈，保证栈不为空

        // 孩子不存在不用入栈
        if (root.right!=null){
            stack.push(root.right);
            stack.push(false);
        }

        if (root.left!=null){
            stack.push(root.left);
            stack.push(true);
        }
        stack.push(root);
        stack.push(true);
        // 根标记
        boolean asRoot;
        while (!stack.isEmpty()){
            //取出标记
            asRoot=(boolean) stack.pop();
            // 是作为根入的栈
            if (asRoot){
                // 直接出栈并收集
                nodes.add((TreeNode) stack.pop());
                // 继续循环
                continue;
            }
            // 是作为叶子入的栈，出栈并找到其左右孩子按照逻辑入栈
            else {
                root=(TreeNode)stack.pop();
            }

            // 孩子不存在不用入栈
            if (root.right!=null){
                stack.push(root.right);
                stack.push(false);
            }

            if (root.left!=null){
                stack.push(root.left);
                stack.push(true);
            }
            stack.push(root);
            stack.push(true);
        }
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(3);
        TreeNode node3=new TreeNode(20);
        node3.left=new TreeNode(15);
        node3.right=new TreeNode(7);
        node.left=new TreeNode(9);
        node.right=node3;
        //new BinaryTree().pre(node);
        List<TreeNode> list=new BinaryTree().posProPlus(node);
        for(TreeNode n:list){
            System.out.println(n.val);
        }
    }

}
