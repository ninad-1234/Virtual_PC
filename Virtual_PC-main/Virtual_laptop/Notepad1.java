package Virtual_laptop;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Notepad1 implements ActionListener{
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrap = false;
    
    JMenuBar menuBar;
    
    JMenu menuFile,menuEdit,menuFormat,menuColor;

    JMenuItem INew, IOpen, ISave, ISaveAs, IExit;

    JMenuItem IWordWrap,IFontArial,IFontCSMS,IFontTNR,IFontSize8,IFontSize12,IFontSize16,IFontSize20,IFontSize24,IFontSize28;
    JMenuItem algerian, arialRoundedMT ,cooper ,calibri ,forte ,segoePrint ,showcardGothic ;
    JMenu menuFont,menuFontSize;
    //Edit Menu
    JMenuItem IUndo,IRedo;
    //Color Menu
    JMenuItem BgColor1,BgColor2,BgColor3,BgColor4,BgColor5,BgColor6,BgColor7,BgColor8,BgColor9,BgColor10,BgColor11,BgColor12,BgColor13;
    JMenuItem FgColor1,FgColor2,FgColor3,FgColor4,FgColor5,FgColor6,FgColor7,FgColor8,FgColor9,FgColor10,FgColor11,FgColor12,FgColor13;
    JMenu BgColor, FgColor;
    JMenu Style;
    JMenuItem Plain,Bold,Italic;
    JMenu help;
    
    Function_File file;
    Function_Format format;
    Function_Color color;
    Function_Edit edit;
    UndoManager um = new UndoManager();
    
    public static void main(String[] args) {
        Notepad1 n = new Notepad1();
    }
    public Notepad1(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        creatEditMenu();
        createFormatMenu();
        createColorMenu();

        file = new Function_File(this); // this refers to the object of Notepad1 n
        format = new Function_Format(this);
        color = new Function_Color(this);
        edit = new Function_Edit(this);
        
        //default settings
        format.style = "Plain";
        format.size = 16;
        format.selectedFont = "Arial";
        format.createFont(16,format.style);
        format.wordWrap();
        color.changeBgColor("BWhite");
        color.changeFgColor("FBlack");
        
        window.setVisible(true);
    }
    public void createWindow()
    {
        window = new JFrame("Notepad");
        window.setSize(800,600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//gives screen size
        
        int w = window.getSize().width;
        int h = window.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        System.out.println(w+" "+h+" "+x+" "+y+" "+dim.width+" "+dim.height);
        window.setLocation(x, y);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea()
    {
        textArea = new JTextArea();
        
        textArea.getDocument().addUndoableEditListener(
        new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
        
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    public void createMenuBar()
    {
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
        
        help = new JMenu("Help");
        menuBar.add(help);
    }
    public void createFileMenu()
    {
        INew = new JMenuItem("New");
        INew.addActionListener(this); // this refers to the obj of Notepad1 n
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

    public void createFormatMenu()
    {
        IWordWrap = new JMenuItem("Word Wrap: OFF");
        IWordWrap.addActionListener(this);
        IWordWrap.setActionCommand("Word Wrap");
        menuFormat.add(IWordWrap);
        
        Style = new JMenu("Font Style");
        menuFormat.add(Style);
        
        Plain = new JMenuItem("Plain");
        Plain.addActionListener(this);
        Plain.setActionCommand("Plain");
        Style.add(Plain);
        
        Bold = new JMenuItem("Bold");
        Bold.addActionListener(this);
        Bold.setActionCommand("Bold");
        Style.add(Bold);
        
        Italic = new JMenuItem("Italic");
        Italic.addActionListener(this);
        Italic.setActionCommand("Italic");
        Style.add(Italic);
        
        menuFont = new JMenu("Font Family");
        menuFormat.add(menuFont);
        
        IFontArial = new JMenuItem("Arial");
        IFontArial.addActionListener(this);
        IFontArial.setActionCommand("Arial");
        menuFont.add(IFontArial);
        
        IFontCSMS = new JMenuItem("Comic Sans MS");
        IFontCSMS.addActionListener(this);
        IFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(IFontCSMS);
        
        algerian = new JMenuItem("Algerian");
        algerian.addActionListener(this);
        algerian.setActionCommand("Algerian");
        menuFont.add(algerian);
        
        arialRoundedMT = new JMenuItem("Arial Rounded MT");
        arialRoundedMT.addActionListener(this);
        arialRoundedMT.setActionCommand("Arial Rounded MT");
        menuFont.add(arialRoundedMT);
        
        IFontTNR = new JMenuItem("Times New Roman");
        IFontTNR.addActionListener(this);
        IFontTNR.setActionCommand("Times New Roman");
        menuFont.add(IFontTNR);
        
        cooper = new JMenuItem("Cooper");
        cooper.addActionListener(this);
        cooper.setActionCommand("Cooper");
        menuFont.add(cooper);
        
        calibri = new JMenuItem("Calibri");
        calibri.addActionListener(this);
        calibri.setActionCommand("Calibri");
        menuFont.add(calibri);
        
        forte = new JMenuItem("Forte");
        forte.addActionListener(this);
        forte.setActionCommand("Forte");
        menuFont.add(forte);
        
        segoePrint = new JMenuItem("Segoe Print");
        segoePrint.addActionListener(this);
        segoePrint.setActionCommand("Segoe Print");
        menuFont.add(segoePrint);
        
        showcardGothic = new JMenuItem("Showcard Gothic");
        showcardGothic.addActionListener(this);
        showcardGothic.setActionCommand("Showcard Gothic");
        menuFont.add(showcardGothic);
        
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
        IFontSize16.setActionCommand("size16");
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
    
    public void creatEditMenu()
    {
        IUndo = new JMenuItem("Undo");
        IUndo.addActionListener(this);
        IUndo.setActionCommand("Undo");
        menuEdit.add(IUndo);
        
        IRedo = new JMenuItem("Redo");
        IRedo.addActionListener(this);
        IRedo.setActionCommand("Redo");
        menuEdit.add(IRedo);
    }
    
    public void createColorMenu()
    {
        BgColor = new JMenu("Background Color");
        menuColor.add(BgColor);
        
        FgColor = new JMenu("Foreground Color");
        menuColor.add(FgColor);
        
        BgColor1 = new JMenuItem("White");
        BgColor1.addActionListener(this);
        BgColor1.setActionCommand("BWhite");
        BgColor.add(BgColor1);
        
        BgColor2 = new JMenuItem("Light Gray");
        BgColor2.addActionListener(this);
        BgColor2.setActionCommand("BLight Gray");
        BgColor.add(BgColor2);
        
        BgColor3 = new JMenuItem("Gray");
        BgColor3.addActionListener(this);
        BgColor3.setActionCommand("BGray");
        BgColor.add(BgColor3);
        
        BgColor4 = new JMenuItem("Dark Gray");
        BgColor4.addActionListener(this);
        BgColor4.setActionCommand("BDark Gray");
        BgColor.add(BgColor4);
        
        BgColor5 = new JMenuItem("Black");
        BgColor5.addActionListener(this);
        BgColor5.setActionCommand("BBlack");
        BgColor.add(BgColor5);
        
        BgColor6 = new JMenuItem("Red");
        BgColor6.addActionListener(this);
        BgColor6.setActionCommand("BRed");
        BgColor.add(BgColor6);
        
        BgColor7 = new JMenuItem("Pink");
        BgColor7.addActionListener(this);
        BgColor7.setActionCommand("BPink");
        BgColor.add(BgColor7);
        
        BgColor8 = new JMenuItem("Orange");
        BgColor8.addActionListener(this);
        BgColor8.setActionCommand("BOrange");
        BgColor.add(BgColor8);
        
        BgColor9 = new JMenuItem("Yellow");
        BgColor9.addActionListener(this);
        BgColor9.setActionCommand("BYellow");
        BgColor.add(BgColor9);
        
        BgColor10 = new JMenuItem("Green");
        BgColor10.addActionListener(this);
        BgColor10.setActionCommand("BGreen");
        BgColor.add(BgColor10);
        
        BgColor11 = new JMenuItem("Magenta");
        BgColor11.addActionListener(this);
        BgColor11.setActionCommand("BMagenta");
        BgColor.add(BgColor11);
        
        BgColor12 = new JMenuItem("Cyan");
        BgColor12.addActionListener(this);
        BgColor12.setActionCommand("BCyan");
        BgColor.add(BgColor12);
        
        BgColor13 = new JMenuItem("Blue");
        BgColor13.addActionListener(this);
        BgColor13.setActionCommand("BBlue");
        BgColor.add(BgColor13);
        
        FgColor1 = new JMenuItem("White");
        FgColor1.addActionListener(this);
        FgColor1.setActionCommand("FWhite");
        FgColor.add(FgColor1);
        
        FgColor2 = new JMenuItem("Light Gray");
        FgColor2.addActionListener(this);
        FgColor2.setActionCommand("FLight Gray");
        FgColor.add(FgColor2);
        
        FgColor3 = new JMenuItem("Gray");
        FgColor3.addActionListener(this);
        FgColor3.setActionCommand("FGray");
        FgColor.add(FgColor3);
        
        FgColor4 = new JMenuItem("Dark Gray");
        FgColor4.addActionListener(this);
        FgColor4.setActionCommand("FDark Gray");
        FgColor.add(FgColor4);
        
        FgColor5 = new JMenuItem("Black");
        FgColor5.addActionListener(this);
        FgColor5.setActionCommand("FBlack");
        FgColor.add(FgColor5);
        
        FgColor6 = new JMenuItem("Red");
        FgColor6.addActionListener(this);
        FgColor6.setActionCommand("FRed");
        FgColor.add(FgColor6);
        
        FgColor7 = new JMenuItem("Pink");
        FgColor7.addActionListener(this);
        FgColor7.setActionCommand("FPink");
        FgColor.add(FgColor7);
        
        FgColor8 = new JMenuItem("Orange");
        FgColor8.addActionListener(this);
        FgColor8.setActionCommand("FOrange");
        FgColor.add(FgColor8);
        
        FgColor9 = new JMenuItem("Yellow");
        FgColor9.addActionListener(this);
        FgColor9.setActionCommand("FYellow");
        FgColor.add(FgColor9);
        
        FgColor10 = new JMenuItem("Green");
        FgColor10.addActionListener(this);
        FgColor10.setActionCommand("FGreen");
        FgColor.add(FgColor10);
        
        FgColor11 = new JMenuItem("Magenta");
        FgColor11.addActionListener(this);
        FgColor11.setActionCommand("FMagenta");
        FgColor.add(FgColor11);
        
        FgColor12 = new JMenuItem("Cyan");
        FgColor12.addActionListener(this);
        FgColor12.setActionCommand("FCyan");
        FgColor.add(FgColor12);
        
        FgColor13 = new JMenuItem("Blue");
        FgColor13.addActionListener(this);
        FgColor13.setActionCommand("FBlue");
        FgColor.add(FgColor13);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command)
        {
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
            case "Plain":
                format.createFont(format.size,"Plain");
                break;
            case "Bold":
                format.createFont(format.size,"Bold");
                break;
            case "Italic":
                format.createFont(format.size,"Italic");
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
            case "Algerian":
                format.setFont("Algerian");
                break;
            case "Arial Rounded MT":
                format.setFont("Arial Rounded MT");
                break;
            case "Showcard Gothic":
                format.setFont("Showcard Gothic");
                break;
            case "Calibri":
                format.setFont("Calibri");
                break;
            case "Cooper":
                format.setFont("Cooper");
                break;
            case "Forte":
                format.setFont("Forte");
                break;
            case "Segoe Print":
                format.setFont("Segoe Print");
                break;
            case "size8":
                format.createFont(8,format.style);
                break;
            case "size12":
                format.createFont(12,format.style);
                break;
            case "size16":
                format.createFont(16,format.style);
                break;
            case "size20":
                format.createFont(20,format.style);
                break;
            case "size24":
                format.createFont(24,format.style);
                break;
            case "size28":
                format.createFont(28,format.style);
                break;
            case "BWhite":
                color.changeBgColor("BWhite");
                break;
            case "BLight Gray":
                color.changeBgColor("BLight Gray");
                break;
            case "BDark Gray":
                color.changeBgColor("BDark Gray");
                break;
            case "BGray":
                color.changeBgColor("BGray");
                break;
            case "BRed":
                color.changeBgColor("BRed");
                break;
            case "BBlack":
                color.changeBgColor("BBlack");
                break;
            case "BBlue":
                color.changeBgColor("BBlue");
                break;
            case "BCyan":
                color.changeBgColor("BCyan");
                break;
            case "BMagenta":
                color.changeBgColor("BMagenta");
                break;
            case "BPink":
                color.changeBgColor("BPink");
                break;
            case "BOrange":
                color.changeBgColor("BOrange");
                break;
            case "BYellow":
                color.changeBgColor("BYellow");
                break;
            case "BGreen":
                color.changeBgColor("BGreen");
                break;
            case "FWhite":
                color.changeFgColor("FWhite");
                break;
            case "FLight Gray":
                color.changeFgColor("FLight Gray");
                break;
            case "FDark Gray":
                color.changeFgColor("FDark Gray");
                break;
            case "FGray":
                color.changeFgColor("FGray");
                break;
            case "FRed":
                color.changeFgColor("FRed");
                break;
            case "FBlack":
                color.changeFgColor("FBlack");
                break;
            case "FBlue":
                color.changeFgColor("FBlue");
                break;
            case "FCyan":
                color.changeFgColor("FCyan");
                break;
            case "FMagenta":
                color.changeFgColor("FMagenta");
                break;
            case "FPink":
                color.changeFgColor("FPink");
                break;
            case "FOrange":
                color.changeFgColor("FOrange");
                break;
            case "FYellow":
                color.changeFgColor("FYellow");
                break;
            case "FGreen":
                color.changeFgColor("FGreen");
                break;
        }
    }
}
