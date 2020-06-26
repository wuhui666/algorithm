package nowcoder.P07StackQueue;

import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**用两个栈实现队列
 * @author: wuhui
 * @time: 2019/9/4 16:47
 * @desc:
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // mine
   /* public void push(int node) {
        stack2.push(node);
        stack1.clear();
        Stack<Integer> tmp=new Stack<Integer>();
        stack2.forEach(tmp::push);
        while (!tmp.isEmpty()){
            stack1.push(tmp.pop());
        }

    }

    public int pop() {
        int res=stack1.pop();
        stack2.clear();
        Stack<Integer> tmp=new Stack<Integer>();
        stack1.forEach(tmp::push);
        while (!tmp.isEmpty()){
            stack2.push(tmp.pop());
        }
        return  res;
    }*/

   // pro
    public void push(int node) {
        // 接收新元素
        stack1.push(node);
    }

    public int pop() {
        // 当stack1没有新元素且stack2已经出栈完说明为空
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        // 当stack2出栈完所有元素才继续把stack1的新元素push进来
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        // 当stack2不为空，直接出栈直到为空才继续把stack1的新元素push进来
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());

    }

}
