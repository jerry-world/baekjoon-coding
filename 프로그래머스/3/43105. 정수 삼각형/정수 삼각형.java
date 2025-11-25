class Solution {
    public int solution(int[][] triangle) {
        //좌측끝, 우측끝 계산후, 가운데 계산
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] = triangle[i][0] + triangle[i - 1][0];
            triangle[i][i] = triangle[i][i] + triangle[i-1][i-1];
             for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        

        int max = 0;
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            max = Math.max(max, triangle[triangle.length - 1][i]);
        }

        return max;
    }
}