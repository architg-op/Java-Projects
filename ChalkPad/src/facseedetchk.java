/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*; 
/**
 *
 * @author architgarg
 */
public class facseedetchk extends JFrame implements ActionListener{
    
     //Declaration
     
    JLabel lid;
    JTextField tid;
     String snm,sid;
     JButton bh,bb,bchk;
    //Constructor 
       
    facseedetchk(String s1,String s2)
    {     
        snm=s1;
        sid=s2;
        //Frame Properties
        
        bb=new JButton("<");
        bh=new JButton("Home");
        setTitle("See Faculty Details Portal");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        
        lid=new JLabel("Enter ID");
        tid=new JTextField(30);
        bchk=new JButton("Check");
        
        lid.setBounds(400,250,150,50);
        tid.setBounds(650,255,200,30);
        bchk.setBounds(400,330,450,50);
        bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
        
        add(lid);
        add(tid);
        add(bchk);
        add(bh);
         add(bb);
        bchk.addActionListener(this);
        bb.addActionListener(this);
         bh.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bb)
        {
            this.dispose();
            seedet sd = new seedet(snm,sid);
        }
      //Home Button
              if(e.getSource()==bh)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
        if(e.getSource()==bchk)
        {
           // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            this.dispose();
            facprofseedchk afdh=new facprofseedchk(snm,sid,tid.getText());
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
        