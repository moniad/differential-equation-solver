package monika.dziedzic.agh.edu.pl;

//not necessary, I'll probably calculate them normally, on the sheet of paper :P
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.TrapezoidIntegrator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

/* Name of the class has to be "Main" only if the class is public. */
class MyFunctionToBeIntegrated{
    public static void main(String args[])
    {
        //int n = 2; //parseInt(args[0]);
        SimpsonIntegrator simpson = new SimpsonIntegrator();
        TrapezoidIntegrator trapezoid = new TrapezoidIntegrator();
        double[] vector = new double[2];
        vector[0] = 0;
        vector[1] = 1;
        //vector[2] = 2;

        PolynomialFunction f = new PolynomialFunction(vector);
        UnivariateFunction uf = (UnivariateFunction)new PolynomialFunction(vector);
        System.out.println("To String " + uf.toString());
        System.out.println("Degree: " + f.degree());

        double i = simpson.integrate(100, uf, -Float.MAX_VALUE, Float.MAX_VALUE);
        double j = trapezoid.integrate(100, uf, 0, 1);
        System.out.println("Simpson integral : " + i);
        System.out.println("Trapezoid integral : " + j);
    }
}