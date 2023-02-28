package proj4;

/**
 * The Exponent class represents an Exponent Token operator.
 * 
 * @author Claudia Poero
 * @version 11/1/2022
 */
public class Exponent implements Token{

    private final int EXPONENT = 3;

    private boolean isAnOperator;
    private int precedence;


    /**
     * Constructs an Exponent token object
     */
    public Exponent(){
        this.isAnOperator = true;
        this.precedence = EXPONENT;
    }


    /** Processes the Exponent token.
     *
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        String result = "";
        while(canPop(this, s)){
            result += s.pop();
        }
        s.push(this);
        return result;
    }


    private boolean canPop(Token t, Stack<Token> s){
        if(s.peek() instanceof LeftParen || s.isEmpty()){
            return false;
        }else{
            return this.precedence() <= s.peek().precedence();
        }
    }


    /**
     * Returns true iff exponent token is operator
     * @return true (Exponent is an operator)
     */
    public boolean operator(){
        return this.isAnOperator;
    }


    /**
     * Returns the precedence of the exponent token
     * @return precedence
     */
    public int precedence(){
        return this.precedence;
    }


    /**
     * Returns a string representation of Exponent token
     * @return string representation of exponent
     */
    public String toString() {
        return "^";
    }
}
