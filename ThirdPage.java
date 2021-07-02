/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpackersguide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

class ThirdPage extends JFrame implements ActionListener{

    JFrame f;
    JLabel wallpaper,header,activity,label1,img1,img2,img3,img4;
    JButton backbtn,maxbtn;
    JPanel ThirdPanel,ImagePanel,tablepanel;
    JTable table;
    DefaultTableModel model;
    JTextArea aboutcity;
    JScrollPane scrollpane;
    JSpinner spinner;
    int max=50000;

    ThirdPage() {
        f = new JFrame("Backpacker's Guide");
        f.setLayout(new BorderLayout());
        
        ThirdPanel=new JPanel();
        ThirdPanel.setLayout(null);
        add(ThirdPanel);

        header = new JLabel(HomePage.city, JLabel.CENTER);
        header.setFont(new Font("Serif", Font.PLAIN, 35));
        header.setBounds(0,0,800,80);
        header.setOpaque(true);
        header.setBackground(new Color(66,28,82));
        header.setForeground(Color.WHITE); 
        
        
        ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(1,4,10,10));
        ImagePanel.setBounds(10,80,765,140);

        setimages(HomePage.city);
        
        ImagePanel.add(img1);
        ImagePanel.add(img2);
        ImagePanel.add(img3);
        ImagePanel.add(img4);
      
        
        activity=new JLabel(SecondPage.requiredinfo);
        activity.setBounds(310,220,250,40);
        activity.setForeground(new Color(66,28,82));
        activity.setFont(new Font("Serif", Font.PLAIN, 30));
        
        aboutcity = new JTextArea();
        aboutcity.setFont(new Font("Serif", Font.PLAIN, 14));
        aboutcity.setBounds(10,240,230,310); 
        aboutcity.setOpaque(true);
        aboutcity.setBackground(new Color(66,28,82));
        aboutcity.setForeground(Color.WHITE); 
        aboutcity.setEditable(false);
        
