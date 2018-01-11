class Solution {
//Fisher-Yates Algorithm
    int [] original;
    int [] arr;
    Random random;
    public Solution(int[] nums) {
        this.original = nums.clone();
        this.arr = nums.clone();
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.arr = this.original.clone();
        return this.arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int index = random.nextInt(n - i) + i;
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
 
 class Solution2 {
    int [] original;
    int [] arr;
    Random random;
    public Solution(int[] nums) {
        this.original = nums.clone();
        this.arr = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.arr = this.original.clone();
        return this.arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Set<Integer> chosen = new HashSet<Integer>();
        int n = this.original.length;
        if (n == 0){
            return new int [] {};
        }
        int [] copy = arr.clone();
        int counter = 0;
        int index = random.nextInt(n);
        while(counter < n){
            while(chosen.contains(index)){
                index = random.nextInt(n);
            }
            arr[counter++] = copy[index];
            chosen.add(index);
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
