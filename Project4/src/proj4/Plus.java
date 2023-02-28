package proj4;

/**
 * The Plus class represents a Plus Token operator.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class Plus implements Token {

    private final int PLUS = 1;

    private boolean isAnOperator;
    private int precedence;


    /**
     * Constructs a Plus token object
     */
    public Plus(){
        this.isAnOperator = true;
        this.precedence = PLUS;
    }


    /** Processes the Plus token.
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
     * Returns true iff plus token is operator
     * @return true (plus is an operator)
     */
    public boolean operator(){
        return this.isAnOperator;
    }


    /**
     * Returns the precedence of the plus token
     * @return precedence
     */
    public int precedence(){
        return this.precedence;
    }


    /**
     * Returns a string representation of Plus token
     * @return string representation of plus
     */
    public String toString() {
        return "+";
    }
}
