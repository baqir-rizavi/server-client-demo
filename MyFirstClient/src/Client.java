
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 *
 * @author baqir 4.2.0
 */
public class Client {

    Socket s;
    
    public void initClient()
    {
        
        try {
            s = new Socket("192.168.56.1", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String msg = br.readLine();
            
            while (!(msg.equalsIgnoreCase("byebye")))
            {                
                dout.writeUTF(msg);
                
                dout.flush();
                
                msg = br.readLine();
                
            }
            
            //dout.writeUTF(msg);
            dout.flush();
            s.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Client c = new Client();
        c.initClient();
    }
}
