class Solution {
    public int solution(int[] wallet, int[] bill) {
        int wx = wallet[0];
        int wy = wallet[1];

        int bx = bill[0];
        int by = bill[1];

        int count = 0;
        while (true) {
            if ((wx >= bx && wy >= by) || (wx >= by && wy >= bx)) return count;

            count++;
            if(bx>by){
                bx /= 2;
            }else{
                by /= 2;
            }
        }
    }
}