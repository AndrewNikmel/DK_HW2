package task1;

public class ChatServer {
    private boolean isServerWorking;
    private final Server listener;

    ChatServer(Server listener) {
        isServerWorking = false;
        this.listener = listener;
    }
    public void start(){
        if (isServerWorking) {
            listener.onMessageReceived("Server is already working");
            return;
        }
        listener.onMessageReceived("Server started");
        isServerWorking = true;
    }
    public void stop(){
        if (!isServerWorking) {
            listener.onMessageReceived("Server is stopped");
            return;
        }
        listener.onMessageReceived("Server stopped");
        isServerWorking = false;
    }
}
