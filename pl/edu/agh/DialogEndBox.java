package pl.edu.agh;

import javax.swing.*;

class DialogEndBox extends DialogBox {
    public DialogEndBox(){
        super();
    }
    protected void showDialog(){
        JOptionPane.showMessageDialog(null,"That's the result");
    }
}