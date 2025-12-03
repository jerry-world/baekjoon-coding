import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Integer[] array = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());

        int sum = 0;
        for (int i = m - 1; i < score.length; i += m) {
            sum += array[i] * m;
        }

        return sum;
    }
}