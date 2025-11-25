import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        if (people.length == 1) {
            if (limit > people[0]) return 1;
            else return 0;
        }

        int cnt = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            cnt++;
        }
        return cnt;
    }
}