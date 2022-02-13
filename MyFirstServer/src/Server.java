import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Server {

    ServerSocket ss;
    Socket s;
    ArrayList<ClientHandler> connectedClients = new ArrayList<>();
    
    public void initServer()
    {
        try {
            ss = new ServerSocket(6666);
            
            while (true)
            {
                s = ss.accept();
                connectedClients.add(new ClientHandler(this, s));
                
            }
            
            //System.out.println("Message is " +msg);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    void remove(ClientHandler hnd){
        connectedClients.remove(hnd);
    }
    
    public static void main(String[] args) {
        Server s = new Server();
        s.initServer();
    
    }
}
