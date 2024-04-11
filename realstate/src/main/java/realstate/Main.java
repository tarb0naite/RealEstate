package realstate;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        Server server = new Server(8080); // Define the server on port 8080
        WebAppContext ctx = new WebAppContext();
        ctx.setContextPath("/");
        ctx.setWar("src/main/webapp"); // Set the path to your webapp folder

        // Alternatively, if you have a compiled WAR:
        // ctx.setWar("path/to/your.war");

        server.setHandler(ctx);

        try {
            server.start();
            server.join(); // This line will make the current thread join and wait until server is done executing.
        } catch (Exception e) {
            System.err.println("Error starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
