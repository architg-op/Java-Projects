/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author architgarg
 */
 public class fac extends JFrame implements ActionListener {
     
     //Declaration
     
    JLabel lid,lpass,lfp;
    JTextField tid,tpass;
    JButton bl,bh,bb,bfp;
    
    //Constructor
    
    fac()
    {
        
        //Frame Properties
        
        setTitle("Faculty Login");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        
        //Inititalizing the Controls
        
        lid=new JLabel("<html><body><h2>ID</h2><body></html>");
        lpass=new JLabel("<html><body><h2>PASSWORD</h2><body></html>");
        lfp=new JLabel("<html><body><h3>Forgot Password?</h3><body></html>");
        tid=new JTextField(20);
        tpass=new JTextField(20);
        bl=new JButton("Log In");
        bb=new JButton("<");
        bfp=new JButton("Click Here");
        bh=new JButton("Home");
        
        //Positioning the Controls
        
        lid.setBounds(460,150,150,50);
        lpass.setBounds(460,200,150,50);
        lfp.setBounds(630,325,250,50);
        tid.setBounds(690,155,230,30);
        tpass.setBounds(690,210,230,30);
        bl.setBounds(460,265,450,50);
        bfp.setBounds(540,370,300,50);
        bb.setBounds(5,15,70,40);
        bh.setBounds(5,540,90,40);
        
        //Adding Controls to the Frame
        
        add(lid);
        add(tid);
        add(lpass);
        add(tpass);
        add(bl);
        add(lfp);
        add(bfp);
        add(bh);
        add(bb);
        
        //Adding Action Listeners
        
       bl.addActionListener(this);
       bh.addActionListener(this);
       bb.addActionListener(this);
       bfp.addActionListener(this);
    }
    
    
    
    
    // Main Function
    
    
public static void main(String[] args) {
        // TODO code application logic here
        
    }



   //Listeners


    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Back Button
      if(e.getSource()==bb)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
        //Home Button
        if(e.getSource()==bh)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
        //Forgot Password
        if(e.getSource()==bfp)
        {
            JOptionPane.showMessageDialog(this,"It's your fault");
           /* this.dispose();
            ChalkPad c=new ChalkPad();*/
        }
        //Login Button
        if(e.getSource()==bl)
        {
            
            //Check if ID and Pass are correct 
            
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
            PreparedStatement ps=con.prepareStatement("");
            ResultSet rs=ps.executeQuery("select * from fac where id='"+tid.getText()+"' and pass='"+tpass.getText()+"'");
        if(rs.next())
        {
          // JOptionPane.showMessageDialog(this,"Successfully Logged In!");
            this.dispose();
            dashfac df=new dashfac(rs.getString(3),rs.getString(4));
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Invalid Log In Credentials");
            tid.setText("");
            tpass.setText("");
        }
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            }
    }
}
