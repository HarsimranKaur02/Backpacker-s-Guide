/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpackersguide;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondPage extends JFrame implements ActionListener {
    
    public static String requiredinfo;
    JFrame f;
    JLabel header, label1,label2;
    JButton b1, b2, b3, b4, homebtn,nextbtn;
    JPanel SecondPanel,ImagePanel;

    SecondPage() {
        f = new JFrame("Backpacker's Guide");
        f.setLayout(new BorderLayout());
        
        SecondPanel=new JPanel();
        SecondPanel.setLayout(null);
        add(SecondPanel);

        header = new JLabel("Backpacker's Guide", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.PLAIN, 35));
        header.setBounds(0,0,800,80);
        header.setOpaque(true);
        header.setBackground(new Color(66,28,82));
        header.setForeground(Color.WHITE);
        
        label1=new JLabel(HomePage.city,JLabel.CENTER);
        label1.setBounds(0,90,800,40);
        label1.setForeground(new Color(66,28,82));
        label1.setFont(new Font("Serif", Font.PLAIN, 30));
        
        
        label2 = new JLabel("Good Choice! Please select one of the options for more information:");
        label2.setFont(new Font("Serif", Font.PLAIN, 20));
        label2.setBounds(120, 130, 800, 40);

        ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,2,30,30));
        ImagePanel.setBounds(80,180,600,300);

        b1 = new JButton(new ImageIcon(".\\Images\\ss9.jpg"));
        b2 = new JButton(new ImageIcon(".\\Images\\ss2.jpg"));
        b3 = new JButton(new ImageIcon(".\\Images\\ss3.jpg"));
        b4 = new JButton(new ImageIcon(".\\Images\\ss10.jpg"));
        
        b1.setText("How to Reach");
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setFont(new Font("Serif", Font.BOLD, 30));
        b1.setForeground(Color.WHITE);
        
        b2.setText("Accomodations");
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setFont(new Font("Serif", Font.BOLD, 30));
        b2.setForeground(Color.WHITE);
        b2.setOpaque(false);
        
        b3.setText("<html>Restaurant<br/>Recommendations<html>");
        b3.setHorizontalTextPosition(SwingConstants.CENTER);
        b3.setFont(new Font("Serif", Font.BOLD, 30));
        b3.setForeground(Color.WHITE);
        
        b4.setText("<html>Tourist<br/> Activities<html>");
        b4.setHorizontalTextPosition(SwingConstants.CENTER);
        b4.setFont(new Font("Serif", Font.BOLD, 30));
        b4.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        ImagePanel.add(b1);
        ImagePanel.add(b2);
        ImagePanel.add(b3);
        ImagePanel.add(b4);
         
        homebtn=new JButton("HOME");
        homebtn.setBounds(30,520,80,30);
        homebtn.setBackground(new Color(66,28,82));
        homebtn.setForeground(Color.WHITE);
        homebtn.addActionListener(this);
        


        SecondPanel.add(header);
        SecondPanel.add(label1);
        SecondPanel.add(label2);
        SecondPanel.add(ImagePanel);
        SecondPanel.add(homebtn);

        setTitle("Backpacker's Guide");
        pack();
        setVisible(true);
        setResizable(false);
        setBounds(250, 50, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    
    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getSource() == homebtn) {
                new HomePage().setVisible(true);
                this.dispose();

            } else {

                if (e.getSource() == b1) {
                    requiredinfo = "How to Reach";
                } else if (e.getSource() == b2) {
                    requiredinfo = "Accomodations";
                } else if (e.getSource() == b3) {
                    requiredinfo = "Restaurants";
                } else if (e.getSource() == b4) {
                    requiredinfo = "Places to Visit";
                }
                ThirdPage tp = new ThirdPage();
                this.dispose();
            }

        } catch (Exception exp) {
            System.out.println("Some error occurred." + exp);
        }
    }
  
}

