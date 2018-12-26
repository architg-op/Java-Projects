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
public class dashadmin extends JFrame implements ActionListener,ItemListener{
    
     //Declaration
     
    JButton brstud,bradm,brfac,bh,bpost,bafl,basl,bsd,byp,bcp,bgf,bgenf;
    JLabel lwel;
    Choice c;
    String snm,sid;
        
    //Constructor 
       
    dashadmin(String s1,String s2)
    {   
        snm=s1;
        sid=s2;
        //Frame Properties
        
        setTitle("Admin DashBoard");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        //Inititalizing the Controls
        
        bh=new JButton("Home");
        bh.setBounds(5,540,90,40);
        lwel=new JLabel("Welcome, "+snm);
        lwel.setBounds(1230,10,200,50);
        bafl=new JButton("FACULTY LEAVES");
        basl=new JButton("STUDENT LEAVES");
        bsd=new JButton("SEE DETAILS");
        bgf=new JButton("GENERATE FEES");
        bgenf=new JButton("GENERATE FINE");
        byp=new JButton("YOUR PROFILE");
        bcp=new JButton("CHANGE PASSWORD");
        bpost=new JButton("POST NOTICE");
        brstud=new JButton("REGISTRATION OF STUDENT");
        brfac=new JButton("REGISTRATION OF FACULTY");
        bradm=new JButton("REGISTRATION OF ADMINISTRATOR");
        c=new Choice();
        c.setBounds(1300,50,120,50);
        c.addItem("Select");
        c.addItem("Log Out");
        
        //Positioning the Controls
        
        bafl.setBounds(200,100,250,60);
        basl.setBounds(200,200,250,60);
        bsd.setBounds(200,300,250,60);
        bgf.setBounds(200,400,250,60);
        bgenf.setBounds(200,500,250,60);
        bpost.setBounds(620,100,250,60);
        brstud.setBounds(620,200,250,60);
        bradm.setBounds(620,400,250,60);
        brfac.setBounds(620,300,250,60);
        bcp.setBounds(620,500,250,60);
        byp.setBounds(1020,225,260,80);
        
        //Adding Buttons to the Frame
        
        add(bafl);
        add(basl);
        add(bsd);
        add(bgf);
        add(bgenf);
        add(bcp);
        add(byp);
        add(bpost);
        add(bh);
        add(brstud);
        add(bradm);
        add(brfac);
        add(lwel);
        add(c);
        
      //Adding  Listeners
      bafl.addActionListener(this);
      basl.addActionListener(this);
      bsd.addActionListener(this);
      bgf.addActionListener(this);
      bgenf.addActionListener(this);
      bcp.addActionListener(this);
      byp.addActionListener(this);
        bh.addActionListener(this);
        bpost.addActionListener(this);
        brstud.addActionListener(this);
        bradm.addActionListener(this);
        brfac.addActionListener(this);
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
              
     //Notice Post
              
              if(e.getSource()==bpost)
              {
                 // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  notice n=new notice(snm,sid);
              }
              
      //Faculty Leaves 
              
              if(e.getSource()==bafl)
              {
                 JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
              }
              
      //Student Leaves
      
              if(e.getSource()==basl)
              {
                  JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
              }
              
      // SEE DETAILS
      
              if(e.getSource()==bsd)
              {
               //   JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  seedet sdt=new seedet(snm,sid);
              }
              
        // GENERATE FEES
        
        if(e.getSource()==bgf)
              {
                  //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  genfees gf=new genfees(snm,sid);
              }
      
       // GENERATE FINE
        
        if(e.getSource()==bgenf)
              {
                  //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  genfine genf=new genfine(snm,sid);
              }
      
        
        
      // CHANGE PASSWORD
             
              if(e.getSource()==bcp)
              {
                  //JOptionPane.showMessageDialog(this,"Tgis Section is under Maintenance yet");
                  this.dispose();
                  cadmpass cap=new cadmpass(snm,sid);
              }
              
      // PROFILE
           
              if(e.getSource()==byp)
              {
                  //JOptionPane.showMessageDialog(this,"Profile Section is under Maintenance yet");
                  this.dispose();
                  admprof admp=new admprof(snm,sid);
              }
              
              
      //Student Registration
      if(e.getSource()==brstud)
      {
          this.dispose();
          regstud rs=new regstud(snm,sid);
      }
      //Faculty Registration
      if(e.getSource()==brfac)
              {
                  //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
          regfac rf=new regfac(snm,sid);
              }
       //Administration Registration
      if(e.getSource()==bradm)
    {
        //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
        this.dispose();
          regadmin ra=new regadmin(snm,sid);
    }
        }
    
    //Logout
    
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
            admin a=new admin();
            }
            
        }
    }
        //throw new dashstud("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
