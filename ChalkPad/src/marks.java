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
public class marks extends JFrame implements ActionListener,ItemListener,FocusListener{
    Choice c1,c2,c3,c4,csub,cet;
    JLabel ldate,lid,lm,lsub,let;
    JTextField tid,tobm,ttm;
    JButton bsbm,bh,bb;
    String snm,sid;
    marks(String s1,String s2)
    {   snm=s1;
        sid=s2;
        //Frame Properties
        
        setTitle("Upload Marks");
        setLayout(null);
         setSize(1425,600);
         setVisible(true);
         
        //Inititalizing the Controls
        
         bh=new JButton("Home");
         bb=new JButton("<");
         let=new JLabel("<html><h3>Exam Type</h3></html>");
         ldate=new JLabel("<html><h3>ExaminationDate</h3></html");
         lid=new JLabel("<html><h3>ID</h3></html>");
         lsub=new JLabel("<html><h3>Subject</h3></html>");
         tid=new JTextField(20);
         lm=new JLabel("<html><h3>Marks</h3></html>");
         bsbm=new JButton("Submit");
         tobm=new JTextField("Obtained");
         tobm.addFocusListener(this);
         ttm=new JTextField("Total");
         ttm.addFocusListener(this);
         cet=new Choice();
         cet.addItem("-");
         cet.addItem("1st S.T.");
         cet.addItem("2nd S.T.");
         cet.addItem("3rd S.T.");
         cet.addItem("End-Term");
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
        
         let.setBounds(300,90,90,50);
         cet.setBounds(500,90,340,50);
         ldate.setBounds(300,150,90,50);
         lid.setBounds(300,280,50,50);
         //tid.setBounds(490,230,150,30);
         c4.setBounds(500,290,340,30);
         lm.setBounds(300,340,100,50);
         tobm.setBounds(500,345,100,30);
         ttm.setBounds(640,345,100,30);
         bsbm.setBounds(550,420,130,50);
         c1.setBounds(500,150,80,50);
         c2.setBounds(600,150,120,50);
         c3.setBounds(740,150,100,50);
         lsub.setBounds(300,220,100,50);
         csub.setBounds(500,220,340,50);
         bh.setBounds(5,540,90,40);
         bb.setBounds(5,15,70,40);
         
         //Adding Controls to the Frame
         
         add(let);
         add(cet);
        add(lid);
         add(ldate);
         add(tid);
         add(c1);
         add(c2);
         add(c3);
         add(c4);
         add(tobm);
         add(ttm);
         add(lm);
         add(bsbm);
         add(bh);
         add(bb);
         add(lsub);
         add(csub);
         
         //Adding Listeners
         
         bsbm.addActionListener(this);
         bh.addActionListener(this);
         bb.addActionListener(this);
    }
    public static void main(String args[])
    {
     //marks m=new marks("Hello");  
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
        PreparedStatement ps=con.prepareStatement("insert into marks values ('"+cet.getSelectedItem()+"','"+date+"','"+ssub+"','"+sid+"','"+tobm.getText()+"',+'"+ttm.getText()+"','"+snm+"')");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Response Recorded!");
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

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==tobm)
        {
            tobm.setText("");
        }
        if(e.getSource()==ttm)
        {
            ttm.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
