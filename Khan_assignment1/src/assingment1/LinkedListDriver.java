package assingment1;

import java.io.*;
import java.util.Scanner;
/**
 * Command-line application driver class that provides the user with
 * multiple options of to manipulate a Linked List data structure.
 */

public class LinkedListDriver {
    public static void main(String[] args) {
        SortedLinkedList originalList = new SortedLinkedList();
        readInfoFile(args[0],originalList);
        // printList(originalList);
        printPossibleCommands();
        userControlledList(originalList);

    } //main
    /**
     * This method prints out the ItemType info value's througout
     * the main SortedLinkedList object orginal list that is being
     * passed in as a parameter so that the user can see the values
     * updated on the list.
     * @param sLL being assigned to the argument orginalLinkedList object
     * being passed in to print the values from.
     * @return result which is a String represention of the item values.*/

    public static String printList(SortedLinkedList sLL) {
        // Temp varaible created to referece the sLL head's space in memory at the start
        NodeType temp = sLL.getHead();
        /**
         * Loop used to traverse through the LinkedList of sLL and print out the values
         * of the ItemType info objects*/
        String result = "";
        while (temp != null) {
            result = result + " " + temp.info.getValue();
            temp = temp.next;
        }
        // System.out.println();
        return result;
    } //printList

    /**
     * This method reads and inserts the numbers within the input.txt file,
     * that is being passed in via the command line, and adds them to the orginal
     * linked list object.
     * @param fileName which stores args[0] value which holds the input.txt file location
     * in my computer.
     * @param sLL being assinged to the argument orginalList object being passed in
     * in to print the values from.*/
    public static void readInfoFile(String fileName,SortedLinkedList sLL) {
        try {
            Scanner reader = new Scanner(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int x = reader.nextInt();
                //Adds read values to sLL object.
                sLL.insertItem(new ItemType(x));
            }
            reader.close();
        } catch (IOException io) {
            io.printStackTrace();
            System.out.println("Not able to read and open the input file correctly");
            System.out.println("Please retry command line input file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some sort of excpetion has occured!");
        }

    } //readInfoFile

    /**
     * This method prints out the possible commands that the user can try to do to update
     * the SortedLinkedList object.
     */
    public static void printPossibleCommands() {
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(n) - Print next iterator value");
        System.out.println("(r) - Reset iterator");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");
        System.out.println();
        System.out.println();
    } //printPossibleCommands
    /**
     * This method will be responsible of taking the very first user input from the user and
     * direct the user to the apporiate command afterwards. If the user decides to quit the program
     * in the begininng, the program will exit.
     * @param originalList representing the originalList that will be modified by the user.*/

    public static void userControlledList(SortedLinkedList originalList) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a command: ");
        String userInput = scan.next();
        //Handles case if user intially wants to exit the program
        if (userInput.equals("q")) {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
        continousUserInput(userInput,originalList);

    } //userControlledList

    /**
     * this method is the main interaction with the user asking for various input commands and
     * perfoming those specifced commands on the SortedLinkedList as follows. Invalid and empty
     * lists will be handled correclty.
     * @param userInput which will hold the user entered command to modify the list.
     * @param originalList which will be assinged to the SortedLinkedList argument coming in
     * and those affecting the main linked list.*/

