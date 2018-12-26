/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author architgarg
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author architgarg
 */
public class cadmpass extends JFrame implements ActionListener,ItemListener{
    JLabel lop,lnp;
    JTextField top,tnp;
    JButton bsbm,bb,bh;
    String sid,snm;
    cadmpass(String s1,String s2)
    {    snm=s1;
         sid=s2;
        setTitle("PASSWORD CHANGE");
        setLayout(null);
         setSize(1425,600);
         setVisible(true);
         
        bh=new JButton("Home");
         bb=new JButton("<");
         lop=new JLabel("<html><h3>OLD PASSWORD</h3></html>");
         lnp=new JLabel("<html><h3>NEW PASSWORD</h3></html>");
         top=new JTextField(20);
         tnp=new JTextField(20);
         bsbm=new JButton("SUBMIT");
         
        lop.setBounds(470,200,150,50);
        lnp.setBounds(470,300,150,50);
        top.setBounds(700,210,200,30);
        tnp.setBounds(700,305,200,30);
        bsbm.setBounds(470,400,430,50);
         bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
         
         add(lop);
         add(top);
         add(lnp);
         add(tnp);
         add(bsbm);
         add(bh);
         add(bb);
         
         
         bsbm.addActionListener(this);
         bh.addActionListener(this);
         bb.addActionListener(this);
    }
    
    public static void main(String args[])
    {
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Back Button
      String s2="",ss="",ssub="";
      if(e.getSource()==bb)
        {
            this.dispose();
            dashadmin ds=new dashadmin(snm,sid);
        }
      //Home Button
              if(e.getSource()==bh)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
        if(e.getSource()==bsbm)
        {
            //JOptionPane.showMessageDialog(this,"See, You need an Administrator Permission");
             try
            {
        Class.forName("com.mysql.jdbc.Driver");
       
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from admin where pass=? and id=?");
        ps.setString(1,top.getText());
        ps.setString(2,sid);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
        ps=con.prepareStatement("update admin set pass='"+tnp.getText()+"' where id='"+sid+"' and pass='"+top.getText()+"'");;
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"PASSWORD CHANGED SUCCESSFULLY");
        }
        else
        {
             JOptionPane.showMessageDialog(this,"INCORRECT OLD PASSWORD");
        }
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
