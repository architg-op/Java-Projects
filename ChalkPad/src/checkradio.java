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
public class checkradio extends JFrame {
    JRadioButton m,f;
    ButtonGroup bg;
    checkradio()
    {
        setTitle("c");
        setLayout(null);
         setSize(1425,600);
         setVisible(true);
         m=new JRadioButton("Male");
         f=new JRadioButton("FeMale");
         bg=new ButtonGroup();
         bg.add(m);
         bg.add(f);
         m.setBounds(500,280,250,50);
         f.setBounds(600,280,250,50);
         add(m);
         add(f);
         
    }
    public static void main(String args[])
    {
        checkradio r=new checkradio();
    }
}
