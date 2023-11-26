package task1;

import java.net.ServerSocket;
import java.net.Socket;

public interface ServerListener {
    void serverListener(boolean status);

    void stop();

    void start();

    void onMessageReceived(String serverIsAlreadyWorking);

    void onServerStart();

    void onServerStop();

    void onServerSocketCreated(ServerSocket s);

    void onServerSoTimeout(ServerSocket s);

    void onSocketAccepted(ServerSocket s, Socket client);

    void onServerException(Throwable e);

    void onSocketStart(Socket s);

    void onSocketStop();

    void onSocketReady(Socket socket);

    void onReceiveString(Socket s, String msg);

    void onSocketException(Throwable e);
}