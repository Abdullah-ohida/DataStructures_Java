package Linear.linked_list.generic_dataType.singlyLinkedList;

import Linear.linked_list.generic_dataType.DoublyLinkedList;
import Linear.linked_list.generic_dataType.SinglyLinkedList;
import Linear.linked_list.generic_dataType.CircularNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericsSinglyDoublyLinkedListTest {
    SinglyLinkedList<Integer> list;
    CircularNode<String> circularList;
    DoublyLinkedList<Character> doublyList;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
        circularList = new CircularNode<>();
        doublyList = new DoublyLinkedList<>();
    }


    @AfterEach
    void tearDown() {
            list = new SinglyLinkedList<>();
    }

    @Test
    void testIfDataCanBeAddedToTheFrontOfLinkedList(){
        list.insertAtBeginning(3);
        assertEquals(list.getSize(), 1);
        assertFalse(list.isEmpty());
    }

    @Test
    void list_canGetFirstDataInLinkedList(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
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
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
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
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
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
        assertThrows(SinglyLinkedList.LinkedListUnderFlowException.class, ()-> list.removeFirst());
    }

    @Test
    void singlyList_accessFirstElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(SinglyLinkedList.LinkedListUnderFlowException.class, ()-> list.getHead());
    }

    @Test
    void singlyList_accessEndElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(SinglyLinkedList.LinkedListUnderFlowException.class, ()-> list.getTail());
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
        assertThrows(SinglyLinkedList.LinkedListUnderFlowException.class, ()-> circularList.removeFirst());
    }

    @Test
    void circularList_accessFirstElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(SinglyLinkedList.LinkedListUnderFlowException.class, ()-> circularList.getHead());
    }

    @Test
    void circularList_accessEndElementWhenListIsEmpty_ThrowsLinkedListUnderFlow(){
        assertTrue(circularList.isEmpty());
        assertThrows(SinglyLinkedList.LinkedListUnderFlowException.class, ()-> circularList.getTail());
    }


    @Test
    void doublyList_listCanBeEmpty(){
        assertTrue(doublyList.isEmpty());
    }

    @Test
    void doublyList_canAddDataAtTheBeginningOfAList(){
        doublyList.insertAtBeginning('T');
        assertEquals(doublyList.getHead(), 'T');
        assertEquals(1, doublyList.getSize());
    }

    @Test
    void doublyList_canAddMoreThanOneDataToAList(){
        doublyList.insertAtBeginning('T');
        doublyList.insertAtBeginning('H');
        doublyList.insertAtBeginning('E');
        assertEquals(doublyList.getHead(), 'T');
        assertEquals(3, doublyList.getSize());
    }

    @Test
    void doublyList_canAddDataAtTheEndOfAList(){
        doublyList.insertAtBeginning('T');
        assertEquals(doublyList.getTail(), 'T');
        assertEquals(1, doublyList.getSize());
    }

    @Test
    void doublyList_canAddMoreThanOneDataToTheEndOfAList(){
        doublyList.insertAtEnd('T');
        doublyList.insertAtEnd('H');
        doublyList.insertAtEnd('E');
        assertEquals(doublyList.getTail(), 'E');
        assertEquals(3, doublyList.getSize());
    }
}