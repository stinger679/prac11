package task2;

import java.util.NoSuchElementException;

public interface MyQueue<E> {

    void add(E e);


    E remove();


    E poll();


    E peek();
}