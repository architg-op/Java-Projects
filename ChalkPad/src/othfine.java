/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author architgarg
 */
public class othfine extends JFrame implements ActionListener,ItemListener {
    
     //Declaration
     
    JLabel lsub,lbody,ltype,lamt;
    JTextField tsub,tamt;
    JTextArea tbody;
    Choice c;
    JButton bsbm,bb,bh;
    String snm,sid;
    
    //Constructor 
       
    othfine(String s1,String s2)
    {   
        snm=s1;
        sid=s2;
        //Frame Properties
        
        setTitle("Other Fine");
        setLayout(null);
         setSize(1425,600);
         setVisible(true);
         
        //Inititalizing the Controls
        
         bh=new JButton("Home");
         bb=new JButton("<");
         ltype=new JLabel("<html><h3>ID</h3></html");
         lsub=new JLabel("<html><h3>Amount</h3></html>");
         lbody=new JLabel("<html><h3>Reason</h3></html>");
         tsub=new JTextField(20);
         tbody=new JTextArea();
         bsbm=new JButton("Generate");
         c=new Choice();
         c.addItem("-");
         
         try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select id from student order by id");             
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        c.add(rs.getString(1));
        }
        }
        catch(Exception e1){
                System.out.println(e1);
            }
         
        //Positioning the Controls
        
         ltype.setBounds(300,150,90,50);
         lsub.setBounds(300,220,50,50);
         lbody.setBounds(300,280,100,50);
         c.setBounds(500,150,250,50);
         tsub.setBounds(500,230,250,30);
         tbody.setBounds(500,280,250,150);
         bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
         bsbm.setBounds(470,470,130,50);
         
         //Adding Controls to the Frame
         
         add(ltype);
         add(c);
         add(lsub);
         add(tsub);
         add(lbody);
         add(tbody);
         add(bh);
         add(bb);
         add(bsbm);
         
      //Adding Action Listeners
        
         bsbm.addActionListener(this);
         bb.addActionListener(this);
         bh.addActionListener(this);
    }
        
    
    
    
    // Main Function
    
    
    
    public static void main(String args[])
    {
       // notice n=new notice("");
    }



   //Listeners


    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s="";
        //Back Button
        if(e.getSource()==bb)
        {
            this.dispose();
            genfine genf = new genfine(snm,sid);
        }
      //Home Button
              if(e.getSource()==bh)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
              //Submit Button
              if(e.getSource()==bsbm)
              {
                  String s3=c.getSelectedItem();
                  
                  //Insertion
                  
                  try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into fine values ('"+s3+"','"+tsub.getText()+"','Other','"+tbody.getText()+"')");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record Updated!");
        tsub.setText("");
        tbody.setText("");
            }
            catch(Exception e1){
                System.out.println(e1);
            }
              }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
