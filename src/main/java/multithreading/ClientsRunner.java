package multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClientsRunner {
    public static final int MAXIMUM_THREADS = 5;
    private static final Logger LOGGER = LogManager.getLogger(ClientsRunner.class);
    private static final int threadPoolSize = 5;
    private static final ConnectionPool cp = new ConnectionPool(5);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 7000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(MAXIMUM_THREADS));

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

        executor.execute(new RunnerTask(Thread.currentThread().getId()));
        executor.execute(new RunnerTaskThread(Thread.currentThread().getId() % threadPoolSize + 1));
        executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
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

    static class RunnerTaskThread extends Thread {
        private final long threadId;

        public RunnerTaskThread(long threadId) {
            this.threadId = threadId;
        }

        public void run() {
            try {
                Connection connection = cp.getConnection();
                connection.Connect(threadId);
                try {
                    Thread.sleep(7500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connection.Disconnect();
                cp.ReleaseConnection(connection);
            } catch (RuntimeException e) {
                LOGGER.error(e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class RunnerTask implements Runnable {

        private final long threadId;

        public RunnerTask(long threadId) {
            this.threadId = threadId;
        }

        public void run() {
            try {
                Connection connection = cp.getConnection();
                connection.Connect(threadId);
                try {
                    Thread.sleep(7500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connection.Disconnect();
                cp.ReleaseConnection(connection);
            } catch (RuntimeException e) {
                LOGGER.error(e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

