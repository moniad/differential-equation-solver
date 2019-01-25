package monika.dziedzic.agh.edu.pl;

import org.jblas.FloatMatrix;

class ReturnShift {
    protected FloatMatrix matrixU;
    protected FloatMatrix matrixW;
    protected BaseFunctionsHandler baseFunctionsHandler;
    private int n;

    public ReturnShift(FloatMatrix matrixW, BaseFunctionsHandler baseFunctionsHandler, int n) {
        this.n=n;
        this.matrixU=FloatMatrix.zeros(n);
        this.matrixW=matrixW;
        this.baseFunctionsHandler=baseFunctionsHandler;
    }
    public FloatMatrix getU(){
        //... to do, use base functions, check the values of n
        float x, sumOfCoefMultByBaseFcts;
        for(int i=0; i<n; i++) { //diving the range into smaller pieces
            x=i/n;
            sumOfCoefMultByBaseFcts=0;
            for(int j=1; j<n; j++){
                sumOfCoefMultByBaseFcts += matrixW.get(i) + baseFunctionsHandler.getBaseFunctions(x, n, i);
            }
            matrixU.put(i, 5 * (1 - x) + sumOfCoefMultByBaseFcts); //Math.max(1 - Math.abs(x - i / n), 0));
        }
        return matrixU;
    }
}