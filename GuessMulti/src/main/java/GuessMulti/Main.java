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
public class Main {
    
    
    public static void main(String[] args){
        try{
        PrintWriter write;
        BufferedReader reader;
        Socket s = new Socket("192.168.1.9",3100);
        write = new PrintWriter(s.getOutputStream(),true);
        reader =new BufferedReader(new InputStreamReader(s.getInputStream()));
        //write.print("host");
        
        JoinCreateGame jcg = new JoinCreateGame(s,write,reader);
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
