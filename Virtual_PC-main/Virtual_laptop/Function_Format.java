package Virtual_laptop;

import java.awt.Font;

public class Function_Format {

    Notepad1 note;
    String selectedFont;
    String style;
    int size;
    
    Font arial;
    Font arialRoundedMT;
    Font algerian;
    Font cooper;
    Font calibri;
    Font forte;
    Font segoePrint;
    Font showcardGothic;
    Font comicSansMS;
    Font timesNewRoman;

    public Function_Format(Notepad1 note) {
        this.note = note;
    }

    public void wordWrap() {
        if (note.wordWrap == false) {
            note.wordWrap = true;
            note.textArea.setLineWrap(true);
            note.textArea.setWrapStyleWord(true);
            note.IWordWrap.setText("Word Wrap: On");
        } else if (note.wordWrap == true) {
            note.wordWrap = false;
            note.textArea.setLineWrap(false);
            note.textArea.setWrapStyleWord(false);
            note.IWordWrap.setText("Word Wrap: Off");
        }
    }

    public void createFont(int fontSize,String fstyle) {
        style = fstyle;
        size = fontSize;
        if(style=="Plain")
        {
            System.out.println(style);
            arial = new Font("Arial", Font.PLAIN, fontSize);
            comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
            algerian = new Font("Algerian", Font.PLAIN, fontSize);
            arialRoundedMT = new Font("Arial Rounded MT", Font.PLAIN, fontSize);
            cooper = new Font("Cooper", Font.PLAIN, fontSize);
            calibri = new Font("Calibri", Font.PLAIN, fontSize);
            forte = new Font("Forte", Font.PLAIN, fontSize);
            segoePrint = new Font("Segoe Print", Font.PLAIN, fontSize);
            showcardGothic = new Font("Showcard Gothic", Font.PLAIN, fontSize);
            timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        }
        else if(style=="Bold")
        {
            System.out.println(style);
            arial = new Font("Arial", Font.BOLD, fontSize);
            comicSansMS = new Font("Comic Sans MS", Font.BOLD, fontSize);
            algerian = new Font("Algerian", Font.BOLD, fontSize);
            arialRoundedMT = new Font("Arial Rounded MT", Font.BOLD, fontSize);
            cooper = new Font("Cooper", Font.BOLD, fontSize);
            calibri = new Font("Calibri", Font.BOLD, fontSize);
            forte = new Font("Forte", Font.BOLD, fontSize);
            segoePrint = new Font("Segoe Print", Font.BOLD, fontSize);
            showcardGothic = new Font("Showcard Gothic", Font.BOLD, fontSize);
            timesNewRoman = new Font("Times New Roman", Font.BOLD, fontSize);
        }
        else if(style=="Italic")
        {
            System.out.println(style);
            arial = new Font("Arial", Font.ITALIC, fontSize);
            comicSansMS = new Font("Comic Sans MS", Font.ITALIC, fontSize);
            algerian = new Font("Algerian", Font.ITALIC, fontSize);
            arialRoundedMT = new Font("Arial Rounded MT", Font.ITALIC, fontSize);
            cooper = new Font("Cooper", Font.ITALIC, fontSize);
            calibri = new Font("Calibri", Font.ITALIC, fontSize);
            forte = new Font("Forte", Font.ITALIC, fontSize);
            segoePrint = new Font("Segoe Print", Font.ITALIC, fontSize);
            showcardGothic = new Font("Showcard Gothic", Font.ITALIC, fontSize);
            timesNewRoman = new Font("Times New Roman", Font.ITALIC, fontSize);
        }
        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial":
                note.textArea.setFont(arial);
                break;
            case "Cooper":
                note.textArea.setFont(cooper);
                break;
            case "Comic Sans MS":
                note.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                note.textArea.setFont(timesNewRoman);
                break;
            case "Segoe Print":
                note.textArea.setFont(segoePrint);
                break;
            case "Forte":
                note.textArea.setFont(forte);
                break;
            case "Showcard Gothic":
                note.textArea.setFont(showcardGothic);
                break;
            case "Algerian":
                note.textArea.setFont(algerian);
                break;
            case "Arial Rounded MT":
                note.textArea.setFont(arialRoundedMT);
                break;
            case "Calibri":
                note.textArea.setFont(calibri);
                break; 
        }
    }

}
