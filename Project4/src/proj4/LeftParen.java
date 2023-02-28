package proj4;

/**
 * The LeftParen class represents a LeftParen Token.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class LeftParen implements Token{

    private final int PAREN = 0;

    private boolean isAnOperator;


    /**
     * Constructs a LeftParen token object
     */
    public LeftParen(){
        this.isAnOperator = false;
    }


    /** Processes the LeftParen token.
     *
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        s.push(this);
        return "";
    }


    /**
     * Returns true iff LeftParen token is operator
     * @return false (LeftParen is not an operator)
     */
    public boolean operator(){
        return this.isAnOperator;
    }


    /**
     * Returns 0, parenthesis does not have a precedence
     * @return 0
     */
    public int precedence(){
        return PAREN;
    }


    /**
     * Returns a string representation of LeftParen token
     * @return string representation of LeftParen
     */
    public String toString() {
        return "(";
    }
}
