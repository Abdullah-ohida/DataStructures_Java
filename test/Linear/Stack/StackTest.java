package Linear.Stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @AfterEach
    void tearDown() {
        stack = null;
    }

    @Test
    void stack_canAddElementToStack(){
        addElementToStack();
        assertEquals(5, stack.getSize());
        System.out.println(Arrays.toString(stack.getStack()));
    }

    private void addElementToStack() {
        int value = 7;
        stack.push(value);
        stack.push(3);
        stack.push(4);
        stack.push(9);
        stack.push(100);
    }

    @Test
    void stack_canTheLastElementPushedOntoTheStack(){
        addElementToStack();
        int top = stack.top();
        assertEquals(100, top);
    }

    @Test
    void stack_canRemoveTheLastElementPushedIn(){
        addElementToStack();
        stack.pop();
        stack.pop();
        assertEquals(3, stack.getSize());
    }

    @Test
    void stack_canRemoveSpecificElementFromStack(){
        addElementToStack();
        stack.pop(2);
        assertEquals(4, stack.getSize());
    }

    @Test
    void stack_canBeEmpty(){
        stack.push(7);
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}