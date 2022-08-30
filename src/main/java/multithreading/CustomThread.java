package multithreading;

public class CustomThread extends Thread {

    private final String name;
    private final ConnectionPool cp;

    public CustomThread(String name, ConnectionPool cp) {
        this.name = name;
        this.cp = cp;
    }

    public void run() {

        String myConnection = "";

        try {
            myConnection = cp.getConnection();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " uses " + myConnection);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<Started run() of thread subclass");

        try {
            Thread.sleep(5500);  // Thread.sleep() has to be surrounded by a try/catch block;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------Finished run() of thread subclass");
        cp.Disconnect(myConnection);
    }
}
