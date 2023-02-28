package proj4;

/**
 * Stack class that represents a Stack.
 * The Stack is a collection of items that follows the Last in, First out principle.
 * It can only be accessed by the client at the top element.
 *
 *  Invariants of the Stack class:
 *  1. size is the number of items in the stack
 *  2. if size == 0, stack is empty
 *  3. items are stored in array called holder
 *  4. bottom of the stack is at data[0]
 *  5. top of the stack is at data[size-1]
 */
public class Stack<T>
{
    private final int DEFAULT_CAPACITY = 10;
    private final int EMPTY = 0;
    private final int BOTTOM = 0;

    private int size;
    private Object[] holder;


    /**
     * Constructs and initializes an empty Stack
     */
    public Stack() {
       this.size = 0;
       this.holder = new Object[DEFAULT_CAPACITY];
    }


    /**
     * returns true iff the stack has no items, false otherwise
     * @return true if stack is empty
     */
    public boolean isEmpty() {
    	return size() == EMPTY;
    }


    /**
     * Adds an item to the top of the stack
     * @param toPush item to add
     */
    public void push(T toPush) {
       this.holder[size()] = toPush;
       this.size++;
    }


    /**
     * removes and returns the top item from the stack
     * @return the item at the top of the stack
     */
    public T pop() {
        if(isEmpty()){
            return null;
        }else {
            T top = top();
            this.size--;
            return top;
        }
    }


    /**
     * returns the top item from the stack
     * @return the top item from the stack
     */
    public T peek() {
        if(isEmpty()){
            return null;
        }else {
            return top();
        }
    }


    /**
     * returns the number of items in the stack
     * @return number of items in the stack
     */
    public int size() {
    	return this.size;
    }


    /**
     * Produce a string representation of this Stack.
     * Formatted with commas separating each item
     * and curly braces on each end.
     * The top of the stack will be indicated with >.
     * @return a string representation of this stack
     */
    public String toString() {
        String stackString = "{>";

        if(!isEmpty()) {
            for (int i = size()-1; i >= 0; i--) {
                stackString += this.holder[i];
                if(!isBottom(i)) {
                    stackString += ", ";
                }
            }
        }
        stackString += "}";

        return stackString;
    }


    //PRIVATE HELPER METHODS
    private boolean isBottom(int index){
        return index == BOTTOM;
    }

    private T top(){
        if(isEmpty()){
            return null;
        }
        return (T)this.holder[size()-1];
    }
} 
   

