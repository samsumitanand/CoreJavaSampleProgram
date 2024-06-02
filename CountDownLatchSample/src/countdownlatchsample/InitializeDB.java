package countdownlatchsample;

import java.util.concurrent.CountDownLatch;

public class InitializeDB implements Runnable {

    CountDownLatch countDownLatch;

    public InitializeDB(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Initializing DB");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("DB initialization completed");
        countDownLatch.countDown();
    }
}
