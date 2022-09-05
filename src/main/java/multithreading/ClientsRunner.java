package multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClientsRunner {
    public static final int MAXIMUM_THREADS = 7;
    private static final Logger LOGGER = LogManager.getLogger(ClientsRunner.class);
    private static final int threadPoolSize = 5;

    public static void main(String[] args) throws InterruptedException {

        ConnectionPool cp = new ConnectionPool(7);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 7000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(MAXIMUM_THREADS));

        //executor.execute(new CustomThread(" Thread: 1 ", cp));
        for (int i = 1; i <= MAXIMUM_THREADS; i++) {
            Runnable connection = new Runnable() {

                @Override
                public void run() {
                    try {

                        Connection connection = cp.getConnection();
                        connection.Connect(Thread.currentThread().getId() % threadPoolSize + 1);
                        try {
                            Thread.sleep(7500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        connection.Disconnect();
                        cp.ReleaseConnection(connection);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(connection);

            executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        }
        LOGGER.info("[DONE]. no more tasks will me submitted to the executor");
        executor.shutdown();
        try {
            executor.awaitTermination(1500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            LOGGER.warn(e);
        }

        if (executor.isTerminated()) {
            LOGGER.info("all threads terminated");
        } else {
            LOGGER.info("threads still running");
        }
    }
}
