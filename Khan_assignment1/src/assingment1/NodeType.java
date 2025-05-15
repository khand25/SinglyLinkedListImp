package assingment1;

/**
 * NodeType class that will be used to create the nodes for a linked
 * list.*/
public class NodeType {

    public ItemType info;
    public NodeType next;

    /**
     * Constructor for NodeType class.
     * @param item indidcating the info instance varaible to referece
     * the same space in memory as the other ItemType object being passed
     * in when an object from the NodeType is created.
     * @param next indicating the next instance varaible to reference the
     * same space in memeory as the other Nodetype object being passed
     * in when an object from the NodeType is created.*/
    public NodeType(ItemType item, NodeType next) {
        this.info = item;
        this.next = next;
    }
} //NodeType
