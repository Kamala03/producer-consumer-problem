public class ConsumerThread implements Runnable {
    SharedResource resource;

    public ConsumerThread(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.consumeItem();
        }
    }
}
