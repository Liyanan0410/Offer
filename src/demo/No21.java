package demo;
import java.util.Stack;

public class No21 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(node < min){
            temp.push(node);
            min = node;
        }
        else
            temp.push(min);
    }

    public void pop() {
        stack.pop();
        temp.pop();
    }

    public int top() {
        int t = stack.pop();
        stack.push(t);
        return t;
    }

    public int min() {
        int m = temp.pop();
        temp.push(m);
        return m;
    }
}
