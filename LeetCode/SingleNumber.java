//http://oj.leetcode.com/problems/single-number/
public class SingleNumber {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) return 0;
        HashSet<Integer> set = new HashSet<Integer> ();
        int sum = 0;
        for(int elem : A){
            if(set.contains(elem)){
                sum -= elem;
            }
            else{
                sum += elem;
                set.add(elem);
            }
        }
        return sum;
    }

    public int singleNumberNoExtraSpace(int[] A) {
        if(A == null || A.length == 0) return 0;
        int result = 0;
        for(int elem : A){
            result ^= elem;
        }
        return result;
    }

}
