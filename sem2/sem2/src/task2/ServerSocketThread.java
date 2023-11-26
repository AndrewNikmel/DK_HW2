package task2;

import task1.Server;

public class ServerSocketThread {
    private ServerSocketThreadListener listener;
    private Server server;
    public ServerSocketThread(ServerSocketThreadListener listener){
        this.listener = listener;
    }

    public ServerSocketThread(Server server) {
        this.server = server;
    }

}
