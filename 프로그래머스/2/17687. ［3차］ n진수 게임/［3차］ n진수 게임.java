import java.util.*;

class Solution {

    public String solution(int n, int t, int m, int p) {
        //n: 진법, t: 미리 구할 숫자 갯수, m 참여인원, p 튜브 순서
        //진법 나열
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (sb.length() < t * m)
            sb.append(Integer.toString(idx++, n));

        String string = sb.toString().toUpperCase();
        sb = new StringBuilder();
        for (int i = p - 1; i < string.length(); i += m) {
            sb.append(string.charAt(i));
            if(sb.length()==t) break;
        }

        return sb.toString();
    }

    
}
