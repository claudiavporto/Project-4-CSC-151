package proj4;

/**
 * The Divide class represents a Divide Token operator.
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */
public class Divide implements Token{

    public final int DIVIDE = 2;

    private boolean isAnOperator;
    private int precedence;


    /**
     * Constructs a Divide token object
     */
    public Divide(){
        this.isAnOperator = true;
        this.precedence = DIVIDE;
    }


    /** Processes the Divide token.
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
     * Returns true iff divide token is operator
     * @return true (Divide is an operator)
     */
    public boolean operator(){
        return this.isAnOperator;
    }

    /**
     * Returns the precedence of the divide token
     * @return precedence
     */
    public int precedence(){
        return this.precedence;
    }


    /**
     * Returns a string representation of Divide token
     * @return string representation of divide
     */
    public String toString() {
        return "/";
    }
}
