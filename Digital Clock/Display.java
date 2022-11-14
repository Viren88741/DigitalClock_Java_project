

import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author  virendra
 */
public class Display extends JFrame implements ActionListener{

    private InputStream is;
    private String currentTime;
    private Font font;
    public Display() {
          super("Digital Clock");
          ClassLoader cl =ClassLoader.getSystemClassLoader();
           is = cl.getResourceAsStream("Font/Roboto-Medium.ttf");
        try {


              font = Font.createFont(java.awt.Font.TRUETYPE_FONT, is);


        }catch(Exception e){}



          font=font.deriveFont(Font.BOLD,33f);
            currentTime = Calendar.getInstance().getTime().toString();
            initComponents();
            javax.swing.Timer t = new javax.swing.Timer(1, this);
            t.start();
            setVisible(true);


    }

    private void initComponents() {

        jPanel1 = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                Graphics2D g2d =(Graphics2D)g;
                g2d.setFont(font);

                GradientPaint p = new GradientPaint(60,64,Color.BLACK,350,32,Color.BLUE);
                g2d.setPaint(p);
                g2d.drawString(currentTime,50,30);


            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new Color(0, 171, 179));


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(20, 589, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

   public void actionPerformed(ActionEvent e){
        currentTime = Calendar.getInstance().getTime().toString();
        jPanel1.repaint();
   }


    private JPanel jPanel1;


}
