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
    void linkedList_isEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void linkedList_canInsertNodeAtTheBeginningOfList() {
        addDataToTheBeginningOfList();
        assertFalse(list.isEmpty());
    }

    private void addDataToTheBeginningOfList() {
        int value = 20;
        list.insertAtBeginning(value);
        list.insertAtBeginning(45);
        list.insertAtBeginning(50);
    }

    @Test
    void linkedList_canPrintOutAllDataPrintOnList() {
        addDataToTheBeginningOfList();
        String expected = "50 45 20 ";
        assertEquals(expected, list.printList(list));
    }

    @Test
    void linkedList_canInsertNodeAtTheEndOfList() {
        int value = 8;
        list.insertAtEnd(value);
        assertFalse(list.isEmpty());
    }

    @Test
    void linkedList_canGetFirstDataFromList(){
        addDataToTheBeginningOfList();
        assertEquals(20, list.getHeadData());
    }

    @Test
    void linkedList_canGetLastDataFromList(){
        addDataToTheBeginningOfList();
        assertEquals(8, list.getTail());
    }

}

