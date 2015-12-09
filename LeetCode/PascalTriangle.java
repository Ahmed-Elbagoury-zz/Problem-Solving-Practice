//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle{
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new LinkedList<List<Integer>>();
        if(numRows <= 0)
            return sol;
        List<Integer> prevList = new LinkedList<Integer>();
        prevList.add(1);
        sol.add(prevList);
        for(int i = 1; i < numRows; i++){
            List<Integer> curList = new LinkedList<Integer>();
            curList.add(1);
            for(int j = 1; j < i; j++){
                curList.add(prevList.get(j) + prevList.get(j-1));
            }
            curList.add(1);
            sol.add(curList);
            prevList = curList;
        }
        return sol;
    }

}