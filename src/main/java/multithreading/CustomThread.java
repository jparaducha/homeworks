package multithreading;

public class CustomThread extends Thread {

    private final String name;
    //private final ConnectionPool cp;
    private String connectionNumber;

    public CustomThread(String name, ConnectionPool cp) {
        this.name = name;
        //this.cp = cp;
    }

    public CustomThread(String name, String connectionNumber) {
        this.name = name;
        this.connectionNumber = connectionNumber;
    }

    public void run() {

        String myConnection = "";
        myConnection = this.connectionNumber;

        System.out.println(name + " uses " + myConnection);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<Started run() of thread subclass");

        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------Finished run() of thread subclass");
    }
}
