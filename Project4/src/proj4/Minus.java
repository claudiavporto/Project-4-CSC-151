package proj4;

/**
 * The Minus class represents a Minus Token operator.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class Minus implements Token{

    private final int MINUS = 1;

    private boolean isAnOperator;
    private int precedence;


    /**
     * Constructs a Minus token object
     */
    public Minus(){
        this.isAnOperator = true;
        this.precedence = MINUS;
    }


    /** Processes the Minus token.
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
     * Returns true iff Minus token is operator
     * @return true (Minus is an operator)
     */
    public boolean operator(){
        return this.isAnOperator;
    }


    /**
     * Returns the precedence of the minus token
     * @return precedence
     */
    public int precedence(){
        return this.precedence;
    }


    /**
     * Returns a string representation of Minus token
     * @return string representation of minus
     */
    public String toString() {
        return "-";
    }
}
