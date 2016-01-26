public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        s = s.trim();    
        char [] arr = s.toCharArray();
        int n = arr.length;
        int end = n-1;
        while(end >= 0 && !isChar(arr[end])){
            end --;
        }
        reverseArray(arr, 0, end);
        int start = 0;
        for(int i = 0; i < end; i++){
            if(!isChar(arr[i])){
                reverseArray(arr, start, i-1);
                start = i+1;
            }
        }
        reverseArray(arr, start, end);
        int i = 0;
        int writeInd = 0;
        while(i < n){
            while(arr[i] == ' ' && (i == 0 || arr[i-1] == ' ')){
                i++;
            }
            if(i < n)
                arr[writeInd++] = arr[i++];
        }
        char [] newArr = new char[writeInd];
        for(i = 0; i < newArr.length; i++)
            newArr[i] = arr[i];
        return new String(newArr);
    }
    
    public void reverseArray(char[] arr, int st, int end){
        int i = st;
        int j = end;
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
    private boolean isChar(char curChar){
        return curChar != ' ';
    }
