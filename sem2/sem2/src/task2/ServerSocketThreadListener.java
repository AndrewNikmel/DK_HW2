package task2;
import java.net.Socket;
import java.net.ServerSocket;
public interface ServerSocketThreadListener {
    void onServerStart();
    void onServerStop();
    void onServerSocketCreated(ServerSocket s);
    void onServerSocketTimeout(ServerSocket s);
    void onSocketAccepted(ServerSocket s, Socket client);
    void onServerException(Throwable e);
}
