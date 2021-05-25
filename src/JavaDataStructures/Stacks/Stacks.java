package JavaDataStructures.Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Stacks {

    public static void main(String[] args) {
        // Stacks are a FILO (first in, last out) data structure
        // Queues are a FIFO (first in, first out) data structure

        // collections framework:
        // https://www.google.com/search?q=java+collections&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjNkbXD--LwAhUQEVkFHYsSA74Q_AUoAXoECAEQAw&biw=1057&bih=596#imgrc=9y1dAwSKTzjgnM&imgdii=6Mt3181dFDlHeM
        // https://www.google.com/search?q=java+collections&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjNkbXD--LwAhUQEVkFHYsSA74Q_AUoAXoECAEQAw&biw=1057&bih=596#imgrc=6Mt3181dFDlHeM&imgdii=UiFJkBkuwIvDFM

        // creating a stack
        Stack<String> stack = new Stack<>();
        List<String> phrases = Arrays.asList("Hello", "Goodbye", "Diffusers");

        // add items to stack
        for (String phrase : phrases) {
            stack.push(phrase);
        }
        // TODO: insertElementAt(String obj, int index)
        // TODO: stack.add(String e)
        // TODO: stack.add(int index, String element);

        // get items from stack
        System.out.println(stack.isEmpty()); // false -- thread safe version of empty
        System.out.println(stack.empty()); // false -- this is thread unsafe

        int stackSize = stack.size();
        System.out.println(stackSize);  // 3
        System.out.println(stack.peek()); // Diffusers
        System.out.println(stack.capacity()); // 10 (the default capacity)

        // search for items in a stack
        System.out.println(stack.search("Diffusers")); // 1 (1-based indexing in stack list)
        System.out.println(stack.indexOf("Diffusers")); // 2 (position in stack array)
        System.out.println(stack.lastIndexOf("Diffusers")); // 2 (position in stack array)
        // todo: lastIndexOf(Object o, int index)
        // todo: stack.indexOf(Object o, int index)

        // traversing through items in a stack
        for (String phrase : stack) {
            System.out.println(phrase); // Hello, Goodbye, Diffusers
        }

        // modify items in stack
        Object stack2 = stack.clone();
        System.out.println(stack2); // [Hello, Goodbye, Diffusers]

        // remove items from stack
        System.out.println(stack.pop());  // Diffusers

        // TODO: remove(int index)
        // TODO: remove(Object o)

        // TODO: removeFirst(int index)
        // TODO: removeFirst(Object o)

        // TODO: removeElementAt(int index)
        // TODO: removeElement(Object o)

        stack.clear();
        System.out.println(stack); // []

        // NOTES:
        // - overloading -- same function name, same purpose, different set of arguments

    }
}
