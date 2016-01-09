public class Solution {
    int MAX  = 26;
	boolean isAnagram(int []count1, int []count2) {
	    for(int i = 0; i < MAX; i++) {
	        if(count1[i] != count2[i])
	            return false;
	    }
	    return true;
	}

	public int findPair(String s1, String s2){
		int cnt = 0;
		int [] count1 = new int[MAX];
		int [] count2 = new int[MAX];
		for(int i = 0; i < s1.length(); i++){
			count1[(int)(s1.charAt(i) - 'a')]++;
			count2[(int)(s2.charAt(i) - 'a')]++;
		}
		cnt += isAnagram(count1, count2) ? 1 : 0;
		for(int i = s1.length(); i < s2.length(); i++){
			count2[s2.charAt(i-s1.length())-'a']--;
			count2[s2.charAt(i)-'a']++;
			cnt += isAnagram(count1, count2) ? 1 : 0;
		}
		return cnt;
	}
	int countPairs(String str) {
	    int n = str.length();
	    if(n < 2) {
	        return 0;
	    }

	    int cnt = 0;
	    for(int i = 0; i < n; i++) {
	        for(int j = i+1; j <= n; j++) {
	        	if(j-i > n-(i+1))
	        		break;
	        	String s1 = str.substring(i, j);
	        	String s2 = str.substring(i+1);
	            cnt += findPair(s1, s2);
	        }
	    }
	    return cnt;
	}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        Solution solution = new Solution();
        for(int i = 0; i < T; i++){
            System.out.println(solution.countPairs(scanner.nextLine()));
        }
        scanner.close();
    }
}
