    public String countAndSay(int n) {
        if(n <= 0)
            return "";
        String curStr = "1";
        int counter = 1;
        while(counter < n){
            int start = 0;
            int end = 0;
            StringBuilder sb = new StringBuilder();
            while(end < curStr.length()){
                while(end < curStr.length() && curStr.charAt(start) == curStr.charAt(end)){
                	end++;
                }
                int val = (int)(curStr.charAt(start) - '0');
                sb.append(end - start);
                sb.append(val);
                start = end;
            }
            curStr = sb.toString();
            counter ++;
        }
        return curStr;
    }
