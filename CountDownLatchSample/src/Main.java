import countdownlatchsample.InitializeConfigAndLogs;
import countdownlatchsample.InitializeDB;
import countdownlatchsample.InitializeGUI;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        try {
        CountDownLatch latch = new CountDownLatch(3);
        InitializeConfigAndLogs initializeConfigAndLogs = new InitializeConfigAndLogs(latch);
        Thread initConfigLogs = new Thread(initializeConfigAndLogs);

        InitializeDB initializeDB = new InitializeDB(latch);
        Thread initDB = new Thread(initializeDB);

        InitializeGUI initGUI = new InitializeGUI(latch);
        Thread initUI = new Thread(initGUI);

        initDB.start();
        initUI.start();
        initConfigLogs.start();
        //Latch will direct main thread to wait until process completed
        latch.await();

        System.out.println("Initialization completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}