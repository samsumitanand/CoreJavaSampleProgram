package countdownlatchsample;

import java.util.concurrent.CountDownLatch;

public class InitializeGUI implements Runnable {

    CountDownLatch countDownLatch;
    public InitializeGUI(CountDownLatch latch) {
        this.countDownLatch = latch;
    }


    @Override
    public void run() {
        System.out.println("Initializing GUI");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("UI Initialization completed ");
        countDownLatch.countDown();
    }
}
