package task1;

public class ArrayQueue<T> {

    private final int MAXSIZE;
    private Object[] arr;
    private int size;

    private int first;
    private int last;
    public ArrayQueue()
    {
        this(10);
    }
    public ArrayQueue(int capacity)
    {
        MAXSIZE = capacity;
        arr = new Object[MAXSIZE];
        first = 0;
        last = -1;
    }

    public void enqueue(T element)
    {
        if(last == MAXSIZE-1)
            last = -1;
        arr[++last] = element;
        size++;
    }


    public T dequeue()
    {
        T temp = (T)arr[first++];
        if(first == MAXSIZE)
            first = 0;
        size--;
        return temp;
    }


    public T element()
    {
        return (T)arr[0];
    }


    public int size()
    {
        return size;
    }


    public boolean isEmpty()
    {
        return size==0;
    }


    public void clear()
    {
        while(!isEmpty())
            dequeue();
    }
}