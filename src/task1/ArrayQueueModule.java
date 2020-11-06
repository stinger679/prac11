package task1;

public class ArrayQueueModule<T> {

    private ArrayQueue<T> queue;

    public ArrayQueueModule()
    {
        this(10);
    }

    public ArrayQueueModule(int size)
    {
        queue = new ArrayQueue<>(size);
    }



    public void enqueue(T element)
    {
        queue.enqueue(element);
    }


    public T element()
    {
        return queue.element();
    }


    public T dequeue()
    {
        return queue.dequeue();
    }


    public int size()
    {
        return queue.size();
    }


    public boolean isEmpty()
    {
        return queue.isEmpty();
    }


    public void clear()
    {
        while(!queue.isEmpty())
            queue.dequeue();
    }
}