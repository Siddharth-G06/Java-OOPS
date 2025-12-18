public class StackArray implements MyStack {
    private Object[] stack;
    private int top;
    private int capacity;
    private static final int MAX_CAPACITY = 10;

    public StackArray(int initialCapacity) {
        if (initialCapacity <= 0 || initialCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException(
                "Initial capacity must be between 1 and " + MAX_CAPACITY);
        }
        stack = new Object[initialCapacity];
        capacity = initialCapacity;
        top = -1;
    }

    @Override
    public void push(Object item) throws StackOverflowException {
        if (isFull()) {
            if (capacity >= MAX_CAPACITY) {
                throw new StackOverflowException(
                    "Cannot push: Stack has reached max capacity (" + MAX_CAPACITY + ").");
            } else {
                resize();
                System.out.println("Stack resized to capacity: " + capacity);
            }
        }
        stack[++top] = item;
        System.out.println(item + " pushed to stack.");
    }

    @Override
    public Object pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Cannot pop from empty stack.");
        }
        Object item = stack[top--];
        System.out.println(item + " popped from stack.");
        return item;
    }

    @Override
public void display() {
    if (isEmpty()) {
        System.out.println("Stack is empty.");
    } else {
        System.out.print("Stack elements (top to bottom): [ ");
        boolean first = true;
        for (int i = top; i >= 0; i--) {
            if (stack[i] != null && !stack[i].toString().isEmpty()) {
                if (!first) System.out.print(", ");
                System.out.print(stack[i]);
                first = false;
            }
        }
        System.out.println(" ]");
    }
}


    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == capacity - 1;
    }

    private void resize() {
        int newCapacity = Math.min(capacity * 2, MAX_CAPACITY);
        Object[] newStack = new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, capacity);
        stack = newStack;
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[ ]";
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = top; i >= 0; i--) {
            sb.append(stack[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
