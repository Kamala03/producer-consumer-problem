


public class ProducerThread implements Runnable {
    SharedResource resource;


    ProducerThread(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            resource.addItem(i);
        }
    }
}
