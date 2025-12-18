public interface MyStack {
    void push(Object item) throws StackOverflowException;
    Object pop() throws StackUnderflowException;
    void display();
    boolean isEmpty();
    boolean isFull();
}
