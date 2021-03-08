package Linear.linked_list.generic_dataType.singlyLinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<Integer>();
    }


    @AfterEach
    void tearDown() {
            list = new LinkedList<>();
    }

    @Test
    void list_canAddDataToTheFrontOfLinkedList(){
        list.insertAtBeginning(3);
        assertEquals(list.getSize(), 1);
        assertFalse(list.isEmpty());
    }

    @Test
    void list_canGetFirstDataInLinkedList(){
        LinkedList<String> list = new LinkedList<>();
        list.insertAtBeginning("Hello");
        assertEquals("Hello", list.getHead());
    }

    @Test
    void list_canAddTwoDataToTheFrontOfLinkedList(){
        list.insertAtBeginning(3);
        list.insertAtBeginning(10);
        assertEquals(list.getSize(), 2);
        assertFalse(list.isEmpty());
    }

    @Test
    void list_canAddDifferentDataTypeToFrontOfLinkedList(){
        LinkedList<String> list = new LinkedList<>();
        list.insertAtBeginning("Hello");
        list.insertAtBeginning("Madam");
        assertEquals(list.getSize(), 2);
        assertFalse(list.isEmpty());
    }

    @Test
    void list__canDataCanBeToTheEndOfLinkedList(){
        list.insertAtEnd(45);
        assertEquals(list.getSize(), 1);
        assertFalse(list.isEmpty());
    }

    @Test
    void list__canTwoDataCanBeToTheEndOfLinkedList(){
        list.insertAtEnd(45);
        list.insertAtEnd(64);
        assertEquals(list.getSize(), 2);
        assertFalse(list.isEmpty());
    }

    @Test
    void list_canAddDifferentDataTypeAtTheEndLinkedList(){
        LinkedList<String> list = new LinkedList<>();
        list.insertAtEnd("Hello");
        list.insertAtEnd("Madam");
        assertEquals(list.getSize(), 2);
        assertFalse(list.isEmpty());
    }


    @Test
    void list_canGetLastDataInLinkedList(){
        list.insertAtEnd(45);
        list.insertAtEnd(32);
        list.insertAtEnd(4);
        assertEquals(4, list.getTail());
    }

    @Test
    void list_canRemoveFirstElementFromLinkedList(){
        list.insertAtEnd(45);
        list.insertAtEnd(32);
        assertEquals(list.getSize(), 2);
        assertEquals(45, list.getHead());

       assertEquals(list.removeFirst(), 45);
        assertEquals(list.getSize(), 1);
        assertEquals(32, list.getHead());

        assertEquals(list.removeFirst(), 32);
        assertEquals(list.getSize(), 0);
        assertTrue(list.isEmpty());
    }

    @Test
    void list_removeLastDataWhenLinkedListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(list.isEmpty());
        assertThrows(LinkedList.LinkedListUnderFlowException.class, ()-> list.removeFirst());
    }

}