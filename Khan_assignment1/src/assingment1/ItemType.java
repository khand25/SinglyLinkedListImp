package assingment1;

/**
 * This class will be used to store int actual values inside of the
 * linked list. */
public class ItemType {
    private int value;

    /**
     * The constructor of this class that sets intial values to all
     * instance varaibles for an ItemType object.
     * @param value indicating the value passed in for the element int
     * value to store in the linked list.*/
    public ItemType(int value) {
        this.value = value;
    }

    /**
     * Getter method use to return the value of the instace varaible: value.
     * @return value.*/
    public int getValue() {
        return value;
    }

    /**
     * Setter method used to set the value of the instance varabile: value.
     * @param value indicating the value passed in to change for.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * compareTo method that checks if two ItemType objects are well in fact storing the same value
     * instance or not. This method will be used to search through a linked list.
     * @param item representing the other ItemType object to comapre with,
     * @return -1 if the calling object is less than the other object, 0 if they are the same,
     * and 1 if the calling object is bigger than the incoming object.
     * */
    public int compareTo(ItemType item) {
        if (this.value < item.value) {
            return -1;
        } else if (this.value == item.value) {
            return 0;
        } else {
            return 1;
        }
    }


} //ItemType
