package proj4;

/**
 * The RightParen class represents a RightParen Token.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class RightParen implements Token{

    private final int PAREN = 0;

    private boolean isAnOperator;


    /**
     * Constructs a RightParen token object
     */
    public RightParen(){
        this.isAnOperator = false;
    }


    /** Processes the RightParen token.
     *
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        String result = "";
        while(!(s.peek() instanceof LeftParen)){
            result += s.pop();
        }
        s.pop();
        return result;
    }


    /**
     * Returns true iff RightParen token is operator
     * @return false (RightParen is not an operator)
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
     * Returns a string representation of RightParen token
     * @return string representation of RightParen
     */
    public String toString() {
        return ")";
    }
}
