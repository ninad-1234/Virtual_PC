/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Virtual_laptop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author sahil
 */
public class NotePad extends javax.swing.JFrame implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrap = false;

    JMenuBar menuBar;

    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // File menu
    JMenuItem INew, IOpen, ISave, ISaveAs, IExit;
    //Format menu
    JMenuItem IWordWrap, IFontArial, IFontCSMS, IFontTNR, IFontSize8, IFontSize12, IFontSize16, IFontSize20, IFontSize24, IFontSize28;
    JMenu menuFont, menuFontSize;
    //Edit Menu
    JMenuItem IUndo, IRedo;
    //Color Menu
    JMenuItem IColor1, IColor2, IColor3;

    Connection con = null;

    Function_File file;
    Function_Format format;
    Function_Color color;
    Function_Edit edit;
    UndoManager um;
    
    public NotePad() {
        initComponents();
        createWindow();
//        file = new Function_File(this,window);
//        format = new Function_Format(this);
//        color = new Function_Color(this);
//        edit = new Function_Edit(this);
        um = new UndoManager();
        //window = this;
        
        createTextArea();
        createMenuBar();
        createFileMenu();
        creatEditMenu();
        createFormatMenu();
        createColorMenu();
        format.selectedFont = "Arial";
        format.createFont(16,"Plain");
        format.wordWrap();
        //color.changeColor("White");
        window.setVisible(true);
        initComponents();
        //jCalendar1.setAlignmentY(140);
        con = DB.dbconnect();

    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //JOptionPane.showMessageDialog(this, JFrame.DISPOSE_ON_CLOSE);
        
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
//        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(textArea);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {
        INew = new JMenuItem("New");
        INew.addActionListener(this);
        INew.setActionCommand("New");
        menuFile.add(INew);

        IOpen = new JMenuItem("Open");
        IOpen.addActionListener(this);
        IOpen.setActionCommand("Open");
        menuFile.add(IOpen);

        ISave = new JMenuItem("Save");
        ISave.addActionListener(this);
        ISave.setActionCommand("Save");
        menuFile.add(ISave);

        ISaveAs = new JMenuItem("SaveAs");
        ISaveAs.addActionListener(this);
        ISaveAs.setActionCommand("SaveAs");
        menuFile.add(ISaveAs);

        IExit = new JMenuItem("Exit");
        IExit.addActionListener(this);
        IExit.setActionCommand("Exit");
        menuFile.add(IExit);
    }

    public void createFormatMenu() {
        IWordWrap = new JMenuItem("Word Wrap: OFF");
        IWordWrap.addActionListener(this);
        IWordWrap.setActionCommand("Word Wrap");
        menuFormat.add(IWordWrap);

        menuFont = new JMenu("Font Style");
        menuFormat.add(menuFont);

        IFontArial = new JMenuItem("Arial");
        IFontArial.addActionListener(this);
        IFontArial.setActionCommand("Arial");
        menuFont.add(IFontArial);

        IFontCSMS = new JMenuItem("Comic Sans MS");
        IFontCSMS.addActionListener(this);
        IFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(IFontCSMS);

        IFontTNR = new JMenuItem("Times New Roman");
        IFontTNR.addActionListener(this);
        IFontTNR.setActionCommand("Times New Roman");
        menuFont.add(IFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        IFontSize8 = new JMenuItem("8");
        IFontSize8.addActionListener(this);
        IFontSize8.setActionCommand("size8");
        menuFontSize.add(IFontSize8);

        IFontSize12 = new JMenuItem("12");
        IFontSize12.addActionListener(this);
        IFontSize12.setActionCommand("size12");
        menuFontSize.add(IFontSize12);

        IFontSize16 = new JMenuItem("16");
        IFontSize16.addActionListener(this);
        IFontSize16.setActionCommand("size18");
        menuFontSize.add(IFontSize16);

        IFontSize20 = new JMenuItem("20");
        IFontSize20.addActionListener(this);
        IFontSize20.setActionCommand("size20");
        menuFontSize.add(IFontSize20);

        IFontSize24 = new JMenuItem("24");
        IFontSize24.addActionListener(this);
        IFontSize24.setActionCommand("size24");
        menuFontSize.add(IFontSize24);

        IFontSize28 = new JMenuItem("28");
        IFontSize28.addActionListener(this);
        IFontSize28.setActionCommand("size28");
        menuFontSize.add(IFontSize28);
    }

    public void creatEditMenu() {
        IUndo = new JMenuItem("Undo");
        IUndo.addActionListener(this);
        IUndo.setActionCommand("Undo");
        menuEdit.add(IUndo);

        IRedo = new JMenuItem("Redo");
        IRedo.addActionListener(this);
        IRedo.setActionCommand("Redo");
        menuEdit.add(IRedo);
    }

    public void createColorMenu() {
        IColor1 = new JMenuItem("White");
        IColor1.addActionListener(this);
        IColor1.setActionCommand("White");
        menuColor.add(IColor1);

        IColor2 = new JMenuItem("Black");
        IColor2.addActionListener(this);
        IColor2.setActionCommand("Black");
        menuColor.add(IColor2);

        IColor3 = new JMenuItem("Blue");
        IColor3.addActionListener(this);
        IColor3.setActionCommand("Blue");
        menuColor.add(IColor3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.openFile();
                break;
            case "Save":
                file.save();
                break;
            case "SaveAs":
                file.saveAs();
                break;
            case "Exit":
                file.exit();
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont("Arial");
                break;
            case "Comic Sans MS":
                format.setFont("Comic Sans MS");
                break;
            case "Times New Roman":
                format.setFont("Times New Roman");
                break;
//            case "size8":
//                format.createFont(8);
//                break;
//            case "size12":
//                format.createFont(12);
//                break;
//            case "size16":
//                format.createFont(16);
//                break;
//            case "size20":
//                format.createFont(20);
//                break;
//            case "size24":
//                format.createFont(24);
//                break;
//            case "size28":
//                format.createFont(28);
//                break;
//            case "White":
//                color.changeColor("White");
//                break;
//            case "Black":
//                color.changeColor("Black");
//                break;
//            case "Blue":
//                color.changeColor("Blue");
//                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotePad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
