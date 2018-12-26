/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author architgarg
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author architgarg
 */
public class seedet extends JFrame implements ActionListener {
    
    //Declaration
    
    JButton badm,bstud,bfac,bh,bb; 
    String snm,sid;
    //Constructor 
       
    seedet(String s1,String s2)
    {
        snm=s1;
        sid=s2;
        //Frame Properties
        
        setLayout(null);
        setVisible(true);
        setTitle("SEE DETAILS");
        setSize(1425,600);
        
        //Inititalizing the Controls
        
        bh=new JButton("Home");
         bb=new JButton("<");
        badm=new JButton("SEE ADMINISTRATOR DETAILS");
        bfac=new JButton("SEE FACULTY DETAILS");
        bstud=new JButton("SEE STUDENT DETAILS");
        
        //Positioning the Controls
        
        badm.setBounds(620,100,300,80);
        bstud.setBounds(620,400,300,80);
        bfac.setBounds(620,250,300,80);
        bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
        
        //Adding Controls to the Frame
        
        add(badm);
        add(bstud);
        add(bfac);
        add(bh);
        add(bb);
        
        //Adding Action Listeners
        
        badm.addActionListener(this);
        bstud.addActionListener(this);
        bfac.addActionListener(this);
        bh.addActionListener(this);
        bb.addActionListener(this);
    }

    
    
    
    // Main Function
    
    
    public static void main(String[] args)
    {
        //ChalkPad c=new ChalkPad();
    }





    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Back Button
      
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
              
        //Admin Panel Button
        
        if(e.getSource()==badm)
        {
          // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
           this.dispose();
            admseedetchk asc=new admseedetchk(snm,sid);
        }
        
        //Faculty Panel Button
        
        if(e.getSource()==bfac)
        {
            //OptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            this.dispose();
            facseedetchk fsc=new facseedetchk(snm,sid);
        }
        
        //Student Panel Button
        
        if(e.getSource()==bstud)
        {
            //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            this.dispose();
            studseedetchk ssc=new studseedetchk(snm,sid);
        }
    }
    
}
 