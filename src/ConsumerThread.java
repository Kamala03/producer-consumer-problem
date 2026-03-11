public class ConsumerThread implements Runnable {
    SharedResource resource;

    public ConsumerThread(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                resource.consumeItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
