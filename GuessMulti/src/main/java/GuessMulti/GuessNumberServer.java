/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessMulti;

/**
 *
 * @author rohit
 */
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;
class GuessNumberServer implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private JTextField t1, t2;
    private JButton jb; 
    private JLabel l1,l2,l3;
    private int gn;
    private JFrame jf;
    private Socket s; 
    private PrintWriter write=null;
    private BufferedReader reader=null;
    //Socket s,PrintWriter write,BufferedReader reader
    public GuessNumberServer(Socket s,PrintWriter write,BufferedReader reader) {
        /*this.s=s;
        this.write=write;
        this.reader= reader;*/
        jf = new JFrame("Guess NumberS Game");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        t1=new JTextField("");
        t1.setBounds(300, 40, 150, 40);
        jf.add(t1);
        t2=new JTextField("Enter your guess");
        t2.setBounds(300, 90, 150, 40);
        t2.setEditable(false);
        jf.add(t2);
        l1 = new JLabel("Enter your secret number");
        l1.setBounds(30, 40, 150, 40);
        jf.add(l1);
        l2 = new JLabel("Type your guess");
        l2.setBounds(30, 90, 100, 40);
        jf.add(l2);
        l3 = new JLabel();
        l3.setBounds(250, 150, 150, 50);
        jf.add(l3);
        
        jf.setSize(800, 250);
        jf.setVisible(true);
        t1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                    gn= Integer.parseInt(t1.getText());
                    t1.setText("**");
                    t2.setText("");
                    t1.setEditable(false);
                    t2.setEditable(true);
                    l1.setText("Guess this number");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        t2.addActionListener(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent ae){
                    try{
                        int check;
                        int sendThis=Integer.parseInt(t2.getText());
                        t2.setEditable(false);
                        String ch= reader.readLine();
                        check=Integer.parseInt(ch);
                        write.println(sendThis);
                        int flag;
                        if(gn==check){
                            flag=0;
                            //l3.setText("Correct You won");
                        }
                        else if(gn<check){
                            flag=1;
                            //l3.setText("Greater than the number");
                        }
                        else{
                            flag=-1;
                            //l3.setText("Smaller than the number");
                        }
                        ch=reader.readLine();
                        write.println(flag);
                        int flagr;
                        flagr=Integer.parseInt(ch);
                        System.out.println(flagr);
                        if(flagr==0 && flag==0){
                           l3.setText("TIE");
                           Thread t= Thread.currentThread();
                            t.sleep(2000);
                            jf.dispose();
                            s.close();
                        }
                        else if(flag==0){
                            l3.setText("YOU LOST");
                            Thread t= Thread.currentThread();
                            t.sleep(2000);
                            jf.dispose();
                            s.close();
                        }
                    else{
                                if(flagr==0){
                                   l3.setText("CORRECT YOU WON");
                                   Thread t= Thread.currentThread();
                                   t.sleep(2000);
                                   jf.dispose();
                                   s.close();
                                }
                                else if(flagr==1){
                                    l3.setText("Greater than the number");
                                }
                                    
                                else{
                                    l3.setText("Smaller than the number");
                                }
                }
                        t2.setEditable(true);
                        t2.setText("");
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
        /*jb.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //if(toString(e.getActionCommand()).equals()){
                System.out.println(e.getActionCommand());
            }
        });*/


    }
    
    /*public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(
        new Runnable(){
            public void run(){
                new GuessNumberClient();
            }
        });
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if((e.getActionCommand()).equals("Unmask")){
            t1.setText(Integer.toString(gn));
            l3.setText("You accepted defeat");
            //jf.setVisible(false);
        }
        else if((e.getActionCommand()).equals("Reset")){
            t1.setText("");
            t2.setText("Enter your guess");
            l3.setText("");
            t1.setEditable(true);
            
        }
        else{
            try{
                    Random rand = new Random();
                    gn= rand.nextInt(100);
                    t1.setText("**");
                    t2.setText("");
                    t1.setEditable(false);
                }
                catch (Exception et){
                    et.printStackTrace();
                }
        }
    }

    
}