//http://oj.leetcode.com/problems/single-number-ii/
public class SingleNumber2 {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int elem: A){
            if(map.containsKey(elem)){
                if(map.get(elem) == 2){
                    map.remove(elem);
                }
                else{
                    map.put(elem, map.get(elem)+1);
                }
            }
            else{
                map.put(elem, 1);
            }
        }
        return map.keySet().iterator().next();
    }
}
