package monika.dziedzic.agh.edu.pl.unnecessary;

import java.util.ArrayList;
//nie działa, czemu?
/*
abstract class FunctionsHandler{
    ArrayList<? extends Function> functions;

    public FunctionsHandler(int n){
        this.functions=new ArrayList<>(n);
    }
    public ArrayList<? extends Function> getFunctions(int n, float x){ //n is the number of elems
        functions.add(new BaseFunction(x,5*x));
        return this.functions;
    }
}
*/