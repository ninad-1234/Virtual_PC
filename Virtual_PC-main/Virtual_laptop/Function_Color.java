package Virtual_laptop;

import java.awt.Color;

public class Function_Color {
    Notepad1 note;
    
    public Function_Color(Notepad1 note)
    {
        this.note = note;
    }
    
    public void changeBgColor(String color)
    {
        switch(color)
        {
            case "BWhite":
                note.window.setBackground(Color.white);
                note.textArea.setBackground(Color.white);
                break;
            case "BLight Gray":
                note.window.setBackground(Color.lightGray);
                note.textArea.setBackground(Color.lightGray);
                break;
            case "BDark Gray":
                note.window.setBackground(Color.darkGray);
                note.textArea.setBackground(Color.darkGray);
                break;
            case "BGray":
                note.window.setBackground(Color.gray);
                note.textArea.setBackground(Color.gray);
                break;
            case "BRed":
                note.window.setBackground(Color.red);
                note.textArea.setBackground(Color.red);
                break;
            case "BBlack":
                note.window.setBackground(Color.black);
                note.textArea.setBackground(Color.black);
                break;
            case "BBlue":
                note.window.setBackground(Color.blue);
                note.textArea.setBackground(Color.blue);
                break;
            case "BCyan":
                note.window.setBackground(Color.cyan);
                note.textArea.setBackground(Color.cyan);
                break;
            case "BMagenta":
                note.window.setBackground(Color.magenta);
                note.textArea.setBackground(Color.magenta);
                break;
            case "BPink":
                note.window.setBackground(Color.pink);
                note.textArea.setBackground(Color.pink);
                break;
            case "BOrange":
                note.window.setBackground(Color.orange);
                note.textArea.setBackground(Color.orange);
                break;
            case "BYellow":
                note.window.setBackground(Color.yellow);
                note.textArea.setBackground(Color.yellow);
                break;
            case "BGreen":
                note.window.setBackground(Color.green);
                note.textArea.setBackground(Color.green);
                break;
        }
    }
    public void changeFgColor(String color)
    {
        System.out.println(color);
        switch(color)
        {
            case "FWhite":
                note.textArea.setForeground(Color.white);
                break;
            case "FLight Gray":
                note.textArea.setForeground(Color.lightGray);
                break;
            case "FDark Gray":
                note.textArea.setForeground(Color.darkGray);
                break;
            case "FGray":
                note.textArea.setForeground(Color.gray);
                break;
            case "FRed":
                note.textArea.setForeground(Color.red);
                break;
            case "FBlack":
                note.textArea.setForeground(Color.black);
                break;
            case "FBlue":
                note.textArea.setForeground(Color.blue);
                break;
            case "FCyan":
                note.textArea.setForeground(Color.cyan);
                break;
            case "FMagenta":
                note.textArea.setForeground(Color.magenta);
                break;
            case "FPink":
                note.textArea.setForeground(Color.pink);
                break;
            case "FOrange":
                note.textArea.setForeground(Color.orange);
                break;
            case "FYellow":
                note.textArea.setForeground(Color.yellow);
                break;
            case "FGreen":
                note.textArea.setForeground(Color.green);
                break;
        }
    }
}
