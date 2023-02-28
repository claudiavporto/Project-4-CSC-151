package proj4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * Write a description of class StackTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 *
 */
public class StackTest {

	@Rule
    public Timeout timeout = Timeout.millis(100);
	
    private Stack<String> stack;
    
    @Before
    public void setUp() throws Exception{
        stack = new Stack<String>();
    }

    @After
    public void tearDown() throws Exception{
        stack = null;
    }

    @Test
    public void testStackConstructor_toString(){
        assertEquals("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
    }
    
    @Test
    public void testStackPushOneOntoEmptyStack(){
        stack.push("A");
        assertEquals("Pushing A onto an empty stack.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushTwoOntoEmptyStack(){
        stack.push("A");
        stack.push("B");
        assertEquals("Pushing first A and then B onto an empty stack.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushThreeOntoEmptyStack(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("Pushing first A, then B, then C onto an empty stack.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopOnEmptyStack(){
        assertNull("Popping an empty stack.", stack.pop());
        assertEquals("{>}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopOnSizeOneStack(){
        stack.push("A");
        assertEquals("Popping an stack of size 1.", "A", stack.pop());
        assertEquals(0, stack.size());
        assertEquals( "{>}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopOnSizeTwoStack(){
        stack.push("A");
        stack.push("B");
        assertEquals("Popping an stack of size 2.", "B", stack.pop());
        assertEquals(1, stack.size());
        assertEquals( "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopOnSizeTenStack(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");
        stack.push("J");
        assertEquals("Popping an stack of size 10.", "J", stack.pop());
        assertEquals(9, stack.size());
        assertEquals( "{>I,H,G,F,E,D,C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekOnEmptyStack(){
        assertNull("Peeking at an empty stack.", stack.peek());
        assertEquals("{>}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekOnSizeOneStack(){
        stack.push("A");
        assertEquals("Peeking at a stack of size 1.", "A", stack.peek());
        assertEquals(1, stack.size());
        assertEquals( "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekOnSizeTwoStack(){
        stack.push("A");
        stack.push("B");
        assertEquals("Peeking at a stack of size 2.", "B", stack.peek());
        assertEquals(2, stack.size());
        assertEquals( "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekOnSizeTenStack(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");
        stack.push("J");
        assertEquals("Peeking at a stack of size 10.", "J", stack.peek());
        assertEquals(10, stack.size());
        assertEquals( "{>J,I,H,G,F,E,D,C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackSizeOnEmptyStack(){
        assertEquals(0, stack.size());
    }

    @Test
    public void testStackSizeOnSizeOneStack(){
        stack.push("A");
        assertEquals(1, stack.size());
    }

    @Test
    public void testStackSizeOnSizeEightStack(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        assertEquals(8, stack.size());
    }
}