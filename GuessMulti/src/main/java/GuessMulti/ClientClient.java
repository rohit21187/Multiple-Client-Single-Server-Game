/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessMulti;

import java.net.*;
import java.io.*;

/**
 *
 * @author rohit
 */
public class ClientClient {
    Socket s;
    protected static void ClientClientF(String cl){
        try{
        PrintWriter write;
        BufferedReader reader;
        Socket s = new Socket(cl,3000);
        write = new PrintWriter(s.getOutputStream(),true);
        reader =new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        GuessNumberClient gnum= new GuessNumberClient(s,write,reader);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
