/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author architgarg
 */
public class Calci extends Applet implements ActionListener {
        TextField t;
        String s="";
        String str="Calculator";
        Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bc,ba,bs,bm,bd,be,b0;
        char ch=' ';
        int prev,next;
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
        setLayout(null);
        t=new TextField(20);
        t.setBounds(500,150,300,50);
        b1=new Button("1");
        b1.setBounds(500,200,75,50);
        b2=new Button("2");
        b2.setBounds(575,200,75,50);
        b3=new Button("3");
        b3.setBounds(650,200,75,50);
        b4=new Button("4");
        b4.setBounds(500,250,75,50);
        b5=new Button("5");
        b5.setBounds(575,250,75,50);
        b6=new Button("6");
        b6.setBounds(650,250,75,50);
        b7=new Button("7");
        b7.setBounds(500,300,75,50);
        b8=new Button("8");
        b8.setBounds(575,300,75,50);
        b9=new Button("9");
        b9.setBounds(650,300,75,50);
        bc=new Button("C");
        bc.setBounds(500,350,75,50);
        b0=new Button("0");
        b0.setBounds(575,350,75,50);
        be=new Button("=");
        be.setBounds(650,350,75,50);
        ba=new Button("+");
        bs=new Button("-");
        bm=new Button("*");
        bd=new Button("/");
        ba.setBounds(725,200,75,50);
        bs.setBounds(725,250,75,50);
        bm.setBounds(725,300,75,50);
        bd.setBounds(725,350,75,50);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(bc);
        add(b0);
        add(be);
        add(ba);
        add(bs);
        add(bm);
        add(bd);
        add(t);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bc.addActionListener(this);
        ba.addActionListener(this);
        bs.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        be.addActionListener(this);
        
       //^ b1.addActionListener(this);
    }
    public void paint(Graphics g)
    {
        Font f1=new Font("Arial",Font.BOLD,18);
        g.setFont(f1);
        g.drawString("CALCULATOR",590,75);
    }
    // TODO overwrite start(), stop() and destroy() methods
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s=t.getText();
        if(e.getSource()==b1)
        {
            t.setText(s+"1");
        }
        if(e.getSource()==b2)
        {
            t.setText(s+"2");
        }
        if(e.getSource()==b3)
        {
            t.setText(s+"3");
        }
        if(e.getSource()==b4)
        {
            t.setText(s+"4");
        }
        if(e.getSource()==b5)
        {
            t.setText(s+"5");
        }
        if(e.getSource()==b6)
        {
            t.setText(s+"6");
        }
        if(e.getSource()==b7)
        {
            t.setText(s+"7");
        }
        if(e.getSource()==b8)
        {
            t.setText(s+"8");
        }
        if(e.getSource()==b9)
        {
            t.setText(s+"9");
        }
        if(e.getSource()==b0)
        {
            t.setText(s+"0");
        }
        if(e.getSource()==bc)
        {     
            if(!t.getText().equals(""))
            {
            int rem;
            rem=Integer.parseInt(t.getText());
            rem=rem/10;
            if(rem==0)
                t.setText("");
            else
            t.setText(String.valueOf(rem));
            }
            
        }
        if(e.getSource()==ba)
        {
            ch='+';
            prev=Integer.parseInt(t.getText());
            t.setText("");
        }
        if(e.getSource()==bs)
        {
            ch='-';
            prev=Integer.parseInt(t.getText());
            t.setText("");
        }
        if(e.getSource()==bm)
        {
            ch='*';
            prev=Integer.parseInt(t.getText());
            t.setText("");
        }
        if(e.getSource()==bd)
        {
            ch='/';
            prev=Integer.parseInt(t.getText());
            t.setText("");
        }
        if(e.getSource()==be)
        {
            next=Integer.parseInt(t.getText());
            int c;
            if(ch=='+')
            {
                c=prev+next;
            }
            else if(ch=='-')
            {
                c=prev-next;
            }
            else if(ch=='*')
            {
                c=prev*next;
            }
            else if(ch=='/')
            {
                c=prev/next;
            }
            else
            {
                c=0;
            }
            t.setText(String.valueOf(c));
        }
        
        /*else
        {
            System.out.println("This Button Action is Under Control! "
                    + " Be Patient");
        }*/
    }
}