        SpinnerModel value =  new SpinnerNumberModel(5000,1000,10000,1000); 
        spinner=new JSpinner(value);
        spinner.setBounds(590,230,70,30);

       
        ChangeListener listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                String str=( ""+((JSpinner) e.getSource()).getValue());
                max=Integer.parseInt(str);
            }
        };
        spinner.addChangeListener(listener);
         
        maxbtn=new JButton("Go!");
        maxbtn.setBounds(690,230,80,30);
        maxbtn.setBackground(new Color(66,28,82));
        maxbtn.setForeground(Color.WHITE);
        maxbtn.addActionListener(this);
       
        table=new JTable();
        table.setRowHeight(120);
        table.getTableHeader().setBackground(new Color(66,28,82));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setBackground(new Color(220,208,255));
        table.setFont(new Font("Serif", Font.PLAIN, 14));
        
        tablepanel=new JPanel();
        tablepanel.setBounds(260,260,510,290);   
        tablepanel.add(table);
        
        scrollpane=new JScrollPane(table);
        scrollpane.setVisible(true);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        table.setPreferredScrollableViewportSize(new Dimension(490,260));  
        tablepanel.add(scrollpane);
        
        
        backbtn=new JButton("BACK");
        backbtn.setBounds(15,515,80,30);
        backbtn.setBackground(Color.WHITE);
        backbtn.setForeground(new Color(66,28,82));
        backbtn.addActionListener(this);


        getvaluesfromdb();
        
        ThirdPanel.add(header);
        ThirdPanel.add(ImagePanel);
        ThirdPanel.add(activity);
        ThirdPanel.add(spinner);
        ThirdPanel.add(maxbtn);
        ThirdPanel.add(backbtn);
        ThirdPanel.add(aboutcity);
        ThirdPanel.add(tablepanel);
        
        setTitle("Backpacker's Guide");
        pack();
        setVisible(true);
        setResizable(false);
        setBounds(250, 50, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setimages(String s) {

        String imgURL1 = "", imgURL2 = "", imgURL3 = "", imgURL4 = "";
        if (s.equals("Chandigarh")) {
            imgURL1 = ".\\Images\\Sukhna.jpg";
            imgURL2 = ".\\Images\\Rock.jpg";
            imgURL3 = ".\\Images\\Chhatbir.jpg";
            imgURL4 = ".\\Images\\Nepli.jpg";
        } else if (s.equals("Shimla")) {
            imgURL1 = ".\\Images\\church.jpg";
            imgURL2 = ".\\Images\\jakhoo.jpg";
            imgURL3 = ".\\Images\\museum.jpg";
            imgURL4 = ".\\Images\\summer.jpg";
        } else if (s.equals("Kasauli")) {
            imgURL1 = ".\\Images\\christ.jpg";
            imgURL2 = ".\\Images\\gilbert.jpg";
            imgURL3 = ".\\Images\\mall.jpg";
            imgURL4 = ".\\Images\\sunset.jpg";
        } else if (s.equals("Chail")) {
            imgURL1 = ".\\Images\\sanctuary.jpg";
            imgURL2 = ".\\Images\\nature.jpg";
            imgURL3 = ".\\Images\\lake.jpg";
            imgURL4 = ".\\Images\\kali.jpg";
        } else {
            imgURL1 = ".\\Images\\kempty.jpg";
            imgURL2 = ".\\Images\\msrlake.jpg";
            imgURL3 = ".\\Images\\garden.jpg";
            imgURL4 = ".\\Images\\lal.jpg";
        }

        img1 = new JLabel(new ImageIcon(new ImageIcon(imgURL1).getImage().getScaledInstance(180, 120, Image.SCALE_SMOOTH)));
        img2 = new JLabel(new ImageIcon(new ImageIcon(imgURL2).getImage().getScaledInstance(180, 120, Image.SCALE_SMOOTH)));
        img3 = new JLabel(new ImageIcon(new ImageIcon(imgURL3).getImage().getScaledInstance(180, 120, Image.SCALE_SMOOTH)));
        img4 = new JLabel(new ImageIcon(new ImageIcon(imgURL4).getImage().getScaledInstance(180, 120, Image.SCALE_SMOOTH)));
    }

    public void actionPerformed(ActionEvent e){
        try{
           if(e.getSource()==backbtn)
           {
               new SecondPage();
               this.setVisible(false);
           }
           else if(e.getSource()==maxbtn)
           {
               getvaluesfromdb();
           }
        }
        catch(Exception exp)
        {
            System.out.println("Some error occured."+exp);
        }
    }

    public void getvaluesfromdb() {
        try {
            String databaseURL = "jdbc:derby:I:/database/BGdb";
            try {
                Connection connection = DriverManager.getConnection(databaseURL);
                String sql = "select about from information where about is not null and city= '" + HomePage.city + "'";
                Statement st = connection.createStatement();
                ResultSet result = st.executeQuery(sql);

                while (result.next()) {
                    String about = result.getString("about");
                    aboutcity.setText(about);
                }

                if (SecondPage.requiredinfo == "How to Reach") {
                    spinner.setVisible(false);
                    maxbtn.setVisible(false);
                    model = new DefaultTableModel(new String[]{"Modes"}, 0);
                    table.setModel(model);
                    table.setRowHeight(140);

                    String sql2 = "select howtoreach from information where howtoreach is not null and city= '" + HomePage.city + "'";
                    Statement st2 = connection.createStatement();
                    ResultSet result2 = st2.executeQuery(sql2);

                    while (result2.next()) {
                        String howtoreach = result2.getString("howtoreach");
                        model.addRow(new Object[]{howtoreach});
                    }
                } else if (SecondPage.requiredinfo == "Accomodations") {
                    model = new DefaultTableModel(new String[]{"Accomodations", "Price(INR)"}, 0);
                    table.setModel(model);
                    table.getColumnModel().getColumn(0).setPreferredWidth(380);
                    table.getColumnModel().getColumn(1).setPreferredWidth(80);
                    String sql2 = "select accomodations,hotelprice from information where hotelprice<="+max+"and city= '" + HomePage.city + "'";
                    Statement st2 = connection.createStatement();
                    ResultSet result2 = st2.executeQuery(sql2);

                    while (result2.next()) {
                        String accomodations = result2.getString("accomodations");
                        int hotelprice = result2.getInt("hotelprice");
                        model.addRow(new Object[]{accomodations, hotelprice});
                    }
                } else if (SecondPage.requiredinfo == "Restaurants") {
                    model = new DefaultTableModel(new String[]{"Restaurants", "Avg.price(INR)"}, 0);
                    table.setModel(model);
                    table.getColumnModel().getColumn(0).setPreferredWidth(380);
                    table.getColumnModel().getColumn(1).setPreferredWidth(80);

                    String sql2 = "select restaurants,restaurantprice from information where restaurantprice<="+max+"and city= '" + HomePage.city + "'";
                    Statement st2 = connection.createStatement();
                    ResultSet result2 = st2.executeQuery(sql2);

                    while (result2.next()) {
                        String restaurants = result2.getString("restaurants");
                        int restaurantprice = result2.getInt("restaurantprice");
                        model.addRow(new Object[]{restaurants, restaurantprice});
                    }
                } else {
                    spinner.setVisible(false);
                    maxbtn.setVisible(false);
                    model = new DefaultTableModel(new String[]{"Tourist Places"}, 0);
                    table.setModel(model);
                    table.setRowHeight(150);

                    String sql2 = "select touristplaces from information where city= '" + HomePage.city + "'";
                    Statement st2 = connection.createStatement();
                    ResultSet result2 = st2.executeQuery(sql2);

                    while (result2.next()) {
                        String touristplaces = result2.getString("touristplaces");
                        model.addRow(new Object[]{touristplaces});

                    }
                }
                connection.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception exp) {
            System.out.println("Some error occurred." + exp);
        }
    }
}
