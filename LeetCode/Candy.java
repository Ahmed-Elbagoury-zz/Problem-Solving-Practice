//https://leetcode.com/problems/candy/
public class Candy{
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int [] candiesl = new int [ratings.length];
        candiesl[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1])
                candiesl[i] = candiesl[i-1] + 1;
            else
                candiesl[i] = 1;
        }
        int [] candiesr = new int [ratings.length];
        candiesr[ratings.length-1] = 1;
        int result = Math.max(candiesl[ratings.length-1], candiesr[ratings.length-1]);
        for(int i = candiesr.length -2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                candiesr[i] = candiesr[i+1] + 1;
            else
                candiesr[i] = 1;
            result += Math.max(candiesr[i], candiesl[i]);
        }
        return result;
    }

}