class Solution {
    public int solution(int n) {
        int answer = 0;

        String binaryString = Integer.toBinaryString(n);
        int originCount = 0;
        for (char c : binaryString.toCharArray()) {
            if(c == '1') originCount++;
        }
        int next = n + 1;
        while (true) {
            int count = 0;
            String binaryString1 = Integer.toBinaryString(next);
            for (char c : binaryString1.toCharArray()) {
                if(c == '1') count++;
            }
            if(originCount==count) return next;
            next++;
        }
    }
}