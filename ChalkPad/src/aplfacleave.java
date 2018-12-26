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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author architgarg
 */
public class aplfacleave extends JFrame implements ActionListener,ItemListener {
    
     //Declaration
     
    JLabel lrsn,lfdate,ltdate,ls;
    JTextArea trsn;
    Choice cfd,cfm,cfy,ctd,ctm,cty;
    JButton bsbm,bb,bh;
    String snm,sid;
    JRadioButton rf,rh;
    ButtonGroup bg;
    //Constructor 
       
    aplfacleave(String s1,String s2)
    {   
        snm=s1;
        sid=s2;
        //Frame Properties
        
        setTitle("Apply Leave");
        setLayout(null);
         setSize(1425,700);
         setVisible(true);
         
        //Inititalizing the Controls
        
         bh=new JButton("Home");
         bb=new JButton("<");
         lrsn=new JLabel("<html><h3>Reason</h3></html>");
         lfdate=new JLabel("<html><h3>From Date</h3></html>");
         ltdate=new JLabel("<html><h3>To Date</h3></html>");
         ls=new JLabel("<html><h3>Time Slot</h3></html>");
         rf=new JRadioButton("Full Day");
         rh=new JRadioButton("Half Day");
         bg=new ButtonGroup();
         bg.add(rf);
         bg.add(rh);
         trsn=new JTextArea();
         bsbm=new JButton("Submit");
         cfd=new Choice();
         cfd.addItem("-");
         for(int i=1;i<31;i++)
         {
             cfd.addItem(Integer.toString(i));
         }
         cfm=new Choice();
         cfm.addItem("-");
         cfm.addItem("Janurary");
         cfm.addItem("February");
         cfm.addItem("March");
         cfm.addItem("April");
         cfm.addItem("May");
         cfm.addItem("June");
         cfm.addItem("July");
         cfm.addItem("August");
         cfm.addItem("September");
         cfm.addItem("October");
         cfm.addItem("November");
         cfm.addItem("December");
         cfy=new Choice();
         cfy.addItem("-");
         cfy.addItem("2018");
         
         ctd=new Choice();
         
         ctd.addItem("-");
         for(int i=1;i<31;i++)
         {
             ctd.addItem(Integer.toString(i));
         }
         ctm=new Choice();
         ctm.addItem("-");
         ctm.addItem("Janurary");
         ctm.addItem("February");
         ctm.addItem("March");
         ctm.addItem("April");
         ctm.addItem("May");
         ctm.addItem("June");
         ctm.addItem("July");
         ctm.addItem("August");
         ctm.addItem("September");
         ctm.addItem("October");
         ctm.addItem("November");
         ctm.addItem("December");
         cty=new Choice();
         cty.addItem("-");
         cty.addItem("2018");
        //Positioning the Controls
        
        lfdate.setBounds(300,160,100,50);
         ltdate.setBounds(300,220,200,50);
         ls.setBounds(300,280,200,50);
         lrsn.setBounds(300,340,200,50);
         cfd.setBounds(500,160,70,50);
         ctd.setBounds(500,220,70,50);
         cfm.setBounds(570,160,100,50);
         ctm.setBounds(570,220,100,50);
         cfy.setBounds(680,160,80,50);
         cty.setBounds(680,220,80,50);
         rf.setBounds(500,280,100,50);
         rh.setBounds(620,280,100,50);
         trsn.setBounds(500,350,250,100);
         bh.setBounds(5,600,90,40);
         bb.setBounds(5,15,70,40);
         bsbm.setBounds(470,490,130,50);
         
         //Adding Controls to the Frame
         
         add(lrsn);
         add(lfdate);
         add(ltdate);
         add(ls);
         add(rf);
         add(rh);
         add(trsn);
         add(cfd);
         add(cfm);
         add(cfy);
         add(ctd);
         add(ctm);
         add(cty);
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
       // dlapply dlap=new dlapply("","");
    }
    



   //Listeners


    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s="",tsl="";
                String fd,fm,fy,td,tm,ty,fdt,tdt,ts="";
             fd=String.valueOf(cfd.getSelectedItem());
             fm=String.valueOf(cfm.getSelectedItem());
             fy=String.valueOf(cfy.getSelectedItem());
             td=String.valueOf(ctd.getSelectedItem());
             tm=String.valueOf(ctm.getSelectedItem());
             ty=String.valueOf(cty.getSelectedItem());
             fdt=fd+"-"+fm+"-"+fy;
             tdt=td+"-"+tm+"-"+ty;
        //Back Button
        if(e.getSource()==bb)
        {
            this.dispose();
            dashfac df=new dashfac(snm,sid);
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
                   if(rf.isSelected())
             {
                 tsl="Full Day";
             }
             if(rh.isSelected())
             {
                 tsl="Half Day";
             }
                  //Insertion
                  
                  try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into facleave values ('"+fdt+"','"+tdt+"','"+tsl+"','"+trsn.getText()+"','"+sid+"')");
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"Leave Applied Successfully");
        trsn.setText("");
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


