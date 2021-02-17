package Linear.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void queue_canAddElementToQueue(){
        addToQueue();
        assertEquals(5, queue.getSize());
    }

    private void addToQueue() {
        int value = 1;
        queue.enqueue(value);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
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
        queue.dequeue();
        queue.dequeue();
        assertEquals(3, queue.getSize());
    }

    @Test
    void queue_canRemoveElementAtSpecificPositionOnQueue(){
        addToQueue();
        queue.dequeue(1);
        assertEquals(4, queue.getSize());
    }

    @Test
    void stack_canNotAccessIndexOfElementInStack(){
        addToQueue();
        try {
            queue.dequeue(9);
            assertEquals(4, queue.getSize());
        }catch (IllegalArgumentException exception){
            System.err.println(exception.getMessage());
        }

    }

    @Test
    void stack_canBeEmpty(){
        queue.enqueue(7);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}