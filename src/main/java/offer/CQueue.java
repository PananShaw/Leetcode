package offer;

import java.util.Stack;

/**
 * @author shaw
 * @describe 剑指 Offer 09. 用两个栈实现队列
 * @date 2021/07/09 14:28
 */
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        } else {
            return stack2.pop();
        }
    }
}