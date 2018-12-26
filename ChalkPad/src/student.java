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
 public class student extends JFrame implements ActionListener {
     
     //Declaration
     
    JLabel lid,lpass,lfp,lrl;
    JTextField tid,tpass;
    JButton bl,bh,bb,bfp;
    JComboBox cbr;
    //Constructor
    
    student()
    {
        
        //Frame Properties
        
        setTitle("Student Login");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        
        //Inititalizing the Controls
        
        lid=new JLabel("<html><body><h2>ID</h2><body></html>");
        lpass=new JLabel("<html><body><h2>PASSWORD</h2><body></html>");
        lrl=new JLabel("<html><body><h2>Role</h2><body></html>");
        lfp=new JLabel("<html><body><h3>Forgot Password?</h3><body></html>");
        tid=new JTextField(20);
        tpass=new JTextField(20);
        cbr=new JComboBox();
        bl=new JButton("Log In");
        bb=new JButton("<");
        bfp=new JButton("Click Here");
        bh=new JButton("Home");
        
        cbr.addItem("-");
        
         try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select distinct branch from student order by branch");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            cbr.addItem(rs.getString(1));
        }
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        
        
        //Positioning the Controls
        
        lid.setBounds(460,120,150,50);
        lpass.setBounds(460,170,150,50);
        lrl.setBounds(460,230,150,50);
        lfp.setBounds(630,388,250,50);
        tid.setBounds(690,125,230,30);
        tpass.setBounds(690,175,230,30);
        cbr.setBounds(690,230,230,50);
        bl.setBounds(460,300,450,50);
        bfp.setBounds(540,425,300,50);
        bb.setBounds(5,15,70,40);
        bh.setBounds(5,540,90,40);
        
        //Adding Controls to the Frame
        
        add(lid);
        add(tid);
        add(lpass);
        add(tpass);
        add(lrl);
        add(cbr);
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
            ResultSet rs=ps.executeQuery("select * from student where id='"+tid.getText()+"' and pass='"+tpass.getText()+"' and branch='"+cbr.getSelectedItem()+"'");
        if(rs.next())
        {
          // JOptionPane.showMessageDialog(this,"Successfully Logged In!");
         //  JOptionPane.showMessageDialog(this,"Student Dashboard is under Maintenance yet");
            this.dispose();
            dashstud ds=new dashstud(rs.getString(3),rs.getString(4));
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
