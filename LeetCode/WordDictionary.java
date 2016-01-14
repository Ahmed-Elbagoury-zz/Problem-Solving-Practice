public class WordDictionary {
    Trie trie = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.search(word);
    }
}


class TrieNode {
    // Initialize your data structure here.
    int words;
    int prefixes;
    TrieNode[] edges;
    public TrieNode() {
        words = 0;
        prefixes = 0;
        edges = new TrieNode[(int)('z' - 'a' + 1)];
    }
}

class Trie {
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
        if(ind == word.length()){
            curNode.words++;
            return;
        }
        char curChar = word.charAt(ind);    
        TrieNode edge = curNode.edges[(int) (curChar - 'a')];
        if(edge == null){
        	curNode.edges[(int) (curChar - 'a')] = new TrieNode();
        	edge = curNode.edges[(int) (curChar - 'a')];
        }
        edge.prefixes ++;
        insert(word, ind+1, edge);
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
        if(curChar != '.'){
            TrieNode edge = curNode.edges[(int) (curChar - 'a')];
            if(edge == null)
                return false;
            return search(word, ind+1, edge);    
        }
        else{
            for(TrieNode edge : curNode.edges){
                if(edge == null)
                    continue;
                boolean result = search(word, ind+1, edge);
                if(result)
                    return true;
            }
            return false;
        }
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
	    TrieNode edge = curNode.edges[(int) (curChar - 'a')];
	    if(edge == null)
	        return false;
	    return startsWith(word, ind+1, edge);    
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
