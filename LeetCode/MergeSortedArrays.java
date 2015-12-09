//http://oj.leetcode.com/problems/merge-sorted-array/
public class MergeSortedArrays {
    public void merge(int A[], int m, int B[], int n) {
        int ind = m+n-1;
        while(n > 0){
            if(m > 0 && A[m-1] > B[n-1])
                A[ind--] = A[--m];
            else{
                A[ind--] = B[--n];
            }
        }
        return;
    }
}
