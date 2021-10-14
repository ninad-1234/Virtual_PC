package Virtual_laptop;

public class Function_Edit {
    Notepad1 note;
    
    public Function_Edit(Notepad1 note)
    {
        this.note = note;
    }
    
    public void undo()
    {
        note.um.undo();
    }
    
    public void redo()
    {
        note.um.redo();
    }
}
