package monika.dziedzic.agh.edu.pl;

class BaseFunctionsHandler //extends FunctionsHandler
{
    //ArrayList<BaseFunction> baseFunctions;
    public BaseFunctionsHandler(){
        //super(n);
    }
    float getBaseFunctions(float x, int n, int i){ //n is the number of elems
        if(x>=(float)i/n)
            return Math.max(1-n*x+i,0); //returning max so that in other ranges the value of the base function is 0
        else
            return Math.max(1+n*x-i,0);
    }
}
