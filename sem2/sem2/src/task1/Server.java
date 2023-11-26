package task1;

import task2.ServerSocketThread;

import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ServerListener{
    boolean isServerWorking;
    private Listener listener;
    public ChatServer server;
    private StringWriter log;
    private ServerSocketThread servers;

    public Server(Listener listener) {
        this.listener = listener;
        this.isServerWorking = false;
        server = new ChatServer(this);
    }

    public void start() {
        if (!isServerWorking) {
            isServerWorking = true;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сеоевер запущен");
        }

    }

    public void startServer(){
        if(isServerWorking){
            listener.messageRes("Server is already working");
            return;
        }
        servers = new ServerSocketThread(this);
        listener.messageRes("Server started");
        isServerWorking = true;
    }

    @Override
    public void onMessageReceived(String msg) {
        putMessageToLog(msg);
    }

    private void putMessageToLog(String msg) {
        log.append(msg + "\n");
    }

    public void stop() {
        if (isServerWorking) {
            isServerWorking = false;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сеоевер не запущен");
        }

    }


    @Override
    public void serverListener(boolean status) {

        if (status){
            stop();
        } else {
            start();
        }

    }
    @Override
    public void onServerStart(){
        listener.messageRes("Server thread started");
    }
    @Override
    public void onServerStop(){
        listener.messageRes("Server threadstopped");
    }

    @Override
    public void onServerSocketCreated(ServerSocket s){
        listener.messageRes("Server socket created");
    }
    @Override
    public void onServerSoTimeout(ServerSocket s) {
        listener.messageRes("Accept timeout");
    }
    @Override
    public void onSocketAccepted(ServerSocket s, Socket client){
        listener.messageRes("client connected");
    }
    @Override
    public void onServerException(Throwable e){
        e.printStackTrace();
    }
    @Override
    public synchronized void onSocketStart(Socket s){
        listener.messageRes("Client connected");
    }
    @Override
    public synchronized void onSocketStop(){
        listener.messageRes("Client dropped");
    }
    @Override
    public synchronized void onSocketReady(Socket socket){
        listener.messageRes("Clientisready");
    }
    @Override
    public synchronized void onReceiveString(Socket s, String msg){
        listener.messageRes(msg);
    }
    @Override
    public void onSocketException(Throwable e){
        e.printStackTrace();
    }
}