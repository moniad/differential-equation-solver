package pl.edu.agh;

import javax.swing.*;

class DialogStartBox extends DialogBox {
    public DialogStartBox(){
        super();
    }

    //just show input dialog in order to get n and k
    protected void showDialog(){
        String inputString = JOptionPane.showInputDialog("Enter the values of n (must be greater than zero) "
                + "and k, separated by space", JOptionPane.QUESTION_MESSAGE);
        try {
            InputParser inputParser=new InputParser(inputString);
            inputParser.parseInput();
            this.n=inputParser.n;
            this.k=inputParser.k;
        }
        catch (IncorrectInputException e){
            e.printStackTrace();
        }
    }
    void showEquationToBeSolved(){
        JOptionPane.showMessageDialog(null,"I'm solving the following equation: " +
                "u'-"+this.k+"*u''=5x-10, \n with the following BVP: u(0)=5, u'(1)=3");
    }
}