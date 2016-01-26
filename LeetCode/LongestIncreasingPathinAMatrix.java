int[] dx = new int [] {0, 0, 1, -1};
    int[] dy = new int [] {1,-1, 0, 0};
    int [][] memo;
    int n, m;
    int [][]matrix;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        this.matrix = matrix;   
        n = matrix.length;
        m = matrix[0].length;
        this.memo = new int [n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                memo[i][j] = -1;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0;  j< m; j++){
                max = Math.max(longestIncreasingPath(i, j), max);
            }
        }
        return max;
    }
    
    public int longestIncreasingPath(int i, int j){
        
        if(memo[i][j] == -1) {
            int max = 0;
            for(int k = 0; k < dx.length; k++){
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if(newX < 0 || newX >= n || newY < 0 || newY >= m)
                        continue;
                    if(matrix[i][j] < matrix[newX][newY])    
                        max = Math.max(max, longestIncreasingPath(newX, newY));
            }
            memo[i][j] = 1+max;
        }
        return memo[i][j];
    }
