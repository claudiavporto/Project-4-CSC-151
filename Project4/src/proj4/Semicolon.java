package proj4;

/**
 * The Semicolon class represents a Semicolon Token.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class Semicolon implements Token{

    private final int SEMICOLON = 0;

    private boolean isAnOperator;


    /**
     * Constructs a Semicolon token object
     */
    public Semicolon(){
        this.isAnOperator = false;
    }


    /** Processes the Semicolon token.
     *
     *  @param s the Stack the token uses, if necessary, when processing itself.
     *  @return String to be appended to the output
     */
    public String handle(Stack<Token> s){
        String result = "";
        while(!s.isEmpty()){
            result += s.pop();
        }
        return result;
    }


    /**
     * Returns true iff semicolon token is operator
     * @return false (semicolon is not an operator)
     */
    public boolean operator(){
        return this.isAnOperator;
    }


    /**
     * Returns 0, semicolon does not have a precedence
     * @return 0
     */
    public int precedence(){
        return SEMICOLON;
    }


    /**
     * Returns a string representation of Semicolon token
     * @return string representation of semicolon
     */
    public String toString() {
        return ";";
    }
}
