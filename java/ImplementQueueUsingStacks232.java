import java.util.ArrayDeque;

/*
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
*/
public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        System.out.println(queue.peek());
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

class MyQueue {
    final ArrayDeque<Integer> main;
    final ArrayDeque<Integer> sub;

    public MyQueue() {
        this.main = new ArrayDeque<>();
        this.sub = new ArrayDeque<>();
    }

    public void push(int x) {
        main.addLast(x);
    }

    public int pop() {
        while (!main.isEmpty()) sub.addLast(main.removeLast());
        int res = sub.removeLast();
        while (!sub.isEmpty()) main.addLast(sub.removeLast());
        return res;
    }

    public int peek() {
        while (!main.isEmpty()) sub.addLast(main.removeLast());
        int res = sub.peekLast();
        while (!sub.isEmpty()) main.addLast(sub.removeLast());
        return res;
    }

    public boolean empty() {
        return main.isEmpty();
    }
}
