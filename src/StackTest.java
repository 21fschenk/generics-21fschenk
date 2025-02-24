package src;
public class StackTest {
    public static void main(String[] args) {
        try {
            // Test stack with integers
            System.out.println("Testing Integer Stack:");
            GenericStack<Integer> intStack = new GenericStack<>(5);
            intStack.push(10);
            intStack.push(20);
            intStack.push(30);
            System.out.println("Stack elements: " + intStack.list());
            System.out.println("Peek element: " + intStack.peek());
            System.out.println("Popped: " + intStack.pop());
            System.out.println("Stack after pop: " + intStack.list());

            // Test stack with strings
            System.out.println("\nTesting String Stack:");
            GenericStack<String> stringStack = new GenericStack<>(3);
            stringStack.push("Alice");
            stringStack.push("Bob");
            stringStack.push("Charlie");
            System.out.println("Stack elements: " + stringStack.list());
            System.out.println("Peek element: " + stringStack.peek());
            System.out.println("Popped: " + stringStack.pop());
            System.out.println("Stack after pop: " + stringStack.list());

            // Exception test - popping empty stack
            System.out.println("\nTesting StackEmptyException:");
            GenericStack<Double> emptyStack = new GenericStack<>(2);
            emptyStack.pop(); // Should throw exception

        } catch (StackFullException e) {
            System.err.println("Stack is full: " + e.getMessage());
        } catch (StackEmptyException e) {
            System.err.println("Stack is empty: " + e.getMessage());
        }
    }
}
