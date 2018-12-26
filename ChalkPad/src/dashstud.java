import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author architgarg
 */
public class dashstud extends JFrame implements ActionListener,ItemListener{
    
     //Declaration
     
    JButton bh,bcatd,bcmark,bapdl,bapml,bpfs,bpfn,bdn,bcp,bsff,byp;
    JLabel lwel;
    Choice c;
    String snm,sid;
    //Constructor 
       
    dashstud(String s1,String s2)
    {   snm=s1;
        sid=s2;
        //Frame Properties
        
        setTitle("Student DashBoard");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        //Inititalizing the Controls
        
        lwel=new JLabel("Welcome, "+snm);
        bh=new JButton("Home");
        bcatd=new JButton("CHECK ATTENDANCE");
        bcmark=new JButton("CHECK MARKS");
        bapdl=new JButton("APPLY DL");
        bapml=new JButton("APPLY ML");
        bcp=new JButton("CHANGE PASSWORD");
        bpfs=new JButton("PAY FEES");
        bpfn=new JButton("PAY FINE");
        bdn=new JButton("DISPLAY NOTICES");
        bsff=new JButton("STUDENT FEEDBACK FORM");
        byp=new JButton("YOUR PROFILE");
        
        //Positioning the Controls
        
        lwel.setBounds(1230,10,200,50);
         bcatd.setBounds(200,100,250,60);
        bcmark.setBounds(200,200,250,60);
        bapdl.setBounds(200,300,250,60);
        bapml.setBounds(200,400,250,60);
        bcp.setBounds(410,500,250,60);
        bdn.setBounds(620,100,250,60);
        bpfs.setBounds(620,200,250,60);
        bpfn.setBounds(620,400,250,60);
        bsff.setBounds(620,300,250,60);
        byp.setBounds(1020,225,260,80);
        bh.setBounds(5,540,90,40);
        c=new Choice();
        c.setBounds(1300,45,120,50);
        c.addItem("Options");
        c.addItem("Log Out");
        
        //Adding Controls to the Frame
        
        add(c);
        add(bh);
         add(bcatd);
        add(bcmark);
        add(bapdl);
        add(bapml);
        add(bcp);
        add(byp);
        add(bdn);
        add(bpfs);
        add(bpfn);
        add(bsff);
        add(lwel);
        
      //Adding Action Listeners
        
        bh.addActionListener(this);
        bcatd.addActionListener(this);
        bcmark.addActionListener(this);
        bapdl.addActionListener(this);
        bapml.addActionListener(this);
        bpfs.addActionListener(this);
        bpfn.addActionListener(this);
        bdn.addActionListener(this);
        bcp.addActionListener(this);
        bsff.addActionListener(this);
        byp.addActionListener(this);
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
         //Check Attendance
         if(e.getSource()==bcatd)
         {
             JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
         }
         
         //APPLY DL 
              
              if(e.getSource()==bapdl)
              {
                // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                 dlapply dlap=new dlapply(snm,sid);
              }
              
      //APPLY ML
      
              if(e.getSource()==bapml)
              {
                  //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  mlapply mlap=new mlapply(snm,sid);
              }
              
      // CHECK MARKS
      
              if(e.getSource()==bcmark)
              {
                  JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
              }
              
      //PAY FEES
      
              if(e.getSource()==bpfs)
              {
                  //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  payfees pf=new payfees(snm,sid);
              }
      
      
      // CHANGE PASSWORD
             
              if(e.getSource()==bcp)
              {
                  //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  this.dispose();
                  cstupass cp=new cstupass(snm,sid);
              }
              
      // PROFILE
           
              if(e.getSource()==byp)
              {
                  //JOptionPane.showMessageDialog(this,"Profile Section is under Maintenance yet");
                  this.dispose();
                  studprof sp=new studprof(snm,sid);
              }
              
              
      //PAY FINE
               if(e.getSource()==bpfn)
               {
                 // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                   this.dispose();
                   payfine pf=new payfine(snm,sid);
               }
      //Display Notices
      if(e.getSource()==bdn)
              {
                  JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
              }
       //STUDENT FEEDBACK FORM 
      if(e.getSource()==bsff)
    {
        // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
        this.dispose();
        sff sf=new sff(snm,sid);
    }
        
         
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //LogOut

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
            student s=new student();
            }
        }
    }
        //throw new dashstud("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

