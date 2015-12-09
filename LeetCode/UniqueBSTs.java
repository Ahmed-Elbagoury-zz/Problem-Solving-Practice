//https://leetcode.com/problems/unique-binary-search-trees/
//http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-java/
//http://stackoverflow.com/questions/24755059/leetcode-unique-binary-search-trees-calculation
public class UniqueBSTs{
	public int numTrees(int n) {
        int [] trees = new int [n+1];
        trees[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                trees[i] += trees[j] * trees[i-1-j];
            }
        }
        return trees[n];
    }
/*
i=1, count[1]=1 //one tree

i=2, count[2]=count[0]*count[1] // 0 is root
            + count[1]*count[0] // 1 is root

i=3, count[3]=count[0]*count[2] // 1 is root
            + count[1]*count[1] // 2 is root
            + count[2]*count[0] // 3 is root

i=4, count[4]=count[0]*count[3] // 1 is root
            + count[1]*count[2] // 2 is root
            + count[2]*count[1] // 3 is root
            + count[3]*count[0] // 4 is root
*/
}