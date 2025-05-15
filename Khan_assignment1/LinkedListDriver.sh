#!/bin/bash -ex

javac -d bin src/assingment1/ItemType.java

javac -d bin -cp bin src/assingment1/NodeType.java

javac -d bin -cp bin src/assingment1/SortedLinkedList.java

javac -d bin -cp bin src/assingment1/LinkedListDriver.java

java -cp bin assingment1.LinkedListDriver src/assingment1/input.txt
