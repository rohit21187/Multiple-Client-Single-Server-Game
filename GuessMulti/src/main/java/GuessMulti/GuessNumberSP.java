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
class GuessNumberSP implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private JTextField t1, t2;
    private JButton jb; 
    private JLabel l1,l2,l3;
    private int gn;
    public JFrame jf;
    public GuessNumberSP() {
        jf = new JFrame("Guess Number Game");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        t1=new JTextField("");
        t1.setBounds(250, 40, 150, 40);
        jf.add(t1);
        t2=new JTextField("Enter your guess");
        t2.setBounds(250, 90, 150, 40);
        jf.add(t2);
        jb = new JButton("Unmask");
        jb.setActionCommand("Unmask");
        jb.addActionListener(this);
        jb.setBounds(420, 40, 80, 40);
        jf.add(jb);
        jb = new JButton("Reset");
        jb.setActionCommand("Reset");
        jb.addActionListener(this);
        jb.setBounds(500, 40, 70, 40);
        jf.add(jb);
        jb = new JButton("Generate");
        jb.setActionCommand("Generate");
        jb.addActionListener(this);
        jb.setBounds(420, 90, 150, 40);
        jf.add(jb);
        l1 = new JLabel("The number is");
        l1.setBounds(30, 40, 100, 40);
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
                        int check= Integer.parseInt(t2.getText());
                        if(gn==check){
                            l3.setText("Correct You won");
                        }
                        else if(gn<check){
                            l3.setText("Greater than the number");
                        }
                        else{
                            l3.setText("Smaller than the number");
                        }
                        
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
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(
        new Runnable(){
            public void run(){
                new GuessNumberSP();
            }
        });
    }

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