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
public class dlapply extends JFrame implements ActionListener,ItemListener {
    
     //Declaration
     
    JLabel leve,lfdate,lcat,ltdate,lts;
    JTextField teve;
    Choice cfd,cfm,cfy,ctd,ctm,cty;
    JComboBox ccat;
    JButton bsbm,bb,bh;
    String snm,sid;
    JRadioButton rf,rh;
    ButtonGroup bg;
    //Constructor 
       
    dlapply(String s1,String s2)
    {   
        snm=s1;
        sid=s2;
        //Frame Properties
        
        setTitle("Apply DL");
        setLayout(null);
         setSize(1425,700);
         setVisible(true);
         
        //Inititalizing the Controls
        
         bh=new JButton("Home");
         bb=new JButton("<");
         lcat=new JLabel("<html><h3>Category</h3></html");
         leve=new JLabel("<html><h3>Event</h3></html>");
         lfdate=new JLabel("<html><h3>From Date</h3></html>");
         ltdate=new JLabel("<html><h3>To Date</h3></html>");
         lts=new JLabel("<html><h3>Time Slot</h3></html>");
         teve=new JTextField(20);
         bsbm=new JButton("Submit");
         ccat=new JComboBox();
         ccat.addItem("Club EBuzz");
         ccat.addItem("CSE Deptt Level");
         ccat.addItem("ECE Deptt Level");
         ccat.addItem("ME Deptt Level");
         ccat.addItem("MUN Club");
         ccat.addItem("SAP");
         rf=new JRadioButton("Full Day");
         rh=new JRadioButton("Half Day");
         bg=new ButtonGroup();
         bg.add(rf);
         bg.add(rh);
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
        
         lcat.setBounds(300,150,90,50);
         leve.setBounds(300,220,200,50);
         lfdate.setBounds(300,280,100,50);
         ltdate.setBounds(300,340,200,50);
         lts.setBounds(300,400,150,50);
         ccat.setBounds(500,150,250,50);
         teve.setBounds(500,220,150,30);
         cfd.setBounds(500,280,70,50);
         ctd.setBounds(500,340,70,50);
         cfm.setBounds(570,280,100,50);
         ctm.setBounds(570,340,100,50);
         cfy.setBounds(680,280,80,50);
         cty.setBounds(680,340,80,50);
         rf.setBounds(500,405,100,30);
         rh.setBounds(620,405,100,30);
         bh.setBounds(5,600,90,40);
         bb.setBounds(5,15,70,40);
         bsbm.setBounds(470,480,130,50);
         
         //Adding Controls to the Frame
         
         add(lcat);
         add(leve);
         add(lfdate);
         add(ltdate);
         add(lts);
         add(ccat);
         add(teve);
         add(cfd);
         add(cfm);
         add(cfy);
         add(ctd);
         add(ctm);
         add(cty);
         add(rf);
         add(rh);
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
        String s="";
                String fd,fm,fy,td,tm,ty,fdt,tdt,ts="";
             fd=String.valueOf(cfd.getSelectedItem());
             fm=String.valueOf(cfm.getSelectedItem());
             fy=String.valueOf(cfy.getSelectedItem());
             td=String.valueOf(ctd.getSelectedItem());
             tm=String.valueOf(ctm.getSelectedItem());
             ty=String.valueOf(cty.getSelectedItem());
             fdt=fd+"-"+fm+"-"+fy;
             tdt=td+"-"+tm+"-"+ty;
             if(rf.isSelected())
             {
                 ts="Full Day";
             }
             if(rh.isSelected())
             {
                 ts="Half Day";
             }
             
        //Back Button
        if(e.getSource()==bb)
        {
            this.dispose();
            dashstud d=new dashstud(snm,sid);
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
                  String s3=ccat.getSelectedItem().toString();
                  
                  //Insertion
                  
                  try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ChalkPad","root","mysql");
        PreparedStatement ps=con.prepareStatement("insert into dl values ('"+s3+"','"+teve.getText()+"','"+fdt+"','"+tdt+"','"+ts+"','"+sid+"')");
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this,"DL Applied Successfully");
        teve.setText("");
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
