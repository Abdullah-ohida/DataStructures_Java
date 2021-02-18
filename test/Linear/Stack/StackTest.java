package Linear.Stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(5);
    }

    @AfterEach
    void tearDown() {
        stack = null;
    }

    @Test
    void stack_canAddElementToStack() {
        stack.push(7);
        stack.push(8);
        assertEquals(8, stack.peek());
    }

    @Test
    void pushTwoElement_popOneTest(){
        stack.push(7);
        stack.push(8);
        assertEquals(8, stack.pop());
        assertEquals(7, stack.peek());
    }

    @Test
    void pushTwo_PopTwo_ElementShouldBeEmpty(){
        stack.push(11);
        stack.push(8);

        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushThreeElement_ShouldBeFull(){
        Stack stack = new Stack(3);
        stack.push(11);
        stack.push(8);
        stack.push(7);

        assertTrue(stack.isFull());
    }

    @Test
    void pushOneElement_AfterStackIsFull_ThrowsException(){
        Stack stack = new Stack(3);
        stack.push(11);
        stack.push(8);
        stack.push(7);
        assertTrue(stack.isFull());

        assertThrows(Stack.StackOverFlowException.class, ()-> stack.push(9));
    }

    @Test
    void removeLastElementWhenStackIsEmpty_ThrowsStackUnderFlow(){
        assertTrue(stack.isEmpty());
        assertThrows(Stack.StackUnderFlowException.class, ()-> stack.pop());
    }

    @Test
    void peekEmptyStack_ThrowsStackUnderFlowException(){
        assertTrue(stack.isEmpty());
        assertThrows(Stack.StackUnderFlowException.class, ()-> stack.peek());
    }

}