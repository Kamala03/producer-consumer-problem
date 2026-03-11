


public class ProducerThread implements Runnable {
    SharedResource resource;


    ProducerThread(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                resource.addItem(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
