package Virtual_laptop;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Function_File {
    Notepad1 note;
    int i=0;
    
    String fileName,fileAddress;
    
    public Function_File(Notepad1 note)
    {
        this.note = note;
    }
    public void newFile()
    {
        i++;
        note.textArea.setText("");
        note.window.setTitle("Untitled "+i);
        fileName = null;
        fileAddress = null;
    }
    public void openFile()
    {
        FileDialog fd = new FileDialog(note.window,"Open",FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile()!=null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            note.window.setTitle(fileName);
            try        
            {
                BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
                note.textArea.setText("");
                String line = null;
                while((line = br.readLine())!=null)
                {
                    note.textArea.append(line+"\n");
                }
                br.close();
            }
            catch(Exception e)
            {
                System.out.println("File not Opened");
            }
        }
    }
    public void save()
    {
        if(fileName==null)
        {
            saveAs();
        }
        else
        {
            try
            {
                FileWriter fw = new FileWriter(fileAddress+fileName);
                fw.write(note.textArea.getText());
                //note.window.setTitle(fileName); 
                fw.close();
            }
            catch(Exception e)
            {
                System.out.println("SOMETHING WRONG");
            }
            
        }
    }
    public void saveAs()
    {
        FileDialog fd = new FileDialog(note.window,"Save",FileDialog.SAVE);
        fd.setVisible(true);
        
        if(fd.getFile()!=null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            note.window.setTitle(fileName);

            try
            {
                FileWriter fw = new FileWriter(fileAddress+fileName);
                fw.write(note.textArea.getText());
                fw.close();
            }
            catch(Exception e)
            {
                System.out.println("SOMETHING WRONG");
            }
        }
    }
    public void exit()
    {
        System.exit(0);
    }
}
