package Main;

import java.io.*;
import java.util.*;

// Suffix Trie implementation.

public class SuffixTrie {
	private final TrieNode root;
	public SuffixTrie () {
		root = new TrieNode();
	}
	
	public void Insert (String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.end = true;
	}
	
	public void Helper (TrieNode current, String word, int idx) {
		if (idx == word.length()) {
			current.end = true;
			return;
		}
		char ch = word.charAt(idx);
		TrieNode node = current.children.get(ch);
		
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}
		Helper(node, word, idx + 1);
	}
	
	public void RecursiveInsert (String word) {
		Helper (root, word, 0);
	}
	
	public boolean Search (String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.end;
	}
	
	public void Delete (String word) {
		Delete(root, word, 0);
	}
	
	public boolean Delete (TrieNode current, String word, int idx) {
		if (idx == word.length()) {
			if (!current.end) {
				return false;
			}
			current.end = false;
			return current.children.size() == 0;
		}
		char ch = word.charAt(idx);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean toDelete = Delete(node, word, idx + 1);
		
		if (toDelete) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}
}
