
import java.util.LinkedList;
import java.util.Queue;



public class SharedResource {
    private int sharedSize;
    private Queue<Integer> queue;

    public SharedResource(int sharedSize) {
        this.sharedSize = sharedSize;
        queue = new LinkedList<>();
    }

    public synchronized void addItem(int item) throws InterruptedException {
        if(queue.size() == sharedSize){
            System.out.println("Queue is full");
            wait();
        }

        queue.add(item);
        System.out.println("Item added to queue: " + item);
        notify();
    }

    public synchronized void consumeItem() throws InterruptedException {
        if(queue.isEmpty()){
            System.out.println("Queue is empty");
            wait();
        }

        System.out.println("Item consumed from queue: " + queue.poll());
        notify();
    }
}
