package multithreading;

import java.util.Vector;

public class ConnectionPool {
    public static final Integer POOL_THREADS = 5;
    private static ConnectionPool cp; // creates private static instance; will keep the generated instance in memory;
    //see SINGLETON design pattern;
    //private final BlockingDeque<String> connections;
    private final int size;
    private final Vector<Connection> connections;
    private int connectionsCount;

    public ConnectionPool(int size) {
        this.size = size;
        connections = new Vector<Connection>();
        connectionsCount = 0;
    }

    public static ConnectionPool getConnectionPool() {
        return cp;
    }

    private void InnitConnection(Connection connection) {
        connections.add(connection);
        connectionsCount++;
    }

    public void ReleaseConnection(Connection connection) {
        connections.remove(connection);
    }

    public synchronized Connection getConnection() throws InterruptedException {
        Connection con = null;

        if (connections.size() < size) {
            con = new Connection("Thread#" + (connectionsCount + 1));
            InnitConnection(con);
            return con;
        } else {
            System.out.println("no free connections atm");
            int maxAttempts = 10;
            while (maxAttempts-- > 0) {
                Thread.sleep(1000);

                if (connections.size() < size) {
                    con = new Connection("Thread#" + (connectionsCount + 1) + (Thread.currentThread().getId() % 5 + 1));
                    InnitConnection(con);
                    return con;
                }
            }
            throw new RuntimeException("No connections available after 10 seconds");
        }
    }
}