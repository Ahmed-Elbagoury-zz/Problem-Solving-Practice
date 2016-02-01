public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        StringBuilder sb = new StringBuilder();
        int aInd = a.length()-1;
        int bInd = b.length()-1;
        int carry = 0;
        while(aInd >= 0 && bInd >= 0){
            int result = carry + (int)(a.charAt(aInd--) - '0') + (int)(b.charAt(bInd--) - '0');
            carry = result / 2;
            result = result %2;
            sb.append((char)(result + (int) '0'));
        }
        int index;
        String str;
        if(aInd > bInd){
            index = aInd;
            str = a;
        }
        else{
            index = bInd;
            str = b;
        }
        while(index >= 0){
            int result = carry + (int)(str.charAt(index--) - '0');
            carry = result / 2;
            result = result %2;
            sb.append((char)(result + (int) '0'));
        }
        if(carry != 0){
            sb.append((char)(carry + (int) '0'));
        }
        sb.reverse();
        return sb.toString();
    }
}
