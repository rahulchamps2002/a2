/**
 * 
 */
package a2;

import static org.junit.Assert.*;

/**
 * Name:
 * Student ID:
 * Description of solution:
 * @author name
 *
 */


public class CycleLinkedList {

	/*This function returns true if given linked 
	list has a cycle, else returns false. */
	public static boolean hasCycle( Node head) {
		return helper(head, head);
	}

	public static boolean helper(Node sNode, Node fNode){
		if(fNode == null || fNode.getNext() == null){
			return false;
		}
		fNode = fNode.getNext();
		if(sNode == fNode){
			return true;
		}

		return helper(sNode.getNext(), fNode.getNext());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node("start");
		Node prev = head;
		for (int i =0; i<4; i++) {
			Node temp = new Node(Integer.toString(i));
			prev.setNext(temp);
			prev=temp;
		}

		boolean b = hasCycle(head);
		System.out.println("Testing...");
		assertEquals(b, false);
		System.out.println("Success!");

		prev.setNext(head.getNext());

		b = hasCycle(head);
		System.out.println("Testing...");
		assertEquals(b, true);
		System.out.println("Success!");

	}

}
