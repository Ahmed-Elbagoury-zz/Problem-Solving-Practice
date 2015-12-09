//https://leetcode.com/problems/word-ladder/
public class WordLadder{
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue <Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord, 1));
        wordList.add(endWord);
        while(queue.size() != 0){
            Node cur = queue.remove();
            char [] arr = cur.str.toCharArray();
            //Push all the neighbors
            for(int i = 0; i < arr.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    arr = cur.str.toCharArray();
                    arr[i] = c;
                    String str = new String(arr);
                    if(str.compareTo(endWord) == 0)
                        return cur.step + 1;
                    if(wordList.contains(str)){
                        queue.add(new Node(str, cur.step + 1));
                        wordList.remove(str);
                    }
                }
            }
        }
        return 0;
    }

    class Node{
    String str;
    int step;
    public Node(String str, int step){
        this.str = str;
        this.step = step;
    }
}