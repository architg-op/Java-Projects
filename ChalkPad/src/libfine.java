/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import chalkpad.student;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author architgarg
 */
public class libfine extends JFrame implements ActionListener {
    
    //Declaration
    
    JLabel lid,lbook,lnd,lamt,tamt;
    Choice cid,cbook;
    JTextField tnd;
    JButton bh,bb,bgen,bcalc; 
    String snm,sid;
        
    //Constructor 
       
    libfine(String s1,String s2)
    {
        snm=s1;
        sid=s2;
        //Frame Properties
        
        setLayout(null);
        setVisible(true);
        setTitle("Library Fine Portal");
        setSize(1425,600);
        
        //Inititalizing the Controls
        
         bb=new JButton("<");
        bh=new JButton("Home");
        bgen=new JButton("Generate");
        bcalc=new JButton("Calculate");
        lid=new JLabel("ID");
        lbook=new JLabel("Book Borrowed");
        lnd=new JLabel("No.of Days exceeded due date");
        lamt=new JLabel("Amount");
        tamt=new JLabel("Amount would be Displayed");
        tnd=new JTextField(10);
        cid=new Choice();
        cbook=new Choice();
        
        
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select id from student order by id");             
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        cid.add(rs.getString(1));
        }
        }
        catch(Exception e1){
                System.out.println(e1);
            }
        
        
         try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select bname from books order by bname");             
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        cbook.add(rs.getString(1));
        }
        }
        catch(Exception e1){
                System.out.println(e1);
            }
        
        
        
        //Positioning the Controls
        
        bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
         lid.setBounds(380,120,100,50);
         lbook.setBounds(380,200,100,50);
         lnd.setBounds(380,280,200,50);
         lamt.setBounds(380,360,100,50);
         tamt.setBounds(730,368,350,30);
         bcalc.setBounds(820,280,180,40);
         cid.setBounds(650,120,350,50);
         cbook.setBounds(650,200,350,50);
         tnd.setBounds(650,285,150,30);
         bgen.setBounds(380,470,620,50);
        //Adding Controls to the Frame
        
        add(bh);
        add(bb);
        add(lid);
        add(lbook);
        add(lnd);
        add(lamt);
        add(tamt);
        add(cid);
        add(cbook);
        add(tnd);
        add(bgen);
        add(bcalc);
                
        //Adding Action Listeners
        
         bb.addActionListener(this);
         bh.addActionListener(this);
         bcalc.addActionListener(this);
         bgen.addActionListener(this);
    }

    
    
    
    // Main Function
    
    
    public static void main(String[] args)
    {
        
    }



   //Listeners


    
    @Override
    public void actionPerformed(ActionEvent e) {
        
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
        
              //Calculate Button
              if(e.getSource()==bcalc)
              {
                  Double val,tval;
                  val=Double.parseDouble(tnd.getText());
                  tval=val*2;
                  tamt.setText(String.valueOf(tval));
              }
            String sty="Library";
            String sdescr="No. of Days Exceeding "+tnd.getText()+" for Book "+cbook.getSelectedItem();
              if(e.getSource()==bgen)
              {
                 // JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
                  try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into fine values ('"+cid.getSelectedItem()+"','"+tamt.getText()+"','"+sty+"','"+sdescr+"','','')");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"FINE GENERATED");
        tnd.setText("");
            }
            catch(Exception e1){
                System.out.println(e1);
            }
              }
              

    }
    
}
 