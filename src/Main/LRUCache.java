package Main;

import java.io.*;
import java.util.*;

/* Least Recently Used element 
 * get() returns the most recently used element
 * put() adds the element to cache
 * remove() removes the given element.
 * */

// Implement using LL and HashMap.

// LLNode class
class LLNode {
	int val;
	LLNode next;
	LLNode prev;
	
	public LLNode() {
		this.val = 0;
	}
	
	public LLNode(int a) {
		this.val = a;
	}
}

// Doubly LinkedList class
class LinkedList {
	LLNode head = new LLNode();
	LLNode tail = new LLNode();
	
	public LinkedList() {
		head.next = tail;
		tail.prev = head;
	}
	
	// Insert element
	public void Insert (int a) {
		LLNode tmp = new LLNode(a);
		if (this.head.next == this.tail) {
			this.head.next = tmp;
			this.tail.prev = tmp;
		} else {
			this.head.next.prev = tmp;
			this.head.next = tmp;
		}
	}
	
	public void DeleteLeastRecent () {
		this.tail.prev.prev.next = this.tail;
		this.tail.prev = this.tail.prev.prev;
	}
	
	public void DeleteElement (int a) {
		LLNode search = this.head;
		while (search.val != a) {
			search = search.next;
		}
		LLNode prevv = search.prev;
		LLNode nextt = search.next;
		prevv.next = nextt;
		nextt.prev = prevv;
	}
	
	// Get Element
	public LLNode GetElement (int a) {
		LLNode search = this.head;
		while (search.val != a) {
			search = search.next;
		}
		this.DeleteElement(a);
		this.Insert(search.val);
		return search;
	}
}

public class LRUCache {
	
	private int size;
	private LinkedList ll;
	private HashMap<Integer, Integer> hash = new HashMap<>();
	
	
}
