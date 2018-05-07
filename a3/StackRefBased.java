public class StackRefBased < T > implements Stack < T > {
    T data;
    StackNode < T > stack;
    int num;

    public StackRefBased() {
        data = null;
        stack = null;
        num = 0;


    }

    public int size() {
        return num;
    }


    public boolean isEmpty() {
        return stack == null;
    }


    public void push(T data) {
        StackNode < T > temp = new StackNode < T > (data);

        temp.next = stack;
        stack = temp;
        num++;
    }


    public T pop() throws StackEmptyException {
        if (num == 0)

        {
            throw new StackEmptyException();

        } else {
            T data = stack.data;
            stack = stack.next;
            num--;
            return data;
        }


    }


    public T peek() throws StackEmptyException {
        if (num == 0) {
            throw new StackEmptyException();
        } else {
            T data = stack.data;
            return data;
        }

    }


    public void makeEmpty() {
        stack = null;
        num = 0;


    }


    public String toString() {
        StackNode < T > a = stack;
        if (num == 0) {
            return "{}";
        } else {
            String s = "{";

            for (int i = 0; i < num; i++) {
                s += " , " + a.data;
                a = a.next;
            }
            return s + "}";
        }
    }

}
