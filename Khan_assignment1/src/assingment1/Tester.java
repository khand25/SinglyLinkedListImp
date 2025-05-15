package assingment1;

/**
 * This class will be used to test the various functionality with all possible
 * inputs and scenarios for a SortedLinkedList object, NodeType object, and
 * ItemType objects. This class is a good way to see if all my methods and instance
 * varaibles are working and being updated as I want the to be beofre preceding to the
 * driver class. (Should always make a tester class in the future)*/
public class Tester {

    public static void main(String[] args) {
        testItemTypeObject();
        testNodeTypeObject();
        testSortedLinkedListObjectCreation();
        testSortedLinkedListInsert();
        testSortedLinkedListDelete();
        testSortedLinkedListSearch();
        testSortedLinkedListGetNextItem();
        testSortedLinkedListMerge();
        testDeleteAlt();
        // testIntersection();
    }

    /**
     * Method that tests the functionalities of any ItemType object.*/
    public static void testItemTypeObject() {
        System.out.println("********Inside the testItemTypeObject method******");
        ItemType a = new ItemType(4);
        System.out.println("Should get the value of 4");
        System.out.println(a.getValue());
        System.out.println("Should use the set method and set the value to 5");
        a.setValue(5);
        System.out.println("Should get the value of 5");
        System.out.println(a.getValue());
        ItemType b = new ItemType(5);
        System.out.println("Now testing the compareTo method");
        System.out.println("Should get a 0 value");
        System.out.println(a.compareTo(b));
        ItemType c = new ItemType(4);
        System.out.println("Should get a 1 value");
        System.out.println(a.compareTo(c));
    } //testItemTypeObject

    /**
     * Method that tests the functionalties of any NodeType object.*/
    public static void testNodeTypeObject() {
        System.out.println("*********Inside the NodeType object creation test method**********");
        try {
            NodeType n = new NodeType(null,null);
            n.info.getValue();
            System.out.println("FAILED, Should have thrown NULLPointerException");
        } catch (NullPointerException npe) {
            System.out.println("PASSED! Thrown NullPointerException");
        }
        ItemType a = new ItemType(5);
        NodeType n = new NodeType(a,null);
        System.out.println("Testing NodeType object with the info instance variable set to 6");
        System.out.println("And next set to null");
        n.info.setValue(6);
        System.out.println(n.info.getValue());
        System.out.println(n.next == null);
        ItemType b = new ItemType(7);
        NodeType e = new NodeType(b,null);
        n.next = e;
        System.out.println("Testing values of linked list with 2 nodes of values 6 and 7");
        System.out.println(n.info.getValue());
        System.out.println(n.next.info.getValue());
        System.out.println(e.info.getValue());
    } //testNodeTypeObject
    /**
     * Method that tests wheter a SortedLinked list object is created.*/

    public static void testSortedLinkedListObjectCreation() {
        System.out.println("***Inside the testSortedLinkedListObjectCreation****");
        SortedLinkedList s = new SortedLinkedList();
        System.out.println("The length of the linked list should be 0");
        System.out.println(s.getLength());
    } //testSortedLinkedListCreation
    /**
     * Method that tests the insertItem method for any SortedLinked object.
     */

    public static void testSortedLinkedListInsert() {
        System.out.println("*****Inside the testSLLInsert method*****");
        SortedLinkedList s = new SortedLinkedList();
        System.out.println("The length of the linked list should be 0");
        System.out.println(s.getLength());
        ItemType a = new ItemType(1);
        s.insertItem(a);
        System.out.println("Inserted a value of 1 to the list.");
        System.out.println(s.getHead().info.getValue());
        System.out.println("The length of the list should be 1");
        System.out.println(s.getLength());
        System.out.println("Insert a value of -1 to the list.");
        a = new ItemType(-1);
        s.insertItem(a);
        System.out.println(s.getHead().info.getValue());
        System.out.println(s.getLength());
        a = new ItemType(3);
        s.insertItem(a);
        System.out.println("Inserted a 3 into the linked list");
        System.out.println(s.getLength());
        System.out.println(s.getHead().next.next.info.getValue());
        System.out.println("Printing out values in list. Should get -1, 1, and 3");
        NodeType temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        a = new ItemType(1);
        System.out.println("Should print a duplicate value");
        s.insertItem(a);
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        a = new ItemType(0);
        s.insertItem(a);
        System.out.println("Just entred a 0 in the list.");
        System.out.println("The length should be 4");
        System.out.println(s.getLength());
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        a = new ItemType(15);
        s.insertItem(a);
        System.out.println("The length should be 5");
        System.out.println(s.getLength());
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        // s.getHead().next.next.info.getValue();
    } //testSortedLinkedListInsert
    /**
     * Method that will test the deleteItem method for any sortedLinked list object.
     */