    private static void continousUserInput(String userInput, SortedLinkedList originalList) {
        Scanner scan = new Scanner(System.in);
        while (!userInput.equals("q")) {
            // Big multibranch if else statement used for all possible commands
            if (userInput.equals("p")) {
                //Calls helper method to print the contents of the list
                System.out.println("The list is: " + printList(originalList));
            } else if (userInput.equals("l")) {
                System.out.println("The length of the list is " + originalList.getLength());
            } else if (userInput.equals("i")) {
                System.out.print("Enter a number to insert: ");
                int userItemToEnter = scan.nextInt();
                System.out.println("Original list : " + printList(originalList));
                originalList.insertItem(new ItemType(userItemToEnter));
                System.out.println("New List : " + printList(originalList));
            } else if (userInput.equals("d")) {
                System.out.print("Enter a number to delete: ");
                int userDeleteItem = scan.nextInt();
                System.out.println("Original list : " + printList(originalList));
                // Try catch block used to catch ISE Excpetion when thrown beacause of empty list
                try {
                    originalList.deleteItem(new ItemType(userDeleteItem));
                    System.out.println("New list : " + printList(originalList));
                } catch (IllegalStateException ise) {
                    System.out.print("");
                }
            } else if (userInput.equals("s")) {
                System.out.print("Enter a number to search: ");
                int userItemToSearch = scan.nextInt();
                System.out.println("Original list : " + printList(originalList));
                int index = originalList.searchItem(new ItemType(userItemToSearch));
                if (index != -1) {
                    System.out.println("The item is present at index " + index);
                } else {
                    //Nothing is printed cause the printed output is already coming from search item
                    System.out.print("");
                }
            } else if (userInput.equals("r")) {
                originalList.resetList();
                System.out.println("Iterator is reset");
            } else if (userInput.equals("n")) {
                ItemType iteratedValue = originalList.getNextItem();
                // We don't want to acess a null space in memery when the end of the list is reached
                if (iteratedValue != null) {
                    System.out.println(iteratedValue.getValue());
                } else {
                    // originalList.getNextItem();
                    System.out.print("");
                }
            } else if (userInput.equals("a")) {
                System.out.println("Original list: " + printList(originalList));
                originalList.deleteAlt();
                //If condition used to check wheter to print new list or modifed when it is empty
                if (originalList.getHead() != null) {
                    System.out.println("New list: " + printList(originalList));
                } else {
                    System.out.println("Modified list:");
                }
            } else if (userInput.equals("m")) {
                System.out.print("Enter the length of the new list: ");
                int length = scan.nextInt();
                System.out.print("Enter the numbers: ");
                int numbers;
                // Creates a new SortedLinkedList object that will hold the new list
                SortedLinkedList list2 = new SortedLinkedList();
                // Loop that will contiue to ask for numbers to add to new list.
                // These new numbers will to the new list and will not
                // contiue to add after the given length of numbers put
                // in the user is reached.
                for (int count = 1; count <= length; count++) {
                    numbers = scan.nextInt();
                    list2.insertItem(new ItemType(numbers));
                }
                System.out.println("List 1: " + printList(originalList));
                System.out.println("List 2: " + printList(list2));
                SortedLinkedList mergedList =  originalList.merge(list2);
                System.out.println("Merged list: " + printList(mergedList));

            } else if (userInput.equals("t")) {
                System.out.print("Enter the length of the new list: ");
                int length = scan.nextInt();
                System.out.print("Enter the numbers: ");
                int numbers;
                // Creates a new SortedLinkedList object that will hold the new list
                SortedLinkedList list2 = new SortedLinkedList();
                // Loop that will contiue to ask for numbers to add to new list.
                // These new numbers will to the new list and will not
                // contiue to add after the given length of numbers put
                // in the user is reached.
                for (int count = 1; count <= length; count++) {
                    numbers = scan.nextInt();
                    list2.insertItem(new ItemType(numbers));
                }
                System.out.println("List 1: " + printList(originalList));
                System.out.println("List 2: " + printList(list2));
                SortedLinkedList intersectedList =  originalList.intersection(list2);
                // System.out.println("Reached here");
                if (intersectedList != null) {
                    System.out.println("Intersection of lists: " + printList(intersectedList));
                } else {
                    // System.out.println("Reached here");
                    System.out.println("Intersection of lists:");
                }
            } else {
                System.out.print("Invalid command try again: ");
                userInput = scan.next();
                /**continue statement used to skip "Enter a comand" line
                   below when the user enters an invalid token */
                continue;
            }
            // break;
            //Asking for new user input in each iteration
            System.out.println();
            System.out.print("Enter a command: ");
            userInput = scan.next();


        }
        //Program exits when the user hits the q command
        System.out.println("Exiting the program....");
        System.exit(0);

    } //continousUserInput

} //LinkedListDriver
