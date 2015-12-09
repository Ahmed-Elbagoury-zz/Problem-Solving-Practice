public class SortColors{
	//Two pass algorithm
	public void sortColors(int[] nums) {
        int zeros = 0;
        int ones  = 0;
        int twos = 0;
        
        for(int i = 0; i < nums.length; i++){
            switch(nums[i]){
                case 0: zeros++; break;
                case 1: ones++; break;
                case 2: twos++; break;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(zeros != 0){
                nums[i] = 0;
                zeros--;
            }
            else if(ones != 0){
                nums[i] = 1;
                ones --;
            }
            else{
                nums[i] = 2;
                twos --;
            }
        }
    }
    //One pass algorithm
    public void sortColorsOnePass(int[] nums) {
        int zeroStart = 0;
        int twoStart = nums.length-1;
        int i = 0;
        while(i <= twoStart){
            if(nums[i] == 0){
                nums[i] = nums[zeroStart];
                nums[zeroStart++] = 0;
                i++;
            }
            else if (nums[i] == 2){
                nums[i] = nums[twoStart];
                nums[twoStart--] = 2;
            }
            else{
                i++;
            }
        }
    }

}