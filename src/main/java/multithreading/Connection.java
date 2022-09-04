package multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private final String name;
    private final Logger LOGGER = LogManager.getLogger(Connection.class);
    private boolean isAvailable;
    private String connectionNumber;

    public Connection(String name, String connectionNumber) {
        this.name = name;
        this.connectionNumber = connectionNumber;
    }

    public Connection(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void Connect() {
        LOGGER.info("connecting " + name);
        this.isAvailable = false;
    }

    public void Disconnect() {
        LOGGER.info("disconnecting " + name);
        this.isAvailable = true;
    }
}
