package algorithm;

import java.util.Stack;
/**
 * Created by leochou on 2019/10/20.
 */
public class BiStackList {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size()>0)
            return stack2.pop();
        if (stack1.size()==1)
            return stack1.pop();
        while(stack1.size()!=0) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    
    public static void main(String[] args) {
        BiStackList list = new BiStackList();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.print(list.pop());
        System.out.print(list.pop());
        list.push(4);
        System.out.print(list.pop());
        list.push(5);
        System.out.print(list.pop());
        System.out.print(list.pop());
    }
}