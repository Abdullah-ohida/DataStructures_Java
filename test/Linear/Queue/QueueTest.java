package Linear.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int value = 9;
        queue.enqueue(value);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(9);
        queue.enqueue(100);
    }

    @Test
    void queue_canGetFirstElementPushedOntoTheQueue(){
        addToQueue();
        int frontElement = queue.front();
        assertEquals(9, frontElement);
    }

    void queue_canRemoveTheFirstElementPushedToTheQueue(){
        addToQueue();
    }
}