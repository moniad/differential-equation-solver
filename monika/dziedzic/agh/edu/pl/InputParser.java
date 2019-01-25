package monika.dziedzic.agh.edu.pl;


class InputParser {
    private String inputString;
    protected int n;
    protected float k;

    public InputParser(String inputString){
        this.inputString=inputString;
    }
    public void parseInput() throws IncorrectInputException{
        String[] separatedInput = inputString.split(" ");
        this.n= Integer.parseInt(separatedInput[0]);
        this.k = Integer.parseInt(separatedInput[1]);

        if(n<=0 || k<=0) throw new IncorrectInputException("Values of n and k" +
                " you inserted are incorrect. Try again");
        //System.out.println(n);
        //System.out.println(k);
    }
}