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

public class payfine extends JFrame implements ActionListener,ItemListener{
    
     //Declaration
     
    JLabel lamt,lty,lptm,tamt,lrsn,trsn;
    Choice cty,cpm; 
     JButton bh,bb,bpay;
     String snm,sid;
     int f=0;
     
    //Constructor 
       
    payfine(String s1,String s2)
    {     
        snm=s1;
        sid=s2;
        //Frame Properties
        
        
        setTitle("Pay Fees Portal");
        setVisible(true);
        setSize(1425,600);
        setLayout(null);
        
        lamt=new JLabel("Amount to be paid");
        lty=new JLabel("Type");
        lptm=new JLabel("Payment Method");
        lrsn=new JLabel("Reason");
        tamt=new JLabel("Select the Type Below");
        trsn=new JLabel("Reason would be displayed according to its type");
        cty=new Choice();
        cpm=new Choice();
        bb=new JButton("<");
        bh=new JButton("Home");
        bpay=new JButton("Pay");
        cty.add("-");
        cpm.add("-");
        cpm.add("CREDIT CARD");
        cpm.add("DEBIT CARD");
        cpm.add("NETBANKING");
        cpm.add("UPI");
        lamt.setBounds(400,110,150,50);
        lty.setBounds(400,170,150,50);
        lrsn.setBounds(400,230,150,50);
        lptm.setBounds(400,290,150,50);
        tamt.setBounds(730,100,200,50);
        cty.setBounds(700,170,200,50);
        trsn.setBounds(700,230,500,50);
        cpm.setBounds(700,290,200,50);
        bh.setBounds(5,540,90,40);
        bb.setBounds(5,15,70,40);
        bpay.setBounds(400,380,500,40);
        
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from fine where id= '"+sid+"' and status='' ");             
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        cty.add(rs.getString(3));
        f=1;
        }
        if(f==0)
        {
            JOptionPane.showMessageDialog(this,"You have no Pending Fine");
            this.dispose();
            dashstud ds=new dashstud(snm,sid);
        }
        }
        catch(Exception e1){
                System.out.println(e1);
            }
        
        
        add(lamt);
        add(lty);
        add(lptm);
        add(lrsn);
        add(tamt);
        add(trsn);
        add(cty);
        add(cpm);
        add(bpay);
        add(bh);
        add(bb);
        bb.addActionListener(this);
         bh.addActionListener(this);
        bpay.addActionListener(this);
        cty.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bb)
        {
            this.dispose();
            dashstud dam = new dashstud(snm,sid);
        }
      //Home Button
              if(e.getSource()==bh)
        {
            this.dispose();
            ChalkPad c=new ChalkPad();
        }
            
              
        if(e.getSource()==bpay)
        {
           // JOptionPane.showMessageDialog(this,"Making Online Payment is under maintenance");
            try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("update fine set status='Paid',pm='"+cpm.getSelectedItem()+"' where id='"+sid+"' and type='"+cty.getSelectedItem()+"'");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Fine Paid Successfully");
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==cty)
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select * from fine where id= '"+sid+"' and status='' and type='"+cty.getSelectedItem()+"' ");             
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
        tamt.setText(rs.getString(2));
        trsn.setText(rs.getString(4));
        }
        
        }
             catch(Exception e1){
                System.out.println(e1);
            }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
}
