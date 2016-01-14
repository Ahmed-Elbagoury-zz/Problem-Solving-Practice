import java.util.LinkedList;
import java.util.List;

public class Solution {
    Set<String> result;
    boolean [][] visited;
    Trie trie;
    char [][] board;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[board.length][board[0].length];
        result = new HashSet<String>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dfs(i, j, n, m, new StringBuilder());
            }
        }
        return new LinkedList<String>(result);
    }
    
    public void dfs(int i, int j, int n, int m, StringBuilder sb){
        if(i == n || j == m || i < 0 || j < 0)
            return;
        if(visited[i][j]){
            return;
        }
        sb.append(board[i][j]);
        
        if(!trie.startsWith(sb.toString())){
        	sb.deleteCharAt(sb.length()-1);
            return;
        }
        
        visited[i][j] = true;    
        if(trie.search(sb.toString())){
            result.add(sb.toString());   
        }
        dfs(i+1, j, n, m, sb);
        dfs(i-1, j, n, m, sb);
        dfs(i, j+1, n, m, sb);
        dfs(i, j-1, n, m, sb);
        
        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);
    }
    
    public static void main(String [] args){
    	Solution solution = new Solution();
    	char [][] board = new char [][] {{'o','a','a','n'},{'e','t','a','e'},{'i', 'h', 'k', 'r'}, {'i','f','l', 'v'}};
    	String []words = new String [] {"oath","pea","eat","rain"};
    	List<String> result = solution.findWords(board, words);
    	for(String string : result)
    		System.out.println(string);
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
            if(curNode.words != 0){
                return true;
            }
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
