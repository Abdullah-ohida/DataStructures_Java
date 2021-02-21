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
        list.insertAtEnd(5);
        list.insertAtEnd(9);
        list.insertAtEnd(10);
        list.insertAtEnd(50);
        assertEquals(8, list.getHeadData());
        assertFalse(list.isEmpty());
    }

    @Test
    void linkedList_canInsertDataAtASpecificPositionOnList(){
        addDataToTheBeginningOfList();
        Node node = list.getHead().getPointer();
        list.insertAfter(node , 9);
        assertFalse(list.isEmpty());
        String expected =  "50 45 9 20 ";
        assertEquals(expected, list.printList(list));
    }

    @Test
    void linkedList_canDeleteElementAtSpecificPositionOnList(){
        addDataToTheBeginningOfList();
        int position = 1;
        list.deleteNode(position);
        assertFalse(list.isEmpty());
        String expected =  "50 20 ";
        assertEquals(expected, list.printList(list));
    }

    @Test
    void linkedList_canSearchASpecificDataOnLinkedList(){
        list.insertAtBeginning(50);
        int data = 50;
        Node node = list.search(data);
        assertEquals(list.getHead(), node);
    }

    @Test
    void linkedList_canGetFirstDataFromList(){
        list.insertAtEnd(5);
        list.insertAtEnd(9);
        list.insertAtEnd(10);
        list.insertAtEnd(50);
        System.out.println(list.printList(list));
        assertEquals(5, list.getHeadData());
    }

    @Test
    void linkedList_canGetLastDataFromList(){
//        list.insertAtBeginning(5);
//        list.insertAtBeginning(9);
//        list.insertAtBeginning(10);
//        list.insertAtBeginning(50);
//        assertEquals(5, list.getTail());

        list.insertAtEnd(5);
        list.insertAtEnd(9);
        list.insertAtEnd(10);
        list.insertAtEnd(50);
        System.out.println(list.printList(list));
        assertEquals(50, list.getTail());

    }

}

