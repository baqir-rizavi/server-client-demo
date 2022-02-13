
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/**
 *
 * @author Baqir 4.2.0
 */
public class ClientHandler implements Runnable  {
    
    Server server;
    Socket s;
    Thread t;
    
    public ClientHandler(Server server, Socket s) {
        this.server = server;
        this.s = s;
        
        t = new Thread(this);
        t.start();
        
    }

    @Override
    public void run() {
        try {
        
            DataInputStream din = new DataInputStream(s.getInputStream());
            
            String msg = din.readUTF();
            
            while (!(msg.equalsIgnoreCase("byebye"))) {                
                System.out.println(msg);
                msg = din.readUTF();
            }
            
            disconnect();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    void disconnect(){
        server.remove(this);
    }
}