    public static void testSortedLinkedListDelete() {
        System.out.println("******Inside the testSLLDelete method *****");
        SortedLinkedList s = new SortedLinkedList();
        System.out.println("Attempt to delete from an empty list");
        // s.deleteItem(new ItemType(4));
        s.insertItem(new ItemType(4));
        s.insertItem(new ItemType(5));
        s.insertItem(new ItemType(2));
        s.insertItem(new ItemType(3));
        s.insertItem(new ItemType(1));
        System.out.println("Attempt to delete item that is not in the list");
        s.deleteItem(new ItemType(6));
        NodeType temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("the length of the list beofre deleting is 5");
        System.out.println(s.getLength());
        System.out.println("Attempt to delete first element of 1");
        s.deleteItem(new ItemType(1));
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("the length of the list after deleting is 4");
        System.out.println(s.getLength());
        System.out.println("Attempt to delete the last element");
        s.deleteItem(new ItemType(5));
        System.out.println("The length of the list is now 3");
        System.out.println(s.getLength());
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        s.deleteItem(new ItemType(13));
        System.out.println("Attempt to delete middle element of 3");
        s.deleteItem(new ItemType(3));
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("The legnth of the list should now be 2");
        System.out.println(s.getLength());
    } //testSortedLinkedListDelete

    /**
     * This method will test the search method for any SortedLinked list object.
     */
    public static void testSortedLinkedListSearch() {
        SortedLinkedList s = new SortedLinkedList();
        System.out.println("******Inside the testSLLSearch method******");
        System.out.println("Attempt to see if we can search an empty list");
        int index =  s.searchItem(new ItemType(0));
        System.out.println("Should print out the -1 invalid index");
        System.out.println(index);
        s.insertItem(new ItemType(1));
        System.out.println("Just inserted a 1 value to the list");
        System.out.println("Test to see if we do return the correct index value for inserted el");
        index = s.searchItem(new ItemType(1));
        System.out.println(index);
        System.out.println("Test to see if what happens when element is not present in legnth 1 ");
        index = s.searchItem(new ItemType(2));
        System.out.println(index);
        System.out.println("Test the general case now");
        s.insertItem(new ItemType(2));
        s.insertItem(new ItemType(3));
        s.insertItem(new ItemType(3));
        s.insertItem(new ItemType(-1));
        s.insertItem(new ItemType(4));
        NodeType temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("The length should be 5: " + s.getLength());
        System.out.println("The index of value -1 should be 1");
        System.out.println(s.searchItem(new ItemType(6)));


    } //testSortedLinkedListSearch

    /**
     * This method will test the getNextItem method for any sorted linked list object.
     */

    public static void testSortedLinkedListGetNextItem() {
        SortedLinkedList s = new SortedLinkedList();
        System.out.println("*****Inside the testSLLGetNextItem method*****");
        System.out.println("First test to see if list is empty");
        ItemType a = s.getNextItem();
        // a.getValue();
        s.insertItem(new ItemType(3));
        s.insertItem(new ItemType(2));
        s.insertItem(new ItemType(1));
        s.insertItem(new ItemType(5));
        s.insertItem(new ItemType(4));
        s.insertItem(new ItemType(3));
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        System.out.println("The length should be 5: " + s.getLength());
        s.getNextItem();
        a =  s.getNextItem();
        s.getNextItem();
        s.resetList();
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        System.out.println(s.getNextItem().getValue());
        s.insertItem(new ItemType(6));
        System.out.println(s.getNextItem().getValue());
        s.getNextItem();
        s.getNextItem();
    }

