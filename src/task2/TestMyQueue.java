package task2;
public class TestMyQueue {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.add(10);
        queue.add(15);
        queue.add(20);
        queue.add(25);
        queue.add(30);

        while(!queue.isEmpty())
            System.out.println(queue.poll());

        queue.remove();
    }
}