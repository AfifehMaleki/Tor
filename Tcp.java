import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp {
    private ServerSocket serverSocket;

    public Tcp(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    // for handling socket
    //yek socket migire shoro mikone khat be kht mikhoneh va lowercase mikone
    //karbar har zaman ke quit zad connection ro ghat mikone
    private void handle(Socket socket) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);


                writer.println( socket.getRemoteSocketAddress().toString());
                System.out.println( socket.getRemoteSocketAddress().toString());
                writer.flush();
//            }
            outputStream.close();
            socket.close();
            System.out.println("Socket closed! " + socket.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        System.out.println("Server Connected...!!");
        while (true){                //this while is for several connection. server after reply to client still is up
            System.out.println("Waiting for connection ... !");
            final Socket socket = serverSocket.accept();
            System.out.println("client accepted!" + socket.toString());
            new Thread(() -> handle(socket)).start();

        }
    }
    public static void main(String[] args) throws IOException {
        Tcp server = new Tcp(7000);
        server.start();


    }
}
