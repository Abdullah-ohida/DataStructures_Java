package Linear.Queue;

import Linear.Stack.Stack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(4);
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void queue_canAddElementToQueue(){
        addToQueue();
        assertEquals(1, queue.front());
    }

    private void addToQueue() {
        int value = 1;
        queue.enqueue(value);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    }

    @Test
    void queue_canGetFirstElementPushedOntoTheQueue(){
        addToQueue();
        int frontElement = queue.front();
        assertEquals(1, frontElement);
    }

    @Test
    void queue_canRemoveTheFirstElementPushedToTheQueue(){
        addToQueue();
        assertEquals(1,  queue.dequeue());
    }

    @Test
    void enqueueTwo_dequeueTwo_ElementShouldBeEmpty(){
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(0);
        queue.enqueue(4);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println(Arrays.toString(queue.getElement()));
        assertEquals(0, queue.getQueueLength());
    }

    @Test
    void enqueueThreeElement_ShouldBeFull(){
        Queue queue = new Queue(3);
        queue.enqueue(11);
        queue.enqueue(8);
        queue.enqueue(7);

        assertTrue(queue.isFull());
    }

    @Test
    void enqueueOneElement_AfterStackIsFull_ThrowsException(){
        Queue queue= new Queue(3);
        queue.enqueue(11);
        queue.enqueue(8);
        queue.enqueue(7);
        assertTrue(queue.isFull());

        assertThrows(Stack.StackOverFlowException.class, ()-> queue.enqueue(9));
    }

    @Test
    void dequeueFirstElementWhenQueueIsEmptyIsEmpty_ThrowsStackUnderFlow(){
        assertTrue(queue.isEmpty());
        assertThrows(Stack.StackUnderFlowException.class, ()-> queue.dequeue());
    }

    @Test
    void frontEmptyStack_ThrowsStackUnderFlowException(){
        assertTrue(queue.isEmpty());
        assertThrows(Stack.StackUnderFlowException.class, ()-> queue.front());
    }

}