package stack


class Stack {
    int size
    int capacity
    int[] elements

    static Make(int capacity) {
        new Stack(capacity)
    }

    private Stack(int capacity) {
        this.capacity = capacity
        this.elements = new int[capacity]
    }

    boolean isEmpty() {
        true
    }

    int size() {
        this.size;
    }

    void push(int element) {
        if (size == capacity)
            throw new OverflowException()
        this.elements[size++] = element
    }

    int pop() {
        if (size == 0)
            throw new UnderflowException()
        return this.elements[--size]
    }

    int top() {
        this.elements[size - 1]
    }

    class OverflowException extends RuntimeException {
    }

    class UnderflowException extends RuntimeException {
    }
}
