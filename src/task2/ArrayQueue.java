package task2;


import java.util.NoSuchElementException;

public class ArrayQueue<T> extends AbstractQueue<T> {
    private int capacity;
    private Object[] arr;
    int first;
    int last;

    public ArrayQueue()
    {
        this(10);
    }
    public ArrayQueue(int capacity)
    {
        this.capacity = capacity;
        arr = new Object[capacity];
        first = 0;
        last = 0;
    }

    public void add(T element)
    {
        if(last+1 >= capacity){
            capacity *=2;
            Object[] arr2 = new Object[capacity];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
        }
        arr[last++] = element;
        size++;
    }

    public T poll()
    {
        if(size==0)
            return null;
        size--;
        return (T)arr[first++];
    }

    public T remove()
    {
        if(size==0)
            throw new NoSuchElementException("The queue is empty");
        size--;
        return (T)arr[first++];
    }

    public T peek()
    {
        if(size==0)
            return null;
        return (T)arr[0];
    }

    public void display()
    {
        for(var x: arr)
            System.out.print(x + " ");
        System.out.println();
    }
}
