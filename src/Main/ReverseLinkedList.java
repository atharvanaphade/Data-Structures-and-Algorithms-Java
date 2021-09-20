package Main;

import java.io.*;
import java.util.*;

/**
 * Reverse Linked List.
 * 
 * @author atharvanaphade
 *
 */

public class ReverseLinkedList {
	class LinkedListNode {
		public int val;
		public LinkedListNode next;
	}
	
	public static void main (String[] args) throws IOException {
		;
	}
	
	/*
	 * Time : O(N) Time
	 * Space : O(1) Space
	 * 
	 * @param head
	 */
	public static void Solution (LinkedListNode head) {
		LinkedListNode p1 = null, p2 = head;
		while (p2 != null) {
			LinkedListNode p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
	}
}
