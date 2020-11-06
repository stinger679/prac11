package task2;

import java.util.NoSuchElementException;

public class LinkedQueue<T> extends AbstractQueue<T>{
    private Node<T> first;
    private Node<T> last;

    public void add(T data)
    {
        Node<T> newNode = new Node<>(data);
        if(size ==0){
            first = last = newNode;
            size++;
        }
        else{
            last.next = newNode;
            last = newNode;
            size++;
        }
    }

    public T poll()
    {
        if(first==null)
            return null;
        Node<T> temp = first;
        first = first.next;
        size--;
        return temp.data;

    }

    public T remove()
    {
        if(first==null)
            throw new NoSuchElementException("The queue is empty");
        Node<T> temp = first;
        first = first.next;
        size--;
        return temp.data;
    }

    public T peek(){
        if(first==null)
            return null;
        return first.data;
    }

    public void display()
    {
        Node<T> current = first;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T d)
    {
        data = d;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
