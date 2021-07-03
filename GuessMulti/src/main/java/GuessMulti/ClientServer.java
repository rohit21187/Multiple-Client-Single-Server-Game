/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessMulti;

import java.io.*;
import java.net.*;

/**
 *
 * @author rohit
 */
public class ClientServer {
        
       
    protected static void ClientServ(){
         PrintWriter write=null;
        BufferedReader reader=null;
        try{
            ServerSocket ss= new ServerSocket(3000);
            System.out.println("waiting");
            Socket s= ss.accept();
            System.out.println("Client added");
            //ClientHandClient cl = new ClientHandClient(client);
            // add a timer to thread which kills it if client takes more than 20 seconds
            write = new PrintWriter(s.getOutputStream(),true);
            reader =new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            GuessNumberServer gnu= new GuessNumberServer(s,write,reader);
            //s.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            write.flush();
        }
    }
}
class ClientHandClient  implements Runnable{
    
    Thread t;
    Socket s;
    public ClientHandClient(Socket s){
        this.s=s;
        t= new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        
        PrintWriter write=null;
        BufferedReader reader=null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            // add a timer to thread which kills it if client takes more than 20 seconds
            write = new PrintWriter(s.getOutputStream(),true);
            reader =new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            s.close();
        }
        catch(Exception ep){
            ep.printStackTrace();
        }
        
        finally{
            write.flush();
        }
    }
    
}
