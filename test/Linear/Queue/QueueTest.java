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
        int value = 9;
        queue.enqueue(value);
        assertEquals(1, queue.getSize());
    }
}