import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;

public class Socks {
                private Socket underlying;

                public void startConnection() throws IOException {
                    InetSocketAddress HiddeneProxyAddrss = new InetSocketAddress("127.0.0.1",9150);
                    Proxy HiddenProxy = new Proxy(Proxy.Type.SOCKS,HiddeneProxyAddrss);
                    underlying = new Socket(HiddenProxy);
                    underlying.connect(new InetSocketAddress("spsadgttk5hrgzhsz74dolasjoa4dtnpdsla2c4ezupadaiy634lqlad.onion",80));
                    InputStream input = underlying.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                    String line = reader.readLine();

                    System.out.println(line);


                }


    public static void main(String[] args) throws IOException {
        Socks client = new Socks();
        client.startConnection();
    }


}



