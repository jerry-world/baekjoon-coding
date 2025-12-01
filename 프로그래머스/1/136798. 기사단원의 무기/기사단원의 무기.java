import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        //각 번호의 약수 개수에 해당하는 공격력을 가진 무기 구매
        //이웃 나라와의 협약에의해 공격력은 제한됨 : limit
        //만약 제한수치보다 높은 무기를 구매할 경우, 협약기관에서 장한 공격력을 가지는 무기만 구매 가능

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int num = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) num++;
                else if (i % j == 0) num += 2;
            }
            list.add(num);
        }

        int sum = 0;
        for (Integer val : list) {
            sum += val > limit ? power : val;
        }
        //무기 공격력 1당 1kg 철이 필요. 모든 무기를 만들기위해 필요한 ㅊ철으 ㅣ무게 반환
        return sum;
    }

}
