public class PascalTriangle2{
	public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0)
            return new LinkedList<Integer>();
        List<Integer> curList = new LinkedList<Integer>();
        List<Integer> prevList = new LinkedList<Integer>();
        prevList.add(1);
        if(rowIndex == 0)
            return prevList;
        for(int i = 1; i <= rowIndex; i++){
            curList = new LinkedList<Integer>();
            curList.add(1);
            for(int j = 1; j < i; j++)
                curList.add(prevList.get(j) + prevList.get(j-1));
            curList.add(1);
            prevList = curList;
        }
        return curList;
    }

}