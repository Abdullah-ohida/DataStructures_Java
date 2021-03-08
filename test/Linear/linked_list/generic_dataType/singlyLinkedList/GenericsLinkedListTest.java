package Linear.linked_list.generic_dataType.singlyLinkedList;

import Linear.linked_list.generic_dataType.circularLinkedList.CircularNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericsLinkedListTest {
    LinkedList<Integer> list;
    CircularNode<String> circularList;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
        circularList = new CircularNode<>();
    }


    @AfterEach
    void tearDown() {
            list = new LinkedList<>();
    }

    @Test
    void testIfDataCanBeAddedToTheFrontOfLinkedList(){
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

    @Test
    void singlyList_accessFirstElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(LinkedList.LinkedListUnderFlowException.class, ()-> list.getHead());
    }

    @Test
    void singlyList_accessEndElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(LinkedList.LinkedListUnderFlowException.class, ()-> list.getTail());
    }

    @Test
    void circularList_canAddElementToTheFrontOfALinkedList(){
        circularList.insertAtBeginning("Hello");
        assertEquals(circularList.getSize(), 1);
        assertFalse(circularList.isEmpty());
    }


    @Test
    void circularList_canGetFirstElementInLinkedList(){
        circularList.insertAtEnd("Hello");
        circularList.insertAtEnd("The only way out");
        circularList.insertAtEnd("Woo");

        assertEquals(circularList.getSize(), 3);
        assertFalse(circularList.isEmpty());
        circularList.rotate();
        assertEquals(circularList.getHead(), "Hello");
    }

    @Test
    void circularList_canAddElementToTheEndOfALinkedList(){
        circularList.insertAtEnd("Hello");
        assertEquals(circularList.getSize(), 1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void circularList_canGetLastElementInLinkedList(){
        circularList.insertAtEnd("Hello");
        circularList.insertAtEnd("The only way out");
        circularList.insertAtEnd("Wowo");

        assertEquals(circularList.getSize(), 3);
        assertFalse(circularList.isEmpty());
        assertEquals(circularList.getTail(), "Wowo");
    }

    @Test
    void circularList_canRemoveFirstElementFromLinkedList(){
        circularList.insertAtEnd("Wasp");
        circularList.insertAtEnd("Are you good");
        assertEquals(circularList.getSize(), 2);
        assertEquals("Wasp", circularList.getHead());

        assertEquals(circularList.removeFirst(), "Wasp");
        assertEquals(circularList.getSize(), 1);
        assertEquals("Are you good", circularList.getHead());
    }

    @Test
    void circularList_removeLastDataWhenLinkedListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(LinkedList.LinkedListUnderFlowException.class, ()-> circularList.removeFirst());
    }

    @Test
    void circularList_accessFirstElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(LinkedList.LinkedListUnderFlowException.class, ()-> circularList.getHead());
    }

    @Test
    void circularList_accessEndElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(LinkedList.LinkedListUnderFlowException.class, ()-> circularList.getTail());
    }
}