package monika.dziedzic.agh.edu.pl;

import org.jblas.FloatMatrix;
import org.jblas.Solve;

class EquationSolver {
    int elems;
    private float k;
    private FloatMatrix matrixU; //result - approximated solution
    private FloatMatrix matrixB, matrixW, matrixL; //matrixW - matrix of coefficients
    float[] tableMatrixU;

    public EquationSolver(int elems, float k){
        this.elems=elems;
        this.k=k;
        this.matrixB=FloatMatrix.zeros(elems+1,elems+1);
        this.matrixW=FloatMatrix.zeros(elems+1);
        this.matrixL=FloatMatrix.zeros(elems+1);
        this.matrixU=FloatMatrix.zeros(elems+1);
        this.tableMatrixU=new float[elems+1]; //muszę to przepisać, bo JFree
    }

    void solveEq(){
        //get computed integrals
        IntegralCalculator integralCalculator = new IntegralCalculator(matrixB, matrixL,elems+1,k);
        this.matrixB = integralCalculator.calculateMatrixB();
        this.matrixL = integralCalculator.calculateMatrixL();
        this.matrixW=Solve.solve(this.matrixB,this.matrixL); //solving the eq. system using jblas
        //return shift
        BaseFunctionsHandler baseFunctionsHandler = new BaseFunctionsHandler();
        this.matrixU=(new ReturnShift(matrixW, baseFunctionsHandler,elems+1)).getU(); // -> u is computed
        for(int i=0; i<=elems; i++)
            tableMatrixU[i]=this.matrixU.get(i);
    }
}