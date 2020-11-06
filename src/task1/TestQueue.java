package task1;

public class TestQueue {
    public static void main(String[] args) {
        System.out.println("ArrayQueueModule:");
        ArrayQueueModule<Integer> queueModule = new ArrayQueueModule<>();
        for(int i=0; i< 10; i++)
            queueModule.enqueue(i+2);
        System.out.println("element: " + queueModule.element());
        for(int i=0; i<3; i++)
            System.out.println("dequeue: " + queueModule.dequeue());
        System.out.println("size before clear: " + queueModule.size());
        queueModule.clear();
        System.out.println("size after clear: " + queueModule.size());
        System.out.println();


        System.out.println("ArrayQueueADT:");
        ArrayQueue<Integer> q = new ArrayQueue<>(12);
        ArrayQueueADT<Integer> queueADT = new ArrayQueueADT<>();
        for(int i=0; i< 10; i++)
            queueADT.enqueue(i+2, q);
        System.out.println("element: " + queueADT.element(q));
        for(int i=0; i<3; i++)
            System.out.println("dequeue: " + queueADT.dequeue(q));
        System.out.println("size before clear: " + queueADT.size(q));
        queueADT.clear(q);
        System.out.println("size after clear: " + queueADT.size(q));
        System.out.println();

        System.out.println("ArrayQueue:");
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i=0; i< 10; i++)
            queue.enqueue(i+2);
        System.out.println("element: " + queue.element());
        for(int i=0; i<3; i++)
            System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size before clear: " + queue.size());
        queue.clear();
        System.out.println("size after clear: " + queue.size());
    }
}