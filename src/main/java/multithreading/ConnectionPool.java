package multithreading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {
    public static final Integer POOL_THREADS = 5;
    private static ConnectionPool cp; // creates private static instance; will keep the generated instance in memory;
    //see SINGLETON design pattern;
    private final BlockingDeque<String> connections;
    private Integer connectionsCount;

    private ConnectionPool() { // private constructor prevents anyone from instantiating the class; see SINGLETON design pattern;
        connections = new LinkedBlockingDeque<String>(POOL_THREADS); // a BlockingDeque based on linked-nodes;
        // The optional capacity bound constructor argument serves as a way to prevent excessive expansion.
        // The capacity, if unspecified, is equal to Integer.MAX_VALUE.
        // Linked nodes are dynamically created upon each insertion unless this would bring the deque above capacity.
        connectionsCount = 0;
    }

    public static ConnectionPool getInstance() { // public static method; this is the method whose job is to return the class; SINGLETON design pattern;
        if (cp == null) {
            synchronized (ConnectionPool.class) { // 'synchronized' keyword prevents two different threads from calling the same method at the same time;
                cp = new ConnectionPool();    // created using Lazy Initialization;
            } // Lazy Initialization: the instance is not created until getInstance() is called;
        }
        return cp;
    }

    private void Connect() {
        connections.add("Connection N° " + (connectionsCount));
        // BlockingDeque.add() Inserts the specified element into the queue represented by this deque
        // (in other words, at the tail of this deque)
        // if it is possible to do so immediately without violating capacity restrictions,
        // returning true upon success and throwing an IllegalStateException if no space is currently available.
    }

    public String getConnection() throws InterruptedException {
        System.out.println(" Connections so far: " + ++connectionsCount + " maximum threads in deque: " + POOL_THREADS);
        if (connections.size() == 0 && connectionsCount <= POOL_THREADS) { // .size() Returns the number of elements in this deque. ;
            synchronized (ConnectionPool.class) {
                if (connections.size() == 0 && connectionsCount <= POOL_THREADS) {
                    // if there are no current connections calls the innitConnection method to use the add() method;
                    Connect();
                }
            }
        }

        return connections.take(); //Retrieves and removes the head of the queue represented by this deque
        // (in other words, the first element of this deque),
        // waiting if necessary until an element becomes available.
    }

    public void Disconnect(String conn) {
        connections.offer(conn); //Inserts the specified element into the queue represented by this deque
        // (in other words, at the tail of this deque)
        // if it is possible to do so immediately without violating capacity restrictions,
        // returning true upon success and false if no space is currently available.
        // When using a capacity-restricted deque, this method is generally preferable to the add(E) method
    }
}