package monika.dziedzic.agh.edu.pl;

// na labach był przykład z delelgowaniem czegoś
// do odpowiedniej klasy za pomoca interfejsu
// to tutaj nie pasuje, bo wprowadzamy zmiany?
// czy coś źle ogarnęłam XD? 
//ogarnąć całki
//oraz poprawić wykres
//napisać testy
//..
//zapis do pliku mozna zrobić
//statyczna macierz FloatMatrix??
//czemu special cases

//zrobić zapis do pliku punktów wynikowych albo wykresu czy coś, nwm

//czy ja muszę w każdym?????
//mogę wywoływać metody z innej klasy tylko na obiektach tej klasy!!!
//this.matrixW=Solve.solve(this.matrixB,this.matrixL);

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
                eq.tableMatrixU,eq.elems);
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
        DialogEndBox dialogEndBox = new DialogEndBox();
        dialogEndBox.showDialog();
    }
}