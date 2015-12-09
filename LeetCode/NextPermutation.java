//http://oj.leetcode.com/problems/next-permutation/
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length < 2)
            return;
        int ind = -1;
        for(int i = num.length-2; i >= 0; i--){
            if(num[i] < num[i+1]){
                ind = i;
                break;
            }
        }
         if(ind == -1){
            reverse(num, 0, num.length-1);
        }
        else{
            int ind2 = ind+1;
            int min = num[ind2];
            for(int i = ind+2; i< num.length; i++){
                if(num[i] <= min && num[i] > num[ind]){
                    ind2 = i;
                    min = num[i];
                }
            }
            //swap
            num[ind] += num[ind2];
            num[ind2] = num[ind] - num[ind2];
            num[ind] -= num[ind2];
            reverse(num, ind+1, num.length-1);
        }
    }
    
    public void reverse(int [] num, int st, int end){
        int i = st;
        int j = end;
        while(i < j){
            num[i] += num[j];
            num[j] = num[i] - num[j];
            num[i++] -= num[j--];
        }
    }
}