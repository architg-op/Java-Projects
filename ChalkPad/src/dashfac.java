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
 * 
 * @author architgarg
 */
public class dashfac extends JFrame implements ActionListener,ItemListener{
    
     //Declaration
     
    JButton bh,bupa,bupm,bapl,bdn,bcp,byp,baprl;
    JLabel lwel;
    Choice c;
    String snm,sid;
        
    //Constructor 
       
    dashfac(String s1,String s2)
    {    snm=s1;
         sid=s2;
        //Frame Properties
        
        
        setTitle("Faculty DashBoard");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        //Inititalizing the Controls
        
        bh=new JButton("Home");
        lwel=new JLabel("Welcome, "+snm);
        bapl=new JButton("APPLY LEAVE");
        baprl=new JButton("APPROVE DL'S");
        bdn=new JButton("DISPLAY NOTICES");
        bcp=new JButton("CHANGE PASSWORD");
        byp=new JButton("YOUR PROFILE");
        bupa=new JButton("UPLOAD ATTENDANCE");
        bupm=new JButton("UPLOAD MARKS");
        c=new Choice();
        c.addItem("Select");
        c.addItem("Log Out");
        
        
        
        //Positioning the Controls
        
        lwel.setBounds(1230,10,200,50);
        c.setBounds(1300,45,120,50);
        bh.setBounds(5,540,90,40);
        bapl.setBounds(200,250,170,50);
        baprl.setBounds(370,150,170,50);
        bdn.setBounds(200,350,170,50);
        bcp.setBounds(370,420,200,60);
        bupa.setBounds(600,250,170,50);
        bupm.setBounds(600,350,170,50);
        byp.setBounds(1020,225,260,80);
        //Adding Controls to the Frame
        
        add(c);
        add(bh);
        add(bapl);
        add(baprl);
        add(bdn);
        add(bcp);
        add(bupa);
        add(bupm);
        add(lwel);
        add(byp);
        
      //Adding Action Listeners
        
        bh.addActionListener(this);
        bapl.addActionListener(this);
        baprl.addActionListener(this);
        bdn.addActionListener(this);
        bcp.addActionListener(this);
        byp.addActionListener(this);
        bupa.addActionListener(this);
        bupm.addActionListener(this);
        c.addItemListener(this);
    }
    


   //Listeners


    
    @Override
    public void actionPerformed(ActionEvent e) {
      //Home Button
              if(e.getSource()==bh)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
              
     //Display Notices
              
              if(e.getSource()==bdn)
              {
                  JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
              }
              
      //Apply Leaves 
              
              if(e.getSource()==bapl)
              {
                 //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  aplfacleave afl=new aplfacleave(snm,sid);
              }
              
                            
      //Approve Leaves 
              
              if(e.getSource()==baprl)
              {
                 JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
              }
             
      // CHANGE PASSWORD
             
              if(e.getSource()==bcp)
              {
                  //.showMessageDialog(this,"Tgis Section is under Maintenance yet");
                  this.dispose();
                  cfacpass cfp=new cfacpass(snm,sid);
              }
              
      // PROFILE
           
              if(e.getSource()==byp)
              {
                  //JOptionPane.showMessageDialog(this,"Profile Section is under Maintenance yet");
                  this.dispose();
                  facprof admp=new facprof(snm,sid);
              }
              
         //Upload Attendance
         if(e.getSource()==bupa)
         {
            // JOptionPane.showMessageDialog(this,"This Section is under Maintenanc yete");
             this.dispose();
             atd at=new atd(snm,sid);
         }
         //Upload Marks
         if(e.getSource()==bupm)
         {
             //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
             this.dispose();
             marks m=new marks(snm,sid);
         }
    }
    
    //Log Out
    
      @Override
    public void itemStateChanged(ItemEvent e) {
         String s1=c.getSelectedItem();
        String s2="Log Out";
        if(s1.equals(s2))
        {
           int a1=JOptionPane.showConfirmDialog(this,"You're being logged out");
            System.out.println(a1);
            if(a1==0)
            {
            this.dispose();
            fac f=new fac();
            }
        }
    }
        //throw new dashstud("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
