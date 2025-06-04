package LinkedList;

import java.util.LinkedList;

public class SingleLinkedListTest {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedlist(int nodeValue){
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    LinkedList<String> lit = new LinkedList<>();

    //Insert Method
    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null){
            createSingleLinkedlist(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size){
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traversing through a linked list

    public void traverseLinkedList(){
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    //Search for an element
    public boolean searchNode(int nodeValue){
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.value == nodeValue) {
                    System.out.print("Found the node at location: " +i+"\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("Node not found");
        return false;
    }

    //implement deleting a node from single linked list
        public static void main(String[] args) {
            SingleLinkedList list = new SingleLinkedList();

            // Insert some test values
            list.insert(10);
            list.insert(20);
            list.insert(30);
            list.insert(40);
            list.insert(50);

            System.out.println("Original List:");
            list.display(); // Should show: 10 -> 20 -> 30 -> 40 -> 50

            // Test deleting from the beginning
            System.out.println("\nDelete position 0 (head):");
            list.delete(0);
            list.display(); // Should show: 20 -> 30 -> 40 -> 50

            // Test deleting from the middle
            System.out.println("\nDelete position 1 (middle):");
            list.delete(1);
            list.display(); // Should show: 20 -> 40 -> 50

            // Test deleting from the end
            System.out.println("\nDelete last position:");
            list.delete(2);
            list.display(); // Should show: 20 -> 40

            // Test deleting with invalid index
            System.out.println("\nDelete invalid position (e.g., 10):");
            list.delete(10); // Should print: Invalid position

            // Final state of the list
            System.out.println("\nFinal List:");
            list.display(); // Should show: 20 -> 40
        }
    }

