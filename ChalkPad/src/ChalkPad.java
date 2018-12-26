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
 * @author architgarg^
 */
public class ChalkPad extends JFrame implements ActionListener {
    
    //Declaration
    
    JButton badm,bstud,bfac; 
        
    //Constructor 
       
    ChalkPad()
    {
        
        //Frame Properties
        
        setLayout(null);
        setVisible(true);
        setTitle("HomePage");
        setSize(1425,600);
        
        //Inititalizing the Controls
        
        badm=new JButton("ADMIN PANEL");
        bfac=new JButton("FACULTY PANEL");
        bstud=new JButton("STUDENT PANEL");
        
        //Positioning the Controls
        
        badm.setBounds(620,100,300,80);
        bstud.setBounds(620,400,300,80);
        bfac.setBounds(620,250,300,80);
        
        //Adding Controls to the Frame
        
        add(badm);
        add(bstud);
        add(bfac);
        
        //Adding Action Listeners
        
        badm.addActionListener(this);
        bstud.addActionListener(this);
        bfac.addActionListener(this);
    }

    
    
    
    // Main Function
    
    
    public static void main(String[] args)
    {
        ChalkPad c=new ChalkPad();
    }



   //Listeners


    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Admin Panel Button
        
        if(e.getSource()==badm)
        {
           // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            this.dispose();
            admin a=new admin();
        }
        
        //Faculty Panel Button
        
        if(e.getSource()==bfac)
        {
            //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            this.dispose();
            fac f=new fac();
        }
        
        //Student Panel Button
        
        if(e.getSource()==bstud)
        {
            this.dispose();
            student st=new student();
        }
    }
    
}
 