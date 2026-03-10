import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(new ProducerThread(sharedResource));
        Thread consumerThread = new Thread(new ConsumerThread(sharedResource));

        producerThread.start();
        consumerThread.start();
    }
}