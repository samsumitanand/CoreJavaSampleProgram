package countdownlatchsample;

import java.util.concurrent.CountDownLatch;

public class InitializeConfigAndLogs implements Runnable {

    CountDownLatch countDownLatch;

    public InitializeConfigAndLogs(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Initializing DB");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Logs and config initialization completed");
        countDownLatch.countDown();
    }


}
