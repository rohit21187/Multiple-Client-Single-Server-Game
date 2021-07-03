/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessMulti;

import java.net.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author rohit
 */
public class MainServer {
    
    public static void main(String[] args){
        
        try{
            ServerSocket ss= new ServerSocket(3100);
            while(true){
                System.out.println("waiting");
                
                Socket client= ss.accept();
                System.out.println("Client added");
                ClientHandler cl = new ClientHandler(client);
                
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
class ClientHandler  implements Runnable{
    
    public static Queue<String> q = new LinkedList<String>();
    Thread t;
    Socket s;
    public ClientHandler(Socket s){
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
            String st= reader.readLine();
            System.out.println(st);
            if(st.equals("join")){
                while(q.size()==0){
                    t.sleep(2000);
                }
                String adr=q.remove();
                write.println(adr);
                System.out.println(adr+" server");
                //invoke ClientClient
                
            }
            else if(st.equals("host")){
                String adre= reader.readLine();
                System.out.println(adre+" server");
                q.add(adre);
                //invoke ClientSocket
            }
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
