import java.util.ArrayDeque;
import java.util.Queue;



public class SharedResource {
    boolean itemAvailable = false;
    Queue<Integer> queue = new ArrayDeque<Integer>();

    public synchronized void addItem(int item) {
        while(itemAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                //Exception handling here
            }
        }
        itemAvailable = true;
        queue.add(item);
        System.out.println("Item added to queue: " + item);
        notifyAll();
    }

    public synchronized void consumeItem(){
        while (!itemAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                //Exception handling here
            }
        }

        itemAvailable = false;
        System.out.println("Item consumed from queue: " + queue.poll());
        notifyAll();
    }
}
