package task1;

public class ArrayQueueADT<T> {

    public void enqueue(T element, ArrayQueue<T> queue)
    {
        queue.enqueue(element);
    }

    public T element(ArrayQueue<T> queue)
    {
        return queue.element();
    }

    public T dequeue(ArrayQueue<T> queue)
    {
        return queue.dequeue();
    }

    public int size(ArrayQueue<T> queue)
    {
        return queue.size();
    }

    public boolean isEmpty(ArrayQueue<T> queue)
    {
        return queue.isEmpty();
    }

    public void clear(ArrayQueue<T> queue)
    {
        while(!queue.isEmpty())
            queue.dequeue();
    }
}