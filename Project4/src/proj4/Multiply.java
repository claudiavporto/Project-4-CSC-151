package proj4;

/**
 * The Multiply class represents a Multiply Token operator.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class Multiply implements Token{

    public final int MULTIPLY = 2;

    private boolean isAnOperator;
    private int precedence;


    /**
     * Constructs a Multiply token object
     */
    public Multiply(){
        this.isAnOperator = true;
        this.precedence = MULTIPLY;
    }


    /** Processes the Multiply token.
     *
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s) {
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
     * Returns true iff Multiply token is operator
     * @return true (Multiply is an operator)
     */
    public boolean operator(){
        return this.isAnOperator;
    }


    /**
     * Returns the precedence of the multiply token
     * @return precedence
     */
    public int precedence(){
        return this.precedence;
    }


    /**
     * Returns a string representation of Multiply token
     * @return string representation of multiply
     */
    public String toString() {
        return "*";
    }

}