    /**
     * This method will test the merge method for any SortedLinked List object.
     */
    public static void testSortedLinkedListMerge() {
        System.out.println("****Inside testSortedLinkedListMerge*****");
        SortedLinkedList s = new SortedLinkedList();
        s.insertItem(new ItemType(1));
        s.insertItem(new ItemType(3));
        s.insertItem(new ItemType(5));
        s.insertItem(new ItemType(8));
        s.insertItem(new ItemType(10));
        s.insertItem(new ItemType(12));
        s.insertItem(new ItemType(20));
        System.out.println("Just created first SLL s object");
        SortedLinkedList t = new SortedLinkedList();
        t.insertItem(new ItemType(4));
        t.insertItem(new ItemType(17));
        t.insertItem(new ItemType(33));
        // s.insertItem(new ItemType(8));
        // s.insertItem(new ItemType(10));
        // s.insertItem(new ItemType(12));
        // s.insertItem(new ItemType(20));
        System.out.println("Just created and add elements to another SLL object called t");
        SortedLinkedList h = s.merge(t);
        NodeType temp = h.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("The length of the list should now be 10 " + h.getLength());
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("Testing with duplicate values to merge");
        SortedLinkedList u = new SortedLinkedList();
        u.insertItem(new ItemType(1));
        u.insertItem(new ItemType(3));
        u.insertItem(new ItemType(5));
        u.insertItem(new ItemType(8));
        u.insertItem(new ItemType(10));
        u.insertItem(new ItemType(12));
        u.insertItem(new ItemType(20));
        System.out.println("Just created first SLL u object");
        SortedLinkedList v = new SortedLinkedList();
        v.insertItem(new ItemType(7));
        v.insertItem(new ItemType(10));
        v.insertItem(new ItemType(20));
        // v.insertItem(new ItemType(24));
        System.out.println("Just created and add elements to another SLL object called v");
        h = u.merge(v);
        temp = h.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("The length of the list should now be 8 " + h.getLength());
        System.out.println("Testing with duplicate values to merge");
    } //testSortedLinkedListMerge

    //Test the interesction method later.
    /**
     * This method will test the interesction method for any SortedlinkedList object.
     */
    public static void testIntersection() {
        System.out.println("Inside testIntersection method****");
        SortedLinkedList u = new SortedLinkedList();
        u.insertItem(new ItemType(1));
        u.insertItem(new ItemType(3));
        u.insertItem(new ItemType(5));
        u.insertItem(new ItemType(8));
        u.insertItem(new ItemType(10));
        u.insertItem(new ItemType(12));
        u.insertItem(new ItemType(20));
        System.out.println("Just created first SLL u object");
        SortedLinkedList w = new SortedLinkedList();
        w.insertItem(new ItemType(7));
        w.insertItem(new ItemType(8));
        w.insertItem(new ItemType(34));
        // w.insertItem(new ItemType(10));
        System.out.println("Just created the other SLL w object");
        SortedLinkedList a = u.intersection(w);
        /**
         * So in driver, if there is a null value for the SLL return value
         * then print no interesction of lists. */
        NodeType temp = a.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        NodeType temp2 = u.getHead();
        while (temp2 != null) {
            System.out.println(temp2.info.getValue());
            temp2 = temp2.next;
        }

    } //testIntersection
    /**
     * This method will test the deleteAlt method for any SortedLinkedList object.
     */

    public static void testDeleteAlt() {
        System.out.println("*****Inside testDeleteAlt method*****");
        System.out.println("Testing if we try to deleteATL when the list is empty");
        SortedLinkedList s = new SortedLinkedList();
        s.deleteAlt();
        s.insertItem(new ItemType(1));
        s.deleteAlt();
        System.out.println("Testing when list only has 1 node in it");
        NodeType temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("Testing when list only has 2 nodes in it");
        s.insertItem(new ItemType(10));
        s.deleteAlt();
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
        System.out.println("Genral case testing with even length now");
        s.insertItem(new ItemType(3));
        s.insertItem(new ItemType(5));
        s.insertItem(new ItemType(8));
        s.insertItem(new ItemType(10));
        s.insertItem(new ItemType(12));
        s.insertItem(new ItemType(20));
        s.insertItem(new ItemType(22));
        s.insertItem(new ItemType(23));
        s.deleteAlt();
        temp = s.getHead();
        while (temp != null) {
            System.out.println(temp.info.getValue());
            temp = temp.next;
        }
    } //testDeleteAlt
} //Tester
