package Main;

import java.io.*;
import java.util.*;

// Abstract class for Suffix Trie Node.

public class TrieNode {
	Map<Character, TrieNode> children;
	boolean end;
	public TrieNode () {
		children = new HashMap<>();
		end = false;
	}
}
