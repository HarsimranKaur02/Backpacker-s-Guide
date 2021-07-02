/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpackersguide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomePage extends JFrame implements ActionListener {

    static String city;
    JFrame f;
    JLabel wallpaper,header, label1,footer;
    public JButton b1, b2, b3, b4, b5, nextbtn;
    JPanel FirstPanel,CityPanel;

    HomePage() {
        f = new JFrame("Backpacker's Guide");
        f.setLayout(new BorderLayout());
        
        FirstPanel=new JPanel();
        FirstPanel.setLayout(null);
        add(FirstPanel);

        header = new JLabel("Backpacker's Guide", JLabel.CENTER);
        header.setFont(new Font("Serif", Font.PLAIN, 35));
        header.setBounds(0,0,800,80);
        header.setOpaque(true);
        header.setBackground(new Color(66,28,82));
        header.setForeground(Color.WHITE);

        wallpaper=new JLabel(new ImageIcon(".\\Images\\homepage.jpg"),JLabel.CENTER);
        wallpaper.setBounds(0,80,800,270);
        
        
        label1 = new JLabel("Hello Backpacker! Please choose your destination: ");
        label1.setFont(new Font("Serif", Font.PLAIN, 22));
        label1.setBounds(20, 360, 800, 40);

        CityPanel = new JPanel();
        CityPanel.setLayout(new GridLayout(1,5,10,10));
        CityPanel.setBounds(10,420,760,100);

        b1 = new JButton(new ImageIcon(".\\Images\\chd1.jpg"));
        b2 = new JButton(new ImageIcon(".\\Images\\shm3.jpg"));
        b3 = new JButton(new ImageIcon(".\\Images\\ksl2.jpg"));
        b4 = new JButton(new ImageIcon(".\\Images\\chl1.jpg"));
        b5 = new JButton(new ImageIcon(".\\Images\\mus1.jpg"));

        
        b1.setText("CHANDIGARH");
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setFont(new Font("Serif", Font.BOLD, 15));
        b1.setForeground(Color.WHITE);
        
        b2.setText("SHIMLA");
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setFont(new Font("Serif", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        
        b3.setText("KASAULI");
        b3.setHorizontalTextPosition(SwingConstants.CENTER);
        b3.setFont(new Font("Serif", Font.BOLD, 16));
        b3.setForeground(Color.WHITE);
        
        b4.setText("CHAIL");
        b4.setHorizontalTextPosition(SwingConstants.CENTER);
        b4.setFont(new Font("Serif", Font.BOLD, 16));
        b4.setForeground(Color.WHITE);
        
        b5.setText("MUSSOORIE");
        b5.setHorizontalTextPosition(SwingConstants.CENTER);
        b5.setFont(new Font("Serif", Font.BOLD, 15));
        b5.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        CityPanel.add(b1);
        CityPanel.add(b2);
        CityPanel.add(b3);
        CityPanel.add(b4);
        CityPanel.add(b5);
        
        footer = new JLabel("");
        footer.setBounds(0,535,800,40);
        footer.setOpaque(true);
        footer.setBackground(new Color(66,28,82));


        FirstPanel.add(header);
        FirstPanel.add(wallpaper);
        FirstPanel.add(label1);
        FirstPanel.add(CityPanel);
        FirstPanel.add(footer);

        setTitle("Backpacker's Guide");
        pack();
        setVisible(true);
        setResizable(false);
        setBounds(250, 50, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                city="Chandigarh";
            } else if (e.getSource() == b2) {
                city="Shimla";
            } else if (e.getSource() == b3) {
                city="Kasauli";
            } else if (e.getSource() == b4) {
                city="Chail";
            } else {
                city="Mussoorie";
            }
            new SecondPage();
            this.dispose();
        } catch (Exception exp) {
            System.out.println("Some error occurred." + exp);
        }
    }


    public static void main(String[] args) {
        new HomePage();
   
    }
}


