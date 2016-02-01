class TrieNode {
    // Initialize your data structure here.
    int words;
    int prefixes;
    TrieNode[] children;
    public TrieNode() {
        words = 0;
        prefixes = 0;
        children = new TrieNode[(int)('z' - 'a' + 1)];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0)
            return;
        insert(word, 0, root);
    }
    
    private void insert(String word, int ind, TrieNode curNode){
        curNode.prefixes++;
        if(ind == word.length()){
            curNode.words++;
            return;
        }
        char curChar = word.charAt(ind);    
        TrieNode nextNode = curNode.children[(int) (curChar - 'a')];
        if(nextNode == null){
        	curNode.children[(int) (curChar - 'a')] = new TrieNode();
        	nextNode = curNode.children[(int) (curChar - 'a')];
        }
        insert(word, ind+1, nextNode);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0)
            return true;
        return search(word, 0, root);    
    }
    
    private boolean search(String word, int ind, TrieNode curNode){
        if(ind == word.length()){
            if(curNode.words != 0)
                return true;
            else
                return false;
        }
        char curChar = word.charAt(ind);
        TrieNode nextNode = curNode.children[(int) (curChar - 'a')];
        if(nextNode == null)
            return false;
        return search(word, ind+1, nextNode);    
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0)
            return true;
        return startsWith(prefix, 0, root);    
    }
    
    public boolean startsWith(String word, int ind, TrieNode curNode){
	    if(ind == word.length()){
	        if(curNode.prefixes != 0)
	            return true;
	        else
	            return false;
	    }
	    char curChar = word.charAt(ind);
	    TrieNode nextNode = curNode.children[(int) (curChar - 'a')];
	    if(nextNode == null)
	        return false;
	    return startsWith(word, ind+1, nextNode);    
    }
    
    public static void main(String[] args){
    	Trie trie = new Trie();
    	trie.insert("ab");
    	System.out.println(trie.search("a"));
    	System.out.println(trie.startsWith("a"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
