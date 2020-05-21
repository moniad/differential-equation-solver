package pl.edu.agh;

import org.jfree.ui.RefineryUtilities;

public class Main {
    public static void main(String[] args)
    {
        DialogStartBox dialogBox = new DialogStartBox();
        dialogBox.showDialog();
        dialogBox.showEquationToBeSolved();

        EquationSolver eq = new EquationSolver(dialogBox.n,dialogBox.k);
        eq.solveEq();

        Chart chart=new Chart("Wykresik, proszę państwa", "Approximated solution to the equation",
                eq.tableMatrixU,eq.elems+1);
        chart.pack();

        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);

        DialogEndBox dialogEndBox = new DialogEndBox();
        dialogEndBox.showDialog();
    }
}