package src;
import java.util.Arrays;

/**
 * A generic stack implementation using an array.
 * Supports push, pop, peek, and list methods.
 * @param <T> The type of elements stored in the stack.
 */
public class GenericStack<T> {
    private Object[] elements;
    private int size;
    private int capacity;

    /**
     * Default constructor with a default capacity of 10.
     */
    public GenericStack() {
        this.capacity = 10;
        this.size = 0;
        this.elements = new Object[this.capacity];
    }

    /**
     * Constructor that allows setting a custom stack size.
     * @param capacity The maximum number of elements the stack can hold.
     */
    public GenericStack(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be greater than 0");
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    /**
     * Pushes an element onto the stack.
     * @param item The item to push.
     * @throws StackFullException If the stack is full.
     */
    public void push(T item) throws StackFullException{
        if (size >= capacity) {
            throw new StackFullException("Stack is full, can't push more elements.");
        }
        elements[size++] = item;
    }

    /**
     * Pops the top element from the stack.
     * @return The removed element.
     * @throws StackEmptyException If the stack is empty.
     */
    public T pop() throws StackEmptyException {
        if (size == 0) {
            throw new StackEmptyException("Stack is empty, cannot pop element.");
        }
        T item = (T) elements[--size];
        elements[size] = null; // Remove reference for GC
        return item;
    }

    /**
     * Returns the top element without removing it.
     * @return The top element of the stack.
     * @throws StackEmptyException If the stack is empty.
     */
    public T peek() throws StackEmptyException {
        if (size == 0) {
            throw new StackEmptyException("Stack is empty, cannot peek.");
        }
        return (T) elements[size - 1];
    }

    /**
     * Returns a semicolon-separated string of all elements.
     * @return A string representation of the stack elements.
     */
    public String list() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    /**
     * Checks if the stack is empty.
     * @return True if empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the stack is full.
     * @return True if full, false otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Returns the current size of the stack.
     * @return The number of elements in the stack.
     */
    public int getSize() {
        return size;
    }
}

    /**
     * Exception thrown when trying to push onto a full stack.
    */
    class StackFullException extends Exception {
        public StackFullException(String message) {
            super(message);
        }
    }

    /**
    * Exception thrown when trying to pop from an empty stack.
    */
    class StackEmptyException extends Exception {
        public StackEmptyException(String message) {
            super(message);
        }
    }

