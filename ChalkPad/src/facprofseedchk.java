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
public class facprofseedchk extends JFrame implements ActionListener{
    
     //Declaration
     
    JButton bsup,bh,bb;
     JLabel lem,lmb,lfnm,lid,lpass,lsub,tid;
     JTextField tem,tmb,tfnm,tpass;
     Choice csub;
     String snm,sid,sidchk;   
     
    //Constructor 
       
    facprofseedchk(String s1,String s2,String s3)
    {  
        snm=s1;
        sid=s2;
        sidchk=s3;
        //Frame Properties
        
        bb=new JButton("<");
        setTitle("Faculty Details");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        //Inititalizing the Controls
        
        bh=new JButton("Home");
         bsup=new JButton("UPDATE");
         lem=new JLabel("Email");
         lmb=new JLabel("Mobile Number");
         lfnm=new JLabel("First Name");
         lid=new JLabel("ID");
         tid=new JLabel("");
         lpass=new JLabel("Password");
         lsub=new JLabel("Subjects Alloted");
         csub=new Choice();
          try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from sub order by name");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            csub.add(rs.getString(1));
        }
            }
            catch(Exception e1){
                System.out.println(e1);
            }
          
          
          
         tem=new JTextField(20);
         tmb=new JTextField(20);
         tfnm=new JTextField(20);
         
         tpass=new JTextField(20);
         
         
         try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from fac where id= '"+sidchk+"' ");             
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
        tem.setText(rs.getString(1));
        tmb.setText(rs.getString(2));
        tfnm.setText(rs.getString(3));
        tid.setText(rs.getString(4));
        tpass.setText(rs.getString(5));
        csub.select(rs.getString(6));
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Entered ID doesn't exist");
            this.dispose();
            facseedetchk fsdc = new facseedetchk(snm,sid);
        }
         }
        catch(Exception e1){
                System.out.println(e1);
            }
         
         
         
        //Positioning the Controls
        
         lem.setBounds(500,100,100,50);
         lmb.setBounds(500,160,100,50);
         lfnm.setBounds(500,220,100,50);
         lid.setBounds(500,280,100,50);
         lpass.setBounds(500,340,100,50);
         tem.setBounds(650,105,200,30);
         tmb.setBounds(650,165,200,30);
         tfnm.setBounds(650,225,200,30);
         tid.setBounds(650,285,200,30);
         tpass.setBounds(650,345,200,30);
         lsub.setBounds(500,400,100,50);
         csub.setBounds(650,400,150,50);
         bsup.setBounds(500,500,350,50);
         bh.setBounds(5,440,90,40);
         bb.setBounds(5,15,70,40);
         
         //Adding Controls to the Frame
         
         add(lem);
         add(tem);
         add(lmb);
         add(tmb);
         add(lfnm);
         add(tfnm);
         add(lid);
          add(tid);
         add(lpass);
         add(tpass);
         add(bsup);
         add(bh);
         add(bb);
         add(lsub);
         add(csub);
         
      //Adding Action Listeners
        
         bb.addActionListener(this);
         bsup.addActionListener(this);
         bh.addActionListener(this);
    }
    

    //MAIN 
    
    public static void main(String args[])
    {
        //regfac r=new regfac("FACULTY");
    }

   //Listeners


    
     @Override
    public void actionPerformed(ActionEvent e) {
        String s="",ssub;
      //Back Button
      ssub=csub.getSelectedItem();
      if(e.getSource()==bb)
        {
            this.dispose();
           facseedetchk fsdc = new facseedetchk(snm,sid);
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
        PreparedStatement ps=con.prepareStatement("update fac set email='"+tem.getText()+"',mb_no='"+tmb.getText()+"',name='"+tfnm.getText()+"',pass='"+tpass.getText()+"',sub='"+csub.getSelectedItem()+"' where id='"+sidchk+"' ");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Successfully Modified!");
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
        }
}
