package monika.dziedzic.agh.edu.pl;

import javax.swing.*;

public class DialogEndBox extends DialogBox {
    public DialogEndBox(){
        super();
    }
    protected void showDialog(){
        JOptionPane.showMessageDialog(null,"That's the result");
    }
}