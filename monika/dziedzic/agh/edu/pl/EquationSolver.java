package monika.dziedzic.agh.edu.pl;

import org.jblas.FloatMatrix;
import org.jblas.Solve;

public class EquationSolver {
    protected int elems;
    protected float k;
    FloatMatrix matrixU; //result - approximated solution
    FloatMatrix matrixB, matrixW, matrixL; //matrixW - matrix of coefficients
    protected BaseFunctionsHandler baseFunctionsHandler;
    float[] tableMatrixU;

    public EquationSolver(int elems, float k){
        this.elems=elems;
        this.k=k;
        this.matrixB=FloatMatrix.zeros(elems+1,elems+1);
        this.matrixW=FloatMatrix.zeros(elems+1);
        this.matrixL=FloatMatrix.zeros(elems+1);
        this.matrixU=FloatMatrix.zeros(elems+1);
        this.baseFunctionsHandler=new BaseFunctionsHandler();
        this.tableMatrixU= new float[elems+1]; //muszę to przepisać, bo JFree
    }

    protected void solveEq(){
        //chcę dostać macierze z policzonymi całkami za pomocą apache
        IntegralCalculator integralCalculator = new IntegralCalculator(matrixB, matrixL,elems+1,k);
        this.matrixB = integralCalculator.calculateMatrixB();
//this.matrixB.print();
        this.matrixL = integralCalculator.calculateMatrixL();
//this.matrixL.print();
        this.matrixW=Solve.solve(this.matrixB,this.matrixL); //solving the eq. system using jblas

        //return shift
        BaseFunctionsHandler baseFunctionsHandler = new BaseFunctionsHandler();
        this.matrixU=(new ReturnShift(matrixW, baseFunctionsHandler, elems+1)).getU(); //-> u jest policzone

        for(int i=0; i<=elems; i++)
            tableMatrixU[i]=this.matrixU.get(i);
    }
}