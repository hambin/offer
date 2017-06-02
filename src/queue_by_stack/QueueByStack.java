package queue_by_stack;

import java.util.Stack;

/**
 * Created by bing on 2017/6/2.
 */
public class QueueByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int val){
        stack1.push(val);
    }
    public int pop(){
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new RuntimeException("Queue is Empty");
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args){
        QueueByStack queue = new QueueByStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
