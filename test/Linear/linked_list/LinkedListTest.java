package Linear.linked_list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList list;
    @BeforeEach
    void setUp() {
        list = new LinkedList();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    void linkedList_isEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test
    void linkedList_canInsertNodeAtTheBeginningOfList(){
        addDataToList();
        assertFalse(list.isEmpty());
    }

    private void addDataToList() {
        int value = 20;
        list.insertAtBeginning(value);
        list.insertAtBeginning(45);
        list.insertAtBeginning(50);
    }

    @Test
    void linkedList_canPrintOutAllDataPrintOnList(){
        addDataToList();
        String expected = "50 45 20 ";
        assertEquals(expected, list.printList(list));
    }


}