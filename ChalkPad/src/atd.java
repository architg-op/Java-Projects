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
public class atd extends JFrame implements ActionListener,ItemListener {
    
    //Declaration
    
    Choice c1,c2,c3,c4,csub,cln;
    JLabel ldate,lid,ls,lsub,lln;
    JTextField tid;
    JRadioButton rp,ra;
    JButton bsbm,bh,bb;
    ButtonGroup bg;
    String snm,sid;
        
    //Constructor 
       
    atd(String s1,String s2)
    {   snm=s1;
        sid=s2;
        //Frame Properties
        
        setTitle("Upload Attendance");
        setLayout(null);
         setSize(1425,600);
         setVisible(true);
         
        //Inititalizing the Controls
        
         bh=new JButton("Home");
         bb=new JButton("<");
         lln=new JLabel("<html><h3>Lecture No.</h3></html>");
         ldate=new JLabel("<html><h3>Date</h3></html");
         lid=new JLabel("<html><h3>ID</h3></html>");
         lsub=new JLabel("<html><h3>Subject</h3></html>");
         tid=new JTextField(20);
         ls=new JLabel("<html><h3>Status</h3></html>");
         bsbm=new JButton("Submit");
         rp=new JRadioButton("Present");
         ra=new JRadioButton("Absent",true);
         bg=new ButtonGroup();
         bg.add(rp);
         bg.add(ra);
         cln=new Choice();
         cln.addItem("-");
         for(int i=1;i<=8;i++)
         {
             cln.addItem(String.valueOf(i));
         }
         c1=new Choice();
         c1.addItem("-");
         for(int i=1;i<31;i++)
         {
             c1.addItem(Integer.toString(i));
         }
         c2=new Choice();
         c2.addItem("-");
         c2.addItem("Janurary");
         c2.addItem("February");
         c2.addItem("March");
         c2.addItem("April");
         c2.addItem("May");
         c2.addItem("June");
         c2.addItem("July");
         c2.addItem("August");
         c2.addItem("September");
         c2.addItem("October");
         c2.addItem("November");
         c2.addItem("December");
         c3=new Choice();
         c3.addItem("-");
         c3.addItem("2018");
         c4=new Choice();
         c4.addItem("-");
          try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select id from student order by id ");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            c4.add(rs.getString(1));
        }
            }
            catch(Exception e1){
                System.out.println(e1);
            }       
         csub=new Choice();
                try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("select sub from fac  where name='"+s1+"' ");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            csub.add(rs.getString(1));
        }
            }
            catch(Exception e1){
                System.out.println(e1);
            }       
                snm=s1;
                
        //Positioning the Controls
        
         lln.setBounds(300,90,90,50);
         cln.setBounds(500,90,340,50);
         ldate.setBounds(300,150,90,50);
         lid.setBounds(300,280,50,50);
         //tid.setBounds(490,230,150,30);
         c4.setBounds(500,290,340,30);
         ls.setBounds(300,340,100,50);
         rp.setBounds(500,340,150,50);
         ra.setBounds(600,340,150,50);
         bsbm.setBounds(550,420,130,50);
         c1.setBounds(500,150,80,50);
         c2.setBounds(600,150,120,50);
         c3.setBounds(740,150,100,50);
         lsub.setBounds(300,220,100,50);
         csub.setBounds(500,220,340,50);
         bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
         
         //Adding Controls to the Frame
         
         add(lln);
         add(cln);
        add(lid);
         add(ldate);
         add(tid);
         add(c1);
         add(c2);
         add(c3);
         add(c4);
         add(ra);
         add(rp);
         add(ls);
         add(bsbm);
         add(bh);
         add(bb);
         add(lsub);
         add(csub);
         
      //Adding  Listeners
        
         bsbm.addActionListener(this);
         bh.addActionListener(this);
         bb.addActionListener(this);
    }
    public static void main(String args[])
    {
     //atd a=new atd(s);  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Back Button
      String s2="",ss="",ssub="";
      if(e.getSource()==bb)
        {
            this.dispose();
            dashfac d=new dashfac(snm,sid);
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
          //  JOptionPane.showMessageDialog(this,"This Section is under Maintenance yet");
       if(rp.isSelected())
       {
        ss="Present";   
       }
       else if(ra.isSelected())
       {
           ss="Absent";
       }
       String d,m,y,date,sid;
       d=c1.getSelectedItem();
       m=c2.getSelectedItem();
       y=c3.getSelectedItem();
       date=d+"-"+m+"-"+y;
       sid=c4.getSelectedItem();
       ssub=csub.getSelectedItem();
        try{
        Class.forName("com.mysql.jdbc.Driver");
       
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into atd values ('"+date+"','"+cln.getSelectedItem()+"','"+ssub+"','"+sid+"','"+ss+"','"+snm+"')");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Record Updated!");
        tid.setText("");
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
