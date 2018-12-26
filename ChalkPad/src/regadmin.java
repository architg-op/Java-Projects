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
public class regadmin extends JFrame implements ActionListener{
    
     //Declaration
     
    JButton bsup,bh,bb;
     JLabel lem,lmb,lfnm,lid,lpass,lty;
     JTextField tem,tmb,tfnm,tid,tpass;
     Choice cty;
     String snm,sid;  
     
    //Constructor 
       
    regadmin(String s1,String s2)
    {     
        snm=s1;
        sid=s2;
        //Frame Properties
        
        bb=new JButton("<");
        setTitle("Admin Registration");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        //Inititalizing the Controls
        
        bh=new JButton("Home");
         bsup=new JButton("Sign Up");
         lem=new JLabel("Email");
         lmb=new JLabel("Mobile Number");
         lfnm=new JLabel("First Name");
         lid=new JLabel("ID");
         lpass=new JLabel("Password");
         lty=new JLabel("Role");
         tem=new JTextField(20);
         tmb=new JTextField(20);
         tfnm=new JTextField(20);
         tid=new JTextField(20);
         tpass=new JTextField(20);
         cty=new Choice();
         cty.addItem("-");
         cty.addItem("CHANCELLOR");
         cty.addItem("VICE CHANCELLOR");
         cty.addItem("REGISTAR");
         cty.addItem("DEAN EXAMINATION");
         
        //Positioning the Controls
        
         lem.setBounds(500,140,100,50);
         lmb.setBounds(500,200,100,50);
         lfnm.setBounds(500,260,100,50);
         lid.setBounds(500,320,100,50);
         lpass.setBounds(500,380,100,50);
         lty.setBounds(500,440,100,50);
         tem.setBounds(650,145,200,30);
         tmb.setBounds(650,205,200,30);
         tfnm.setBounds(650,265,200,30);
         tid.setBounds(650,325,200,30);
         tpass.setBounds(650,385,200,30);
         cty.setBounds(650,440,200,50);
         bsup.setBounds(500,500,350,50);
         bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
         
         //Adding Controls to the Frame
         
         add(lem);
         add(tem);
         add(lmb);
         add(tmb);
         add(lfnm);
         add(tfnm);
         add(lid);
         add(lty);
          add(tid);
         add(lpass);
         add(tpass);
         add(cty);
         add(bsup);
         add(bh);
         add(bb);
         
      //Adding Action Listeners
        
         bb.addActionListener(this);
         bsup.addActionListener(this);
         bh.addActionListener(this);
    }
        
    
    
    
    // Main Function
    
    
    
    public static void main(String args[])
    {
        //regadmin r=new regadmin("ADMINSITRATOR");
    }
    


   //Listeners


    
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
      //Sign Up Button
        if(e.getSource()==bsup)
        {
            
            //Insert Values to Admin Table
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into admin values(?,?,?,?,?,?)");
        ps.setString(1,tem.getText());
        ps.setDouble(2,Double.parseDouble(tmb.getText()));
        ps.setString(3,tfnm.getText());
        ps.setString(4,tid.getText());
        ps.setString(5,tpass.getText());
        ps.setString(6,cty.getSelectedItem());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Successfully Registered!");
        tem.setText("");
        tmb.setText("");
        tfnm.setText("");
        tid.setText("");
        tpass.setText("");
        //cty.getSelectionModel.selectFirst();
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
        }
}

