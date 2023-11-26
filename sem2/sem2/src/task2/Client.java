package task2;

import java.io.StringWriter;
import java.net.Socket;

public class Client implements SocketThreadListener {
    private String name;
    private int id;
    StringWriter log;
    public Client(String name, int id){
        this.name = name;
        this.id = id;
    }
    private void connect(){
        SocketThread socketThread = new SocketThread(this);
    }
    @Override
    public void onSocketStart(Socket s){
        log.append("Started" +"\n");
    }
    @Override
    public void onSocketStop(){
        log.append("Stopped"+"\n");
    }
    @Override
    public void onSocketReady(Socket socket) {
        log.append("Ready"+"\n");
    }
    @Override
    public void onReceiveString(Socket s, String msg){
        log.append(msg+ "\n");
    }
    @Override
    public void onSocketException(Throwable e){
        e.printStackTrace();
    }
}
