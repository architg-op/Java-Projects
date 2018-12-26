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
public class genfees extends JFrame implements ActionListener{
    
     //Declaration
     
    JLabel lid,lamt,lty;
    JTextField tid,tamt;
     String snm,sid;
     JButton bh,bb,bchk;
     JRadioButton rh,ra;
     ButtonGroup bg;
    //Constructor 
       
    genfees(String s1,String s2)
    {     
        snm=s1;
        sid=s2;
        //Frame Properties
        
        bb=new JButton("<");
        bh=new JButton("Home");
        setTitle("Generate Fees Portal");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        
        lid=new JLabel("Enter ID");
        lamt=new JLabel("Amount");
        lty=new JLabel("Type");
        tid=new JTextField(30);
        tamt=new JTextField(10);
        bchk=new JButton("Generate");
        ra=new JRadioButton("Acaedmic Fees");
        rh=new JRadioButton("Hostel Fees");
        bg=new ButtonGroup();
        bg.add(rh);
        bg.add(ra);
        
        
        lid.setBounds(400,130,150,50);
        lamt.setBounds(400,190,150,50);
        lty.setBounds(400,250,150,50);
        tid.setBounds(650,135,200,30);
        tamt.setBounds(650,195,200,30);
        ra.setBounds(650,255,150,30);
        rh.setBounds(650,300,150,30);
        bchk.setBounds(400,360,450,50);
        bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
         
        
        add(lid);
        add(lamt);
        add(lty);
        add(tid);
        add(tamt);
        add(ra);
        add(rh);
        add(bchk);
        add(bh);
         add(bb);
        bchk.addActionListener(this);
        bb.addActionListener(this);
         bh.addActionListener(this);
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
              
        if(e.getSource()==bchk)
        {
            
            
            String tsl="";
                   if(ra.isSelected())
             {
                 tsl="Acaedmic Fees";
             }
             if(rh.isSelected())
             {
                 tsl="Hostel Fees";
             }
            
            //JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
            
                  try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into fees values ('"+tid.getText()+"','"+tamt.getText()+"','"+tsl+"','','')");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Fees Generated Successfully");
        tamt.setText("");
        tid.setText("");
            }
            catch(Exception e1){
                System.out.println(e1);
            }
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
        