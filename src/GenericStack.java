package src;
import java.util.Arrays;
import java.util.Objects;

public class GenericStack<T> {
    private Objects[] elements;
    private int size;
    private int capacity;

    public GenericStack() {
        this.capacity = 10;
        this.size = 0;
        this.elements = new Objects[this.capacity];
    }


}
