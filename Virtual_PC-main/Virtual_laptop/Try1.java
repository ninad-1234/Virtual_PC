/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Virtual_laptop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author sahil
 */
public class Try1 extends javax.swing.JFrame {

    /**
     * Creates new form Try
     */
    
    
   // System.out.println(formatter.format(date));  
    
    
    Connection con=null;
    String Max_app=null;
    String dyna_img=null;
    private Calculator c[] = new Calculator[10];
    private Task_Manager t[] = new Task_Manager[10];
    private Email e[] = new Email[10];
    private Stopwatch st_wch[] = new Stopwatch[10];
    private Calendar cl[] = new Calendar[10];
    private Alarm Al[] = new Alarm[10];
    
    
    int i=0,ti=0,em=0,cal=0,sw_cnt=0,al_cnt=0;
    
    //Generic variables
    String app,cache;
    int cpu,mem,flag;
    
    public Try1() {
        initComponents();
        /*DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        
        Date date = new Date();
        String time = formatter.format(date);
         jLabel22.setText(time);*/
         
         
         
         
        final DateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                String time = timeFormat.format(date);
                jLabel22.setText(time);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        //timer.setInitialDelay(10000);
        timer.start();
         
         
         
         
         
         
         
         
        jButton2.setVisible(false);
        tm.setVisible(false);
        calc.setVisible(false);
        jButton3.setVisible(false);
        SW.setVisible(false);
        alarm.setVisible(false);
        jButton1.setVisible(false);
        jButton4.setVisible(false);
        
        setLayout(new BorderLayout());
        
        ImageIcon icon = new ImageIcon("C:\\Users\\dell\\Downloads\\os_background.jpg");
        Image image = icon.getImage();
        Image imgScale = image.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
        ImageIcon scaleImage = new ImageIcon(imgScale);
        
	JLabel background=new JLabel(scaleImage);
	add(background);
        
        ImageIcon icon1 = new ImageIcon("C:\\Users\\dell\\Downloads\\alarm.jpg");
        Image image1 = icon1.getImage();
        Image imgScale1 = image1.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleImage1 = new ImageIcon(imgScale1);
        jLabel1.setIcon(scaleImage1);
        
        ImageIcon icon2 = new ImageIcon("C:\\Users\\dell\\Downloads\\email.png");
        Image image2 = icon2.getImage();
        Image imgScale2 = image2.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleImage2 = new ImageIcon(imgScale2);
        jLabel2.setIcon(scaleImage2);
        
        ImageIcon icon3 = new ImageIcon("C:\\Users\\dell\\Downloads\\stopwatch_btn.png");
        Image image3 = icon3.getImage();
        Image imgScale3 = image3.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleImage3 = new ImageIcon(imgScale3);
        jLabel3.setIcon(scaleImage3);
        
        ImageIcon icon4 = new ImageIcon("C:\\Users\\dell\\Downloads\\calci_final.jpg");
        Image image4 = icon4.getImage();
        Image imgScale4 = image4.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleImage4 = new ImageIcon(imgScale4);
        jLabel7.setIcon(scaleImage4);
        
        ImageIcon icon5 = new ImageIcon("C:\\Users\\dell\\Downloads\\calendar.png");
        Image image5 = icon5.getImage();
        Image imgScale5 = image5.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleImage5 = new ImageIcon(imgScale5);
        jLabel9.setIcon(scaleImage5);
        
        ImageIcon icon6 = new ImageIcon("C:\\Users\\dell\\Downloads\\task_manager.jpg");
        Image image6 = icon6.getImage();
        Image imgScale6 = image6.getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleImage6 = new ImageIcon(imgScale6);
        jLabel11.setIcon(scaleImage6);
        
        ImageIcon icon7 = new ImageIcon("C:\\Users\\dell\\Downloads\\power_off.jpg");
        Image image7 = icon7.getImage();
        Image imgScale7 = image7.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleImage7 = new ImageIcon(imgScale7);
        jLabel13.setIcon(scaleImage7);
        
        
        
        
        con = DB.dbconnect();
        
        try{
            int max =0;
            
             PreparedStatement pst = con.prepareStatement("select * from task_manager ");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               int tem_max= rs.getInt("Usage_Count");
               System.out.println(tem_max);
               if(tem_max>max)
               {
                   max= tem_max;
                   Max_app= rs.getString("app_name");
                   dyna_img=rs.getString("image");

               }
            }
            System.out.println(app);
           // System.out.println(dyna_img);
            jButton4.setText(Max_app);
            jLabel14.setText(dyna_img);
            
            ImageIcon icon8 = new ImageIcon(dyna_img);
            Image image8 = icon8.getImage();
            Image imgScale8 = image8.getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaleImage8 = new ImageIcon(imgScale8);
            jLabel14.setIcon(scaleImage8);
            
            
        }
        catch(Exception E)
        {
            System.out.println("okkkkkkkkkk");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calc = new javax.swing.JButton();
        tm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        SW = new javax.swing.JButton();
        alarm = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        calc.setText("Calculator");
        calc.setOpaque(false);
        calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcActionPerformed(evt);
            }
        });

        tm.setText("Task Manager");
        tm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmActionPerformed(evt);
            }
        });

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Calendar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 51, 255));
        jButton3.setText("Email");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        SW.setText("Stopwatch");
        SW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SWActionPerformed(evt);
            }
        });

        alarm.setText("Alarm");
        alarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alarmActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("jButton4");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("jLabel14");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Most used Application");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel1.setText("Alarm");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Mail");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });

        jLabel3.setText("Stop Watch");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mail");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Stop Watch");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Task Manager");

        jLabel7.setText("Calculator");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Calculator");

        jLabel9.setText("calender");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Calender");

        jLabel11.setText("Task Manager");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Alarm");

        jLabel13.setText("jLabel13");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(204, 204, 204))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(tm)
                            .addGap(207, 207, 207)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SW, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alarm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tm, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SW, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(alarm, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcActionPerformed
        // TODO add your handling code here:
        i++;
        c[i] = new Calculator();
        c[i].setVisible(true);
        //System.out.println(i);
        app = "Calculator";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();
    }//GEN-LAST:event_calcActionPerformed

    void generic()
    {
        try
        {
            //JOptionPane.showMessageDialog(null, dur);
            System.out.println(app);
            PreparedStatement pst = con.prepareStatement("select * from task_manager where app_name=?");
            pst.setString(1,app);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                int usage_count= rs.getInt("Usage_Count");
                usage_count++;
                int a1 = rs.getInt("count");
                a1=a1+flag;
                //JOptionPane.showMessageDialog(this, a1);
                int a2 = rs.getInt("CPU_utility");
                a2=a2+cpu;
                //JOptionPane.showMessageDialog(this, a2);
                int a3 = rs.getInt("Mem_utility");
                a3=a3+mem;
                //JOptionPane.showMessageDialog(this, a3);
                PreparedStatement pst1 = con.prepareStatement("update task_manager set Count = ?, CPU_utility = ?, Mem_utility = ? , Usage_Count = ? where app_name = ?");
                pst1.setInt(1, a1);
                pst1.setInt(2, a2);
                pst1.setInt(3, a3);
                pst1.setInt(4, usage_count);
                pst1.setString(5, app);
                pst1.executeUpdate();
            }
            else
            {
                PreparedStatement pst1 = con.prepareStatement("insert into task_manager(app_name,CPU_utility,Mem_utility,Cache_level,count) values(?,?,?,?,?)");
                pst1.setString(1, app);
                pst1.setInt(2, cpu);
                pst1.setInt(3, mem);
                pst1.setString(4, cache);
                pst1.setInt(5, flag);
                pst1.executeUpdate();
                //JOptionPane.showMessageDialog(null, "data added");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }
    private void tmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmActionPerformed
        // TODO add your handling code here:
        ti++;
        t[ti] = new Task_Manager();
        t[ti].setVisible(true);
        app = "Task Manager";
        cpu = 2;
        mem = 15;
        cache = "L2";
        flag = 1;
        generic();
        
    }//GEN-LAST:event_tmActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        jButton4.setText(" ");
        con = DB.dbconnect();
        
        try{
            int max =0;
            
             PreparedStatement pst = con.prepareStatement("select * from task_manager ");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               int tem_max= rs.getInt("Usage_Count");
               System.out.println(tem_max);
               if(tem_max>max)
               {
                   max= tem_max;
                   Max_app= rs.getString("app_name");
                   dyna_img=rs.getString("image");
               }
            }
            System.out.println(app);
            jButton4.setText(Max_app);
            ImageIcon icon8 = new ImageIcon(dyna_img);
            Image image8 = icon8.getImage();
            Image imgScale8 = image8.getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaleImage8 = new ImageIcon(imgScale8);
            jLabel14.setIcon(scaleImage8);
        }
        catch(Exception E)
        {
            System.out.println("okkkkkkkkkk");
        }
        
    }//GEN-LAST:event_formMouseEntered

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       //JOptionPane.showMessageDialog(this, "Delete");
    }//GEN-LAST:event_formWindowClosed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowDeactivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        dispose();
        for(int j=1;j<=i;j++)
        {
            c[j].dispose();            
        }
        for(int j=1;j<=ti;j++)
        {
            t[j].dispose();            
        }
        for(int j=1;j<=cal;j++)
        {
            cl[j].dispose();            
        }
        try
        {
            PreparedStatement pst1 = con.prepareStatement("delete from task_manager where app_name = ?");
            pst1.setString(1, "Notepad");
            pst1.executeUpdate();
        }
        catch(Exception e)
        {
            
        }
        finally{
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cal++;
        cl[cal] = new Calendar();
        cl[cal].setVisible(true);
        
        app = "Calendar";
        cpu = 4;
        mem = 18;
        cache = "L3";
        flag = 1;
        generic();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        //n.setVisible(true);
        em++;
        e[em]= new Email();
        e[em].setVisible(true);
       // n[nt] = new NotePad();
        //n[nt].setVisible(true);
        
        app = "Email";
        cpu = 7;
        mem = 25;
        cache = "L1";
        flag = 1;
        generic();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SWActionPerformed
        // TODO add your handling code here:
        sw_cnt++;
        st_wch[i] = new Stopwatch();
        st_wch[i].setVisible(true);
        //System.out.println(i);
        app = "Stop-Watch";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();
    }//GEN-LAST:event_SWActionPerformed

    private void alarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alarmActionPerformed
        // TODO add your handling code here:
        al_cnt++;
        Al[al_cnt] = new Alarm();
        Al[al_cnt].setVisible(true);
        app= "Alarm";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();

        
    }//GEN-LAST:event_alarmActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(Max_app.equals("Calendar"))
        {
            cal++;
            cl[cal] = new Calendar();
            cl[cal].setVisible(true);
            app = "Calendar";
            cpu = 4;
            mem = 18;
            cache = "L3";
            flag =1;
            generic();
        }
        if(Max_app.equals("Calculator"))
        {
            i++;
            c[i] = new Calculator();
            c[i].setVisible(true);
            //System.out.println(i);
            app = "Calculator";
            cpu = 5;
            mem = 30;
            cache = "L1";
            flag = 1;
            generic();
        }
        if(Max_app.equals("Task Manager"))
        {
            ti++;
            t[ti] = new Task_Manager();
            t[ti].setVisible(true);
            app = "Task Manager";
            cpu = 2;
            mem = 15;
            cache = "L2";
            flag = 1;
            generic();
        }
        if(Max_app.equals("Stop-Watch"))
        {
           sw_cnt++;
        st_wch[i] = new Stopwatch();
        st_wch[i].setVisible(true);
        //System.out.println(i);
        app = "Stop-Watch";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();
        }
        if(Max_app.equals("Alarm"))
        {
            al_cnt++;
            Al[al_cnt] = new Alarm();
            Al[al_cnt].setVisible(true);
            app= "Alarm";
            cpu = 5;
            mem = 30;
            cache = "L1";
            flag = 1;
            generic();
        }
        if(Max_app.equals("Email"))
        {
            em++;
        e[em]= new Email();
        e[em].setVisible(true);
        
        app = "Email";
        cpu = 7;
        mem = 25;
        cache = "L1";
        flag = 1;
        generic();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
         al_cnt++;
        Al[al_cnt] = new Alarm();
        Al[al_cnt].setVisible(true);
        app= "Alarm";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
       
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        em++;
        e[em]= new Email();
        e[em].setVisible(true);
       // n[nt] = new NotePad();
        //n[nt].setVisible(true);
        
        app = "Email";
        cpu = 7;
        mem = 25;
        cache = "L1";
        flag = 1;
        generic();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        sw_cnt++;
        st_wch[i] = new Stopwatch();
        st_wch[i].setVisible(true);
        //System.out.println(i);
        app = "Stop-Watch";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        i++;
        c[i] = new Calculator();
        c[i].setVisible(true);
        //System.out.println(i);
        app = "Calculator";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        cal++;
        cl[cal] = new Calendar();
        cl[cal].setVisible(true);
        
        app = "Calendar";
        cpu = 4;
        mem = 18;
        cache = "L3";
        flag = 1;
        generic();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        ti++;
        t[ti] = new Task_Manager();
        t[ti].setVisible(true);
        app = "Task Manager";
        cpu = 2;
        mem = 15;
        cache = "L2";
        flag = 1;
        generic();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        if(Max_app.equals("Calendar"))
        {
            cal++;
            cl[cal] = new Calendar();
            cl[cal].setVisible(true);
            app = "Calendar";
            cpu = 4;
            mem = 18;
            cache = "L3";
            flag =1;
            generic();
        }
        if(Max_app.equals("Calculator"))
        {
            i++;
            c[i] = new Calculator();
            c[i].setVisible(true);
            //System.out.println(i);
            app = "Calculator";
            cpu = 5;
            mem = 30;
            cache = "L1";
            flag = 1;
            generic();
        }
        if(Max_app.equals("Task Manager"))
        {
            ti++;
            t[ti] = new Task_Manager();
            t[ti].setVisible(true);
            app = "Task Manager";
            cpu = 2;
            mem = 15;
            cache = "L2";
            flag = 1;
            generic();
        }
        if(Max_app.equals("Stop-Watch"))
        {
           sw_cnt++;
        st_wch[i] = new Stopwatch();
        st_wch[i].setVisible(true);
        //System.out.println(i);
        app = "Stop-Watch";
        cpu = 5;
        mem = 30;
        cache = "L1";
        flag = 1;
        generic();
        }
        if(Max_app.equals("Alarm"))
        {
            al_cnt++;
            Al[al_cnt] = new Alarm();
            Al[al_cnt].setVisible(true);
            app= "Alarm";
            cpu = 5;
            mem = 30;
            cache = "L1";
            flag = 1;
            generic();
        }
        if(Max_app.equals("Email"))
        {
            em++;
        e[em]= new Email();
        e[em].setVisible(true);
        
        app = "Email";
        cpu = 7;
        mem = 25;
        cache = "L1";
        flag = 1;
        generic();
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Try.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Try.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Try.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Try.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Try1 t = new Try1();
                t.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SW;
    private javax.swing.JButton alarm;
    private javax.swing.JButton calc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton tm;
    // End of variables declaration//GEN-END:variables
}
