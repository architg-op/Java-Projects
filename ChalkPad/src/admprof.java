/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author architgarg
 */
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
public class admprof extends JFrame implements ActionListener{
    
     //Declaration
     
    JButton bsup,bh,bb;
     JLabel lem,lmb,lfnm,lid,lty;
     JLabel tem,tmb,tfnm,tid,tty;
     Choice cty;
     String snm,sid;  
     
    //Constructor 
       
    admprof(String s1,String s2)
    {     
        snm=s1;
        sid=s2;
        //Frame Properties
        
        bb=new JButton("<");
        setTitle("YOUR PROFILE");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        //Inititalizing the Controls
        
        bh=new JButton("Home");
         bsup=new JButton("EDIT DETAILS");
         lem=new JLabel("Email");
         lmb=new JLabel("Mobile Number");
         lfnm=new JLabel("First Name");
         lid=new JLabel("ID");
         lty=new JLabel("Role");
         tem=new JLabel("");
         tmb=new JLabel("");
         tfnm=new JLabel("");
         tid=new JLabel("");
         tty=new JLabel("");
         cty=new Choice();
         cty.addItem("-");

         
         try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from admin where id= '"+sid+"' and name='"+snm+"'");             
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
        tem.setText(rs.getString(1));
        tmb.setText(rs.getString(2));
        tfnm.setText(rs.getString(3));
        tid.setText(rs.getString(4));
        tty.setText(rs.getString(6));
        }
         }
        catch(Exception e1){
                System.out.println(e1);
            }
        
        //Positioning the Controls
        
         lem.setBounds(450,140,100,50);
         lmb.setBounds(450,200,100,50);
         lfnm.setBounds(450,260,100,50);
         lid.setBounds(450,320,100,50);
         lty.setBounds(450,380,100,50);
         tem.setBounds(700,150,200,30);
         tmb.setBounds(700,210,200,30);
         tfnm.setBounds(700,270,200,30);
         tid.setBounds(700,330,200,30);
         tty.setBounds(700,390,200,30);
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
         add(lty);
         add(tty);
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
             JOptionPane.showMessageDialog(this,"You can't edit details right now");
            //Insert Values to Admin Table
            
            
        //cty.getSelectionModel.selectFirst();
            }
            
        }
}


