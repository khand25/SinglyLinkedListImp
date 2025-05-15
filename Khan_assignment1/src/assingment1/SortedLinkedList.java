package assingment1;

/**
 * This class defines all of the functionalities that a SortedLinkedList can perfrom
 * and do when the methods are called upon from the calling object from this class.*/
public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int numberOfNodes; //used to record the number of nodes in the list
    // Should only be updated whenever we add or remove items from the list
    private int numberOfTimesGetNext;

    /**
     * Constructor for SortedLinkedList class and sets intial values
     * to all instance varaibles from this class when an object of type
     * SortedLinkedList is created.
     **/
    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
        this.numberOfNodes = 0;
        this.numberOfTimesGetNext = 0;
    }

    /**
     * getter method to return the total numberOfNodes in the linked list.
     * @return numberOfNodes indicating the total number of nodes in the
     * linked list.*/
    public int getLength() {
        return this.numberOfNodes;
    }

    /**
     * getter methof to return the head instance varaible value of the calling object
     * when called.
     * @return head which is the calling object's unique copy instance varaible that we wish to
     * return.*/
    public NodeType getHead() {
        return this.head;
    }

    /**
     * Method that is used to check if there is a duplicate value that
     * matches the item param. This method will be used in merge, intersection, and insert.
     * @param item indicating the ItemType value that we wish to check for.
     * @return true if we do find a match with the ItemType param thus indicating a duplicate
     * value is present in the calling objects LinkedList
     * return false otherwise.*/
    private boolean checkDuplicates(ItemType item) {
        NodeType temp = this.head;
        while (temp != null) {
            if (temp.info.compareTo(item) == 0) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    } //checkDuplicates

    /**
     * This method is responsible for letting ItemType values to be added to a linked list.
     * @param item representing the item to add to the list.*/
    public void insertItem(ItemType item) {
        //Handles if there is no nodes currently in the list
        if (this.head == null) {
            NodeType newNode = new NodeType(item,null);
            this.head = newNode;
            this.numberOfNodes++;
            return;
        }
        //Calles helepr method to see if there are duplicates in the list
        if (checkDuplicates(item) == true) {
            System.out.println("Item already exists");
            return;
        }
        //Handles if the lement to add is in the first node.
        NodeType newNodeToAdd = new NodeType(item,null);
        if (this.head.info.compareTo(item) == 1) {
            newNodeToAdd.next = head;
            head = newNodeToAdd;
            numberOfNodes++;
            return;
        }

        //General case
        NodeType afterLoc = head;
        while (afterLoc != null && afterLoc.info.compareTo(item) == -1) {
            afterLoc = afterLoc.next;
        }
        NodeType prevLoc = head;
        while (prevLoc.next != afterLoc) {
            prevLoc = prevLoc.next;
        }
        newNodeToAdd.next = afterLoc;
        prevLoc.next = newNodeToAdd;
        numberOfNodes++;

    } //insertItem

    /**
     * This method be used for the merge method to insertItems inside of the calling
     * objects LinkedList. The only diffrence between this mergeinsert method and
     * the normal insertItem method is that duplicate values, if present, will not print out
     * the print statement.
     * @param item which will hold the value that the user would like to merge onto the list.*/
    private void mergeInsertItem(ItemType item) {
        //Handles if there is no nodes currently in the list
        if (this.head == null) {
            NodeType newNode = new NodeType(item,null);
            this.head = newNode;
            this.numberOfNodes++;
            return;
        }
        //Calles helepr method to see if there are duplicates in the list
        if (checkDuplicates(item) == true) {
            // System.out.println("Sorry. You cannot insert the duplicate item");
            return;
        }
        //Handles if the lement to add is in the first node.
        NodeType newNodeToAdd = new NodeType(item,null);
        if (this.head.info.compareTo(item) == 1) {
            newNodeToAdd.next = head;
            head = newNodeToAdd;
            numberOfNodes++;
            return;
        }

        //General case
        NodeType afterLoc = head;
        while (afterLoc != null && afterLoc.info.compareTo(item) == -1) {
            afterLoc = afterLoc.next;
        }
        NodeType prevLoc = head;
        while (prevLoc.next != afterLoc) {
            prevLoc = prevLoc.next;
        }
        newNodeToAdd.next = afterLoc;
        prevLoc.next = newNodeToAdd;
        numberOfNodes++;

    } //mergeInsertItem

    /**
     * This method is used to search if the given element that is wished to be
     * deletted is actually present in the list. And if it is, its NodeType memroy adress is
     * returned so it can be refreced and dleeted later on in the delet method.
     * @param item which will represent the ItemType object that we wish to delete.
     * @return temp if we do have a match and null otherwise.*/
    private NodeType searchForDelete(ItemType item) {
        NodeType temp = this.head;
        while (temp != null) {
            if (temp.info.compareTo(item) == 0) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    } //searchForDelete

    /**
     * Method that will be used to delete the specifced NodeType memroy address when called
     * upon by the calling object.
     * @param item representing the ItemType object that is wished to be deleted.*/
    public void deleteItem(ItemType item) {
        //Handles if we try to delete from empty list
        if (this.head == null) {
            System.out.println("You cannot delete from a empty list");
            throw new IllegalStateException();
            // return;
        }
        NodeType foundItem = searchForDelete(item);
        //Handles if the item to delete is not in the list.
        if (foundItem == null) {
            System.out.println("The item is not present in the list");
            return;
        }
        //Special case if to delete only element
        if (numberOfNodes == 1) {
            this.head = null;
            this.numberOfNodes--;
            return;
        }

        //Deleting only the first element
        if (foundItem == head) {
            this.head = head.next;
            this.numberOfNodes--;
            return;
        }
        //General case
        NodeType afterLoc = foundItem.next;
        NodeType prevLoc = this.head;
        while (prevLoc.next != foundItem) {
            prevLoc = prevLoc.next;
        }
        prevLoc.next = afterLoc;
        foundItem.next = null;
        this.numberOfNodes--;
    } //deleteItem

    /**
     * Method that will be used to search for a specifc ItemType object if present in the list.
     * @param item indicating the ItemType object that is wished to be found.
     * @return count the index of the location of item. -1 if not present of list is empty.*/
    public int searchItem(ItemType item) {
        //Handles when the calling obejcts linked list is emoty to search
        if (this.head == null) {
            System.out.println("This list is empty");
            return -1;
        }
        //Handles if the linked list to search only has 1 node object
        if (this.numberOfNodes == 1) {
            // If there is in fact the element present in the list of length 1
            if (head.info.compareTo(item) == 0) {
                return 1;
            } else {
                System.out.println("Item is not present in the list");
                return -1;
            }
        }
        //General case
        NodeType temp = this.head;
        int count = 0;
        while (temp != null) {
            count++;
            if (temp.info.compareTo(item) == 0) {
                return count;
            }
            temp = temp.next;
        }
        System.out.println("Item is not present in the list");
        return -1;
    } //searchItem

    /**
     * Getter methof that returns the getNumberOfTimesGetNext instacne varaible value.
     * @return numberOfTimesGetNext returning this int value to be used in the getnext item methof*/
    public int getNumberOfTimesGetNext() {
        return this.numberOfTimesGetNext;
    }
    /**
     * Method that is an iterator and will go through the next spot in the Linked List when
     * called upon.
     * @return currentPos.info which will be the ItemType value at the next spot in the list.*/

    public ItemType getNextItem() {
        /* Big if else condition that will determine if there is still ItemType objects
        * in the list to circulate too or not.*/

        //Handles if list is empty
        if (this.head == null) {
            System.out.println("The list is empty");
            this.numberOfTimesGetNext = 0;
            return null;
        }
        this.numberOfTimesGetNext++;
        if (this.numberOfTimesGetNext <= this.numberOfNodes) {
            //Handles if the list is empty
            /* if (this.head == null) {
                System.out.println("List is empty");
                return null;
                }
                this.numberOfTimesGetNext++; */
            //Handles first time trying getNextItem function
            if (this.currentPos == null) {
                this.currentPos = head;
                return currentPos.info;
            } else {
                this.currentPos = currentPos.next;
                return currentPos.info;
            }
        } else {
            System.out.println("End of the list has reached");
            return null;
        }
    } //getNextItem

    /**
     * Resets the currentPos varaible to a null space in memory to reset the iterator.
     */
    public void resetList() {
        this.currentPos = null;
        this.numberOfTimesGetNext = 0;
    }

    /**
     * This method for merge, takes in another SortedLinkedList object as a parameter
     * and uses a temp variable to traverse that params linked list and pull out the values of the
     * info referce varaibles whtin the NodeType memoery adresses and addes it to the calling
     * object's linked list. Note, this this method uses an updated mergeInsertItem method call
     * instead of the standard insertItem method as then if there is duplicates, no print
     * message will be printed.
     * @param sLL representing the other SortedLinkedList object to take the
     * value instace varabiles from and add it to the calling object ones.
     * @return newList which will have the merged up list values from the calling object
     * nad the input param sLL*/
    // Complexity of merge is O(n)
    public SortedLinkedList merge(SortedLinkedList sLL) {
        SortedLinkedList newList = new SortedLinkedList();
        NodeType temp2 = this.head;
        while (temp2 != null) {
            newList.insertItem(temp2.info);
            temp2 = temp2.next;
        }
        NodeType temp = sLL.getHead();
        while (temp != null) {
            newList.mergeInsertItem(temp.info);
            // this.mergeInsertItem(temp.info);
            temp = temp.next;
        }
        return newList;

    } //merge

    /**
     * This method is used to return a newlist that is the intersection of calling
     * objects list, and the new list as well. The logic uses the checkDuplicates method
     * and will only add the duplicate values between both the lists in the new list.
     * @param sLL which will be the new list entered in to try to find the interersction
     * will the calling object with.
     * @return newList which will be the intersection of the two lists and null otherwise
     * if there is no interesecting values between the two lists.*/
    // Complexity of intersection is O(n)
    public SortedLinkedList intersection(SortedLinkedList sLL) {
        SortedLinkedList newList = new SortedLinkedList();
        NodeType temp = sLL.getHead();
        while (temp != null) {
            if (this.checkDuplicates(temp.info) == true) {
                newList.insertItem(temp.info);
            }
            temp = temp.next;
        }
        if (newList.head != null) {
            return newList;
        } else {
            return null;
        }
    } //interesection

    /**
     * Method that only delets the even index node in the linked list. Hence this is the
     * alternate node on the list.*/
    // Complexity of deleteAlt is O(n)
    public void deleteAlt() {
        //Handles if the list is currently empty
        if (this.head == null) {
            System.out.println("The list is empty");
        }

        //Handles if there is only one node in the list
        if (this.numberOfNodes == 1) {
            return;
        }
        //Handles if there are only two nodes in the list
        if (this.numberOfNodes == 2) {
            NodeType temp = this.head;
            this.deleteItem(temp.next.info);
            return;
        }
        //General case
        NodeType temp = this.head;
        //created count varaible to keep track of current index value in list.
        int count = 0;
        while (temp != null) {
            count++;
            if (count % 2 == 0) {
                ItemType copy = temp.info;
                temp = temp.next;
                this.deleteItem(copy);
            } else {
                temp = temp.next;
            }
        }

    } //deleteAlt
} //SortedLinkedList
