import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] arr = new int[size][size];
        //삼각형 배열 만들기
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        //점화
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) arr[i][j] += arr[i - 1][j];//왼쪽
                else if(j == i) arr[i][j] += arr[i - 1][j - 1]; // 오른쪽
                else arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]); // 가운데(현재 위치에서 왼쪽위 또는 오른쪽 위가 큰쪽을 더함
            }
        }

        int max = 0;
        for (int i = 0; i < arr[size-1].length; i++) {
            max = Math.max(max, arr[size-1][i]);
        }
        System.out.println(max);
    }
}
