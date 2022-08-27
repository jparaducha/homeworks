package multithreading;

public class Connection implements Runnable { //The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
    // The class must define a method of no arguments called run.

    //This interface is designed to provide a common protocol for objects that wish to execute code while they are active.
    // For example, Runnable is implemented by class Thread.
    // Being active simply means that a thread has been started and has not yet been stopped.
    private final String name;
    private final ConnectionPool cp;

    public Connection(String name, ConnectionPool cp) {
        this.name = name;
        this.cp = cp;
    }

    @Override
    public void run() {
        String myConnection = "";

        try {
            myConnection = cp.getConnection();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " uses " + myConnection);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<Started run() of " + name);

        try {
            Thread.sleep(5500);  // Thread.sleep() has to be surrounded by a try/catch block;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------Finished run() of " + name);

        cp.ReleaseConnection(myConnection);
    }
}
