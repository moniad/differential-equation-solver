package pl.edu.agh;

class InputParser {
    private String inputString;
    protected int n;
    float k;

    InputParser(String inputString){
        this.inputString=inputString;
    }
    void parseInput() throws IncorrectInputException{
        String[] separatedInput = inputString.split(" ");
        this.n= Integer.parseInt(separatedInput[0]);
        this.k = Integer.parseInt(separatedInput[1]);

        if(n<=0 || k<=0) throw new IncorrectInputException("Values of n and k" +
                " you inserted are incorrect. Try again");
    }
}