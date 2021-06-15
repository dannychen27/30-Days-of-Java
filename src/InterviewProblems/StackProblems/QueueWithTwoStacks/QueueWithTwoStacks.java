package InterviewProblems.StackProblems.QueueWithTwoStacks;

public class QueueWithTwoStacks {

    public static void main(String[] args) {
        // source: https://www.youtube.com/watch?v=7ArHz8jPglw&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=2

        // Tip: for challenging problems: make sure you understand the problem specifications
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("A");
        myQueue.enqueue("B");
        myQueue.enqueue("C");
        System.out.println(myQueue.peek()); // A
        System.out.println(myQueue.dequeue());  // A
        System.out.println(myQueue.dequeue());  // B
        System.out.println(myQueue.dequeue());  // C
    }
}
