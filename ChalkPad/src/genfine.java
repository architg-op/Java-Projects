/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import chalkpad.student;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author architgarg
 */
public class genfine extends JFrame implements ActionListener {
    
    //Declaration
    
    JButton blib,both,bh,bb;
    String snm,sid;
        
    //Constructor 
       
    genfine(String s1,String s2)
    {
        snm=s1;
        sid=s2;
        //Frame Properties
        
        setLayout(null);
        setVisible(true);
        setTitle("Generate Fine Portal");
        setSize(1425,600);
        
        //Inititalizing the Controls
        
         bb=new JButton("<");
        bh=new JButton("Home");
        blib=new JButton("LIBRARY FINE");
        both=new JButton("OTHER FINE");
        
        //Positioning the Controls
        
        
        bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
        blib.setBounds(620,150,300,80);
        both.setBounds(620,350,300,80);

        
        //Adding Controls to the Frame
        
        add(blib);
        add(both);
        add(bh);
        add(bb);
        
        //Adding Action Listeners
        
        bb.addActionListener(this);
         bh.addActionListener(this);
        blib.addActionListener(this);
        both.addActionListener(this);
    }

    
    
    
    // Main Function
    
    
    public static void main(String[] args)
    {
        
    }



   //Listeners


    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bb)
        {
            this.dispose();
            dashadmin dam = new dashadmin(snm,sid);
        }
      //Home Button
              if(e.getSource()==bh)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
        
        
        // Library Fine Button
        
        if(e.getSource()==blib)
        {
            //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            this.dispose();
            libfine lf=new libfine(snm,sid);
        }
        
        //Other Fine Button
        
        if(e.getSource()==both)
        {
            //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            this.dispose();
            othfine otf=new othfine(snm,sid);
                    
        }

    }
    
}
 