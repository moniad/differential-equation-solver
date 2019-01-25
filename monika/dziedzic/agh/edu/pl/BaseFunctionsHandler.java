package monika.dziedzic.agh.edu.pl;

class BaseFunctionsHandler //extends FunctionsHandler
{
    //ArrayList<BaseFunction> baseFunctions;
    public BaseFunctionsHandler(){
        //super(n);
    }
    /*public void addRecommendedBaseFunctions(int n, int x){
        this.baseFunctions.add(new BaseFunction(1-(n-1)*x, 0));
        this.baseFunctions.add(new BaseFunction((n-1)*x, 2-(n-1)*x));
        this.baseFunctions.add(new BaseFunction(0, (n-1)*x-1));
    }*/
    public float getBaseFunctions(float x, int n, int i){ //n is the number of elems
        //addRecommendedBaseFunctions(n,x);
        if(x>=(float)i/n)
            return Math.max(1-n*x+i,0); //returning max so that in other ranges the value of the base function is 0
        else
            return Math.max(1+n*x-i,0);
            //this.baseFunctions.add(new BaseFunction(eSmaller,eGreater));

        /*if(j%3==1){
            float e1Smaller = baseFunctions.get(j%3).smaller; //first base fct
            float e1Greater = baseFunctions.get(j%3).greaterOrEq;
            this.baseFunctions.add(new BaseFunction(e1Smaller+j-j%3,e1Greater));
        }
        else if(j%3==2){
            float e2Smaller = baseFunctions.get(j%3).smaller; //second base fct
            float e2Greater = baseFunctions.get(j%3).greaterOrEq;
            this.baseFunctions.add(new BaseFunction(e2Smaller+j-j%3,e2Greater+j-j%3));
        }
        else { //j%3==0
            float e3Smaller = baseFunctions.get(j%3).smaller; //third base fct
            float e3Greater = baseFunctions.get(j%3).greaterOrEq;
            this.baseFunctions.add(new BaseFunction(e3Smaller,e3Greater+j));
        }*/
        //return this.baseFunctions;
    }
}
