package hundred_algorithms;

import java.util.Stack;

/**
 * Created by bing on 2017/9/6.
 *
 * 设计包含min 函数的栈。
 * 定义栈的数据结构，要求添加一个min 函数，能够得到栈的最小元素。
 * 要求函数min、push 以及pop 的时间复杂度都是O(1)。
 * 思路：设计栈的元素同时包含当前值和当前最小值，这样当pop掉最小值的时候，栈顶元素依然保存着当前最小值
 * 或者直接用两个栈，一个存数据，一个存最小值
 */
public class AddMinForStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public int min(){
        return minStack.peek();
    }

    public void push(int data){
        dataStack.push(data);
        if(minStack.isEmpty()){
            minStack.push(data);
        }else if(data < min()){
            minStack.push(data);
        }else{
            minStack.push(min());
        }
    }

    public int pop(){
        minStack.pop();
        return dataStack.pop();
    }

    public static void main(String[] args){

        AddMinForStack addMinForStack = new AddMinForStack();
        addMinForStack.push(6);
        addMinForStack.push(3);
        System.out.println(addMinForStack.min());
    }
}
